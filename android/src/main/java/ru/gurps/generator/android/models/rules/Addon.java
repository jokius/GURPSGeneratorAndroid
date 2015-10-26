package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Addon extends Model {
    public long _id;
    public Integer featureId;
    public String name;
    public String nameEn;
    public String cost;
    @Ignore public Integer resultCost = 0;
    public String description;
    public Integer maxLevel;
    @Ignore public String level = "1";
    @Ignore public Boolean active = false;

    public Addon(Context context) {
        super(context);
    }

    public Addon(Context context, long _id, Integer featureId, String name, String nameEn,
                 String cost, Integer resultCost, String description, Integer maxLevel,
                 String level, Boolean active) {
        super(context);
        this._id = _id;
        this.featureId = featureId;
        this.name = name;
        this.nameEn = nameEn;
        this.cost = cost;
        this.resultCost = resultCost;
        this.description = description;
        this.maxLevel = maxLevel;
        this.level = level;
        this.active = active;
    }
}
