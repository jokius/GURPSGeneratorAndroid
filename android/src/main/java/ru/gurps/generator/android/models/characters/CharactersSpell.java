package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersSpell extends Model {
    public Long _id;
    public Integer characterId;
    public Integer spellId;
    public Integer level;
    public Integer cost;

    public CharactersSpell(Context context) {
        super(context);
    }

    public CharactersSpell(Context context, Integer characterId, Integer spellId, Integer level,
                           Integer cost) {
        super(context);
        this.characterId = characterId;
        this.spellId = spellId;
        this.level = level;
        this.cost = cost;
    }
}
