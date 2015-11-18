package ru.gurps.generator.android.models;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

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
}
