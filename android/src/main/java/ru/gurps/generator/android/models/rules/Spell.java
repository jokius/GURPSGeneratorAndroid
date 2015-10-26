package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Spell extends Model {
    public long _id;
    public Integer school;
    public String name;
    public String nameEn;
    public Integer spellType;
    public String description;
    public Integer complexity;
    public Integer cost;
    public Integer maxCost;
    public String needTime;
    public String duration;
    public String maintainingCost;
    public String thing;
    public String createCost;
    public String demands;
    @Ignore public Integer level = 1;
    @Ignore public Integer finalCost = 0;
    @Ignore public Boolean add = false;

    public Spell(Context context) {
        super(context);
    }

    public Spell(Context context, long _id, Integer school, String name, String nameEn,
                 Integer spellType, String description, Integer complexity, Integer cost,
                 Integer maxCost, String needTime, String duration, String maintainingCost,
                 String thing, String createCost, String demands, Integer level, Integer finalCost,
                 Boolean add) {
        super(context);
        this._id = _id;
        this.school = school;
        this.name = name;
        this.nameEn = nameEn;
        this.spellType = spellType;
        this.description = description;
        this.complexity = complexity;
        this.cost = cost;
        this.maxCost = maxCost;
        this.needTime = needTime;
        this.duration = duration;
        this.maintainingCost = maintainingCost;
        this.thing = thing;
        this.createCost = createCost;
        this.demands = demands;
        this.level = level;
        this.finalCost = finalCost;
        this.add = add;
    }
}
