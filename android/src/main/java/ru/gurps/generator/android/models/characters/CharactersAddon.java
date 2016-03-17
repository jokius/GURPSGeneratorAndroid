package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersAddon extends Model {
    public Long _id;
    public Long characterId;
    public Long featureId;
    public Long addonId;
    public Integer cost;
    public Integer level;

    public CharactersAddon(Context context) {
        super(context);
    }

    public CharactersAddon(Context context, Long characterId, Long featureId, Long addonId, Integer cost, Integer level) {
        super(context);
        this.characterId = characterId;
        this.featureId = featureId;
        this.addonId = addonId;
        this.cost = cost;
        this.level = level;
    }
}
