package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Skill extends Model {
    public long _id;
    public String name;
    public String nameEn;
    public Integer skillType;
    public Integer complexity;
    public String defaultUse;
    public String demands;
    public String description;
    public String modifiers;
    public Boolean twoHands = false;
    public Boolean parry = false;
    public Integer parryBonus = 0;
    @Ignore public Integer cost = 1;
    @Ignore public Integer level = 1;
    @Ignore public Boolean add = false;

    public Skill(Context context) {
        super(context);
    }

    public Skill(Context context, long _id, String name, String nameEn, Integer skillType,
                 Integer complexity, String defaultUse, String demands, String description,
                 String modifiers, Boolean twoHands, Boolean parry, Integer parryBonus,
                 Integer cost, Integer level, Boolean add) {
        super(context);
        this._id = _id;
        this.name = name;
        this.nameEn = nameEn;
        this.skillType = skillType;
        this.complexity = complexity;
        this.defaultUse = defaultUse;
        this.demands = demands;
        this.description = description;
        this.modifiers = modifiers;
        this.twoHands = twoHands;
        this.parry = parry;
        this.parryBonus = parryBonus;
        this.cost = cost;
        this.level = level;
        this.add = add;
    }
}
