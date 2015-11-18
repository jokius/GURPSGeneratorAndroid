package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersAddon extends Model {
    public Long _id;
    public Integer characterId;
    public Integer featureId;
    public Integer addonId;
    public String cost;
    public String level;

    public CharactersAddon(Context context) {
        super(context);
    }


    public CharactersAddon(Context context, Integer characterId, Integer featureId, Integer addonId,
                           String cost, String level) {
        super(context);
        this.characterId = characterId;
        this.featureId = featureId;
        this.addonId = addonId;
        this.cost = cost;
        this.level = level;
    }
}
