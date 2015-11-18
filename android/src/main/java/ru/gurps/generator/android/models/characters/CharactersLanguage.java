package ru.gurps.generator.android.models.characters;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class CharactersLanguage extends Model {
    public Long _id;
    public Integer characterId;
    public Integer languageId;
    public Integer spoken;
    public Integer written;
    public Integer cost;

    public CharactersLanguage(Context context) {
        super(context);
    }

    public CharactersLanguage(Context context, Integer characterId, Integer languageId,
                              Integer spoken, Integer written, Integer cost) {
        super(context);
        this.characterId = characterId;
        this.languageId = languageId;
        this.spoken = spoken;
        this.written = written;
        this.cost = cost;
    }
}
