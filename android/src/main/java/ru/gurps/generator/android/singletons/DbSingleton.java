package ru.gurps.generator.android.singletons;

import android.database.sqlite.SQLiteDatabase;

public class DbSingleton {
    private static DbSingleton mInstance = new DbSingleton();
    private SQLiteDatabase db;

    public static DbSingleton getInstance() {
        return mInstance;
    }

    private DbSingleton() {
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase sDb) {
        db = sDb;
    }
}
