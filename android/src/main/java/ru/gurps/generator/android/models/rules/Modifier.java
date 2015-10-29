package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Modifier extends Model {
    public Long _id;
    public String name;
    public String nameEn;
    public Integer cost;
    public String description;
    public Integer maxLevel;
    public Boolean combat;
    public Boolean improving;
    @Ignore public Integer level;

    public Modifier(Context context) {
        super(context);
    }

    public Modifier(Context context, Long _id, String name, String nameEn, Integer cost,
                    String description, Integer maxLevel, Boolean combat,
                    Boolean improving, Integer level) {
        super(context);
        this._id = _id;
        this.name = name;
        this.nameEn = nameEn;
        this.cost = cost;
        this.description = description;
        this.maxLevel = maxLevel;
        this.combat = combat;
        this.improving = improving;
        this.level = level;
    }
}
