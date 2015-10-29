package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersTechnique extends Model {
    public Long _id;
    public Integer characterId;
    public Integer techniqueId;
    public Integer cost;
    public Integer level;

    public CharactersTechnique(Context context) {
        super(context);
    }

    public CharactersTechnique(Context context, Integer characterId, Integer techniqueId,
                               Integer cost, Integer level) {
        super(context);
        this.characterId = characterId;
        this.techniqueId = techniqueId;
        this.cost = cost;
        this.level = level;
    }
}
