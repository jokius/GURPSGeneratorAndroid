package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersFeature extends Model {
    public Long _id;
    public Integer characterId;
    public Integer featureId;
    public Integer cost;
    public Integer level;

    public CharactersFeature(Context context) {
        super(context);
    }

    public CharactersFeature(Context context, Integer characterId, Integer featureId, Integer cost,
                             Integer level) {
        super(context);
        this.characterId = characterId;
        this.featureId = featureId;
        this.cost = cost;
        this.level = level;
    }
}
