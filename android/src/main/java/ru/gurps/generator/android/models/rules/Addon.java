package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Addon extends Model {
    public Long _id;
    public Long featureId;
    public String name;
    public String nameEn;
    public Integer cost;
    public String description;
    public Integer maxLevel;
    @Ignore public Integer level = 1;
    @Ignore public Boolean active = false;

    public Addon(Context context) {
        super(context);
    }

    public Addon(Context context, Long _id, Long featureId, String name, String nameEn,
                 Integer cost, String description, Integer maxLevel,
                 Integer level, Boolean active) {
        super(context);
        this._id = _id;
        this.featureId = featureId;
        this.name = name;
        this.nameEn = nameEn;
        this.cost = cost;
        this.description = description;
        this.maxLevel = maxLevel;
        this.level = level;
        this.active = active;
    }

    public Integer getResultCost() {
        return cost * level;
    }
}
