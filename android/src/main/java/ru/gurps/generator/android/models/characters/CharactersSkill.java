package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersSkill extends Model {
    public long _id;
    public Integer characterId;
    public Integer skillId;
    public Integer cost;
    public Integer level;

    public CharactersSkill(Context context) {
        super(context);
    }

    public CharactersSkill(Context context, Integer characterId, Integer skillId, Integer cost,
                           Integer level) {
        super(context);
        this.characterId = characterId;
        this.skillId = skillId;
        this.cost = cost;
        this.level = level;
    }
}
