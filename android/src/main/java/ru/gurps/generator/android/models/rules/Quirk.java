package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Quirk extends Model {
    public long _id;
    public String name;
    @Ignore public Integer cost = 0;
    @Ignore public Boolean add = false;

    public Quirk(Context context) {
        super(context);
    }

    public Quirk(Context context, String name) {
        super(context);
        this.name = name;
    }
}
