package ru.gurps.generator.android.models;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Character extends Model {
    public long _id;
    public String player;
    public String name;
    public Integer currentPoints;
    public Integer maxPoints;
    public Integer st = 10;
    public Integer dx = 10;
    public Integer iq = 10;
    public Integer ht = 10;
    public Integer hp = 10;
    public Integer will = 10;
    public Integer per = 10;
    public Integer fp = 10;
    public Double bs = 5.0;
    public Integer move = 5;
    public Integer sm = 0;
    public Integer growth = 0;
    public Integer weight = 0;
    public Integer age = 0;
    public Integer tl = 0;
    public Integer tlCost = 0;
    public Integer head = 0;
    public Integer torse = 0;
    public Integer arm = 0;
    public Integer leg = 0;
    public Integer hand = 0;
    public Integer foot = 0;
    public Boolean noFineManipulators = false;

    public Character(Context context) {
        super(context);
    }

    public Character(Context context, String name, Integer maxPoints) {
        super(context);
        this.name = name;
        this.maxPoints = maxPoints;
    }
}
