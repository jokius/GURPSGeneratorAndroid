package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersQuirk extends Model {
    public Long _id;
    public Integer characterId;
    public Integer quirkId;
    public Integer cost;

    public CharactersQuirk(Context context) {
        super(context);
    }

    public CharactersQuirk(Context context, Integer characterId, Integer quirkId, Integer cost) {
        super(context);
        this.characterId = characterId;
        this.quirkId = quirkId;
        this.cost = cost;
    }
}
