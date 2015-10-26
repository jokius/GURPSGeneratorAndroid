package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersSpecialization extends Model {
    public long _id;
    public Integer characterId;
    public Integer specializationId;
    public Integer cost;
    public Integer level;

    public CharactersSpecialization(Context context) {
        super(context);
    }

    public CharactersSpecialization(Context context, Integer characterId, Integer specializationId,
                                    Integer cost, Integer level) {
        super(context);
        this.characterId = characterId;
        this.specializationId = specializationId;
        this.cost = cost;
        this.level = level;
    }
}
