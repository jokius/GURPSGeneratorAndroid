package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersCultura extends Model {
    public long _id;
    public Integer characterId;
    public Integer culturaId;
    public Integer cost;

    public CharactersCultura(Context context) {
        super(context);
    }

    public CharactersCultura(Context context, Integer characterId, Integer culturaId,
                             Integer cost) {
        super(context);
        this.characterId = characterId;
        this.culturaId = culturaId;
        this.cost = cost;
    }
}
