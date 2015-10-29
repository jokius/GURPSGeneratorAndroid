package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Language extends Model {
    public Long _id;
    public String name;
    @Ignore public Integer spoken = 0;
    @Ignore public Integer written = 0;
    @Ignore public Integer cost = 0;
    @Ignore public Boolean add = false;

    public Language(Context context) {
        super(context);
    }

    public Language(Context context, String name) {
        super(context);
        this.name = name;
    }
}
