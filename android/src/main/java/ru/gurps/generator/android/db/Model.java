package ru.gurps.generator.android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static java.lang.annotation.ElementType.FIELD;

public class Model extends DatabaseHelper {
    Context context;

    @Target(FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ignore {
    }

    protected String table = this.getClass().getSimpleName() + "s";

    public Model(Context context) {
        super(context);
        this.context = context;
    }

    public Model create() {
        long id = db().insert(table, null, cv());
        Cursor cursor = db().query(table, null, "_id = " + id, null, null, null, null);
        cursor.moveToFirst();
        return setModel(cursor);
    }

    public ArrayList all() {
        ArrayList list = new ArrayList();
        Cursor cursor = db().rawQuery("SELECT * FROM " + table, null);
        while (cursor.moveToNext()) {
            list.add(setModel(cursor));
        }
        return list;
    }

    public boolean delete() {
        db().delete(table, "_id=" + id(), null);
        return true;
    }

    public boolean save() {
        db().update(table, cv(), "_id = ?", new String[]{Long.toString(id())});
        return true;
    }

    public boolean update_single(String key, Object value){
        db().execSQL("UPDATE " + table + " SET " + key + "='" + value + "' WHERE _id=" + id());
        return true;
    }

    private ContentValues cv() {
        ContentValues cv = new ContentValues();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Ignore.class)) continue;
            try {
                if (field.get(this) == null || field.getName().equals("_id")) continue;
                if (String.class.isAssignableFrom(field.getType()))
                    cv.put(field.getName(), (String) field.get(this));
                else if (Integer.class.isAssignableFrom(field.getType())) {
                    cv.put(field.getName(), (Integer) field.get(this));
                }
                else if (Double.class.isAssignableFrom(field.getType()))
                    cv.put(field.getName(), (Double) field.get(this));
                else if (Boolean.class.isAssignableFrom(field.getType()))
                    cv.put(field.getName(), (Boolean) field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return cv;
    }

    private Model setModel(Cursor cursor) {
        Model model = this;
        try {
            model = this.getClass().getDeclaredConstructor(Context.class).newInstance(context);
            for (Field field : model.getClass().getDeclaredFields()) {
                if (!field.isAnnotationPresent(Ignore.class)) {
                    if (String.class.isAssignableFrom(field.getType()))
                        field.set(model, cursor.getString(cursor.getColumnIndexOrThrow(field.getName())));
                    else if (Integer.class.isAssignableFrom(field.getType()))
                        field.set(model, cursor.getInt(cursor.getColumnIndexOrThrow(field.getName())));
                    else if (Double.class.isAssignableFrom(field.getType()))
                        field.set(model, cursor.getDouble(cursor.getColumnIndexOrThrow(field.getName())));
                    else if (Boolean.class.isAssignableFrom(field.getType()))
                        field.set(model, cursor.getInt(cursor.getColumnIndexOrThrow(field.getName())) > 0);
                    else if (Long.class.isAssignableFrom(field.getType())) {
                        field.set(model, cursor.getLong(cursor.getColumnIndexOrThrow(field.getName())));
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return model;
    }

    private long id() {
        try {
            return (Long) this.getClass().getDeclaredField("_id").get(this);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return -1;
    }
}