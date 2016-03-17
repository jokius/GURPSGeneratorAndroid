package ru.gurps.generator.android.models;

import android.content.Context;

import java.util.HashMap;

import ru.gurps.generator.android.db.Model;
import ru.gurps.generator.android.models.characters.CharactersAddon;
import ru.gurps.generator.android.models.characters.CharactersFeature;

public class Character extends Model {
    public Long _id;
    public String player;
    public String name;
    public Integer currentPoints;
    public Integer maxPoints;
    public Integer st;
    public Integer dx;
    public Integer iq;
    public Integer ht;
    public Integer hp;
    public Integer will;
    public Integer per;
    public Integer fp;
    public Double bs;
    public Integer move;
    public Integer sm;
    public Integer growth;
    public Integer weight;
    public Integer age;
    public Integer tl;
    public Integer tlCost;
    public Integer head;
    public Integer torse;
    public Integer arm;
    public Integer leg;
    public Integer hand;
    public Integer foot;
    public Boolean noFineManipulators = false;

    public Character(Context context) {
        super(context);
    }

    public Character(Context context, String name, Integer maxPoints) {
        super(context);
        this.name = name;
        this.maxPoints = maxPoints;
    }

    public CharactersFeature findCharacterFeature(Context context, Long featureId){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("characterId", _id);
        params.put("featureId", featureId);
        return (CharactersFeature) new CharactersFeature(context).find_by(params);
    }

    public CharactersAddon findCharacterAddon(Context context, Long addonId){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("characterId", _id);
        params.put("addonId", addonId);
        return (CharactersAddon) new CharactersAddon(context).find_by(params);
    }
}
