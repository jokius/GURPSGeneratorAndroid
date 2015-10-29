package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Cultura extends Model {
    public Long _id;
    public String name;
    @Ignore public Integer cost = 0;
    @Ignore public Boolean add = false;

    public Cultura(Context context) {
        super(context);
    }

    public Cultura(Context context, String name) {
        super(context);
        this.name = name;
    }
}
