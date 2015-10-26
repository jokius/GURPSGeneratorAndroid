package ru.gurps.generator.android.models;

import android.content.Context;

import ru.gurps.generator.android.db.Model;

public class Character extends Model {
    public long _id;
    public String player;
    public String name;
    public String currentPoints;
    public String maxPoints;
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

    public Character(Context context, String player, String name, String currentPoints,
                     String maxPoints, Integer st, Integer dx, Integer iq, Integer ht, Integer hp,
                     Integer will, Integer per, Integer fp, Double bs, Integer move, Integer sm,
                     Integer growth, Integer weight, Integer age, Integer tl, Integer tlCost,
                     Integer head, Integer torse, Integer arm, Integer leg, Integer hand,
                     Integer foot, Boolean noFineManipulators) {
        super(context);
        this.player = player;
        this.name = name;
        this.currentPoints = currentPoints;
        this.maxPoints = maxPoints;
        this.st = st;
        this.dx = dx;
        this.iq = iq;
        this.ht = ht;
        this.hp = hp;
        this.will = will;
        this.per = per;
        this.fp = fp;
        this.bs = bs;
        this.move = move;
        this.sm = sm;
        this.growth = growth;
        this.weight = weight;
        this.age = age;
        this.tl = tl;
        this.tlCost = tlCost;
        this.head = head;
        this.torse = torse;
        this.arm = arm;
        this.leg = leg;
        this.hand = hand;
        this.foot = foot;
        this.noFineManipulators = noFineManipulators;
    }
}
