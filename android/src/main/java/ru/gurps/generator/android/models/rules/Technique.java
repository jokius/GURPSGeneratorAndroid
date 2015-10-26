package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Technique extends Model {
    public long _id;
    public String name;
    public String nameEn;
    public Integer complexity;
    public String defaultUse;
    public String demands;
    public String description;
    @Ignore public Integer cost = 1;
    @Ignore public Integer level = 1;
    @Ignore public Boolean add = false;

    public Technique(Context context) {
        super(context);
    }

    public Technique(Context context, long _id, String name, String nameEn, Integer complexity,
                     String defaultUse, String demands, String description, Integer cost,
                     Integer level, Boolean add) {
        super(context);
        this._id = _id;
        this.name = name;
        this.nameEn = nameEn;
        this.complexity = complexity;
        this.defaultUse = defaultUse;
        this.demands = demands;
        this.description = description;
        this.cost = cost;
        this.level = level;
        this.add = add;
    }
}
