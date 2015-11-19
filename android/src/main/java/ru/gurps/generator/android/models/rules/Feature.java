package ru.gurps.generator.android.models.rules;

import android.content.Context;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.db.Model;

public class Feature extends Model {
    public Long _id;
    public Boolean advantage;
    public String name;
    public String nameEn;
    public String featureType;
    public Integer cost;
    public String description;
    @Ignore public Integer oldLevel;
    public Integer maxLevel;
    public Boolean psi;
    public Boolean cybernetic;
    @Ignore public Boolean add  = false;
    @Ignore public Boolean modifier  = false;

    public Feature(Context context) {
        super(context);
    }

    public Feature(Context context, Long _id, Boolean advantage, String name, String nameEn,
                   String featureType, Integer cost, String description, Integer oldLevel,
                   Integer maxLevel, Boolean psi, Boolean cybernetic, Boolean add,
                   Boolean modifier) {
        super(context);
        this._id = _id;
        this.advantage = advantage;
        this.name = name;
        this.nameEn = nameEn;
        this.featureType = featureType;
        this.cost = cost;
        this.description = description;
        this.oldLevel = oldLevel;
        this.maxLevel = maxLevel;
        this.psi = psi;
        this.cybernetic = cybernetic;
        this.add = add;
        this.modifier = modifier;
    }

    public String getFeatureType(Context context) {
        String new_type = featureType;
        new_type = new_type.replace("[", "");
        new_type = new_type.replace("]", "");
        new_type = new_type.replace(",", "/ ");
        new_type = new_type.replace("1", context.getResources().getString(R.string.physical_short) + " ");
        new_type = new_type.replace("2", context.getResources().getString(R.string.social_short) + " ");
        new_type = new_type.replace("3", context.getResources().getString(R.string.mental_short) + " ");
        new_type = new_type.replace("4", context.getResources().getString(R.string.exotic_short) + " ");
        new_type = new_type.replace("5", context.getResources().getString(R.string.supernatural_short) + " ");
        return new_type;
    }
}
