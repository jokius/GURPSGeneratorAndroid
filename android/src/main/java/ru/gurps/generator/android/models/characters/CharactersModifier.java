package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersModifier extends Model {
    public Long _id;
    public Integer characterId;
    public Integer modifierId;
    public Integer featureId;
    public Integer cost;
    public Integer level;

    public CharactersModifier(Context context) {
        super(context);
    }

    public CharactersModifier(Context context, Integer characterId, Integer modifierId,
                              Integer featureId, Integer cost, Integer level) {
        super(context);
        this.characterId = characterId;
        this.modifierId = modifierId;
        this.featureId = featureId;
        this.cost = cost;
        this.level = level;
    }
}
