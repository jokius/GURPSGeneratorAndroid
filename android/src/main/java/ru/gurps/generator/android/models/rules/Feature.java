package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Feature extends Model {
    public long _id;
    public Boolean advantage;
    public String name;
    public String nameEn;
    public String featureType;
    public Integer cost;
    public String description;
    @Ignore public Integer oldLevel;
    public Integer maxLevel;
    public Boolean psi;
    public Boolean cybernetic;
    @Ignore public Boolean add  = false;
    @Ignore public Boolean modifier  = false;

    public Feature(Context context) {
        super(context);
    }

    public Feature(Context context, long _id, Boolean advantage, String name, String nameEn,
                   String featureType, Integer cost, String description, Integer oldLevel,
                   Integer maxLevel, Boolean psi, Boolean cybernetic, Boolean add,
                   Boolean modifier) {
        super(context);
        this._id = _id;
        this.advantage = advantage;
        this.name = name;
        this.nameEn = nameEn;
        this.featureType = featureType;
        this.cost = cost;
        this.description = description;
        this.oldLevel = oldLevel;
        this.maxLevel = maxLevel;
        this.psi = psi;
        this.cybernetic = cybernetic;
        this.add = add;
        this.modifier = modifier;
    }
}
