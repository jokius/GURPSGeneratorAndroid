package ru.gurps.generator.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.models.Character;
import ru.gurps.generator.android.models.characters.CharactersFeature;
import ru.gurps.generator.android.models.rules.Feature;
import ru.gurps.generator.android.singletons.CharacterSingleton;

public class FeaturesAdapter extends ArrayAdapter<Feature> {
    private Context mContext;
    private ViewHolder holder;
    private Character character = CharacterSingleton.getInstance().getCharacter();
    private Feature feature;
    private CharactersFeature characterFeature;

    public FeaturesAdapter(Context mContext, ArrayList<Feature> features) {
        super(mContext, R.layout.list_item_feature, features);
        this.mContext = mContext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_feature, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.nameEn = (TextView) convertView.findViewById(R.id.nameEn);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.cost = (TextView) convertView.findViewById(R.id.cost);
            holder.add = (CheckBox) convertView.findViewById(R.id.add);
            holder.full = (Button) convertView.findViewById(R.id.full);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        setHolders(position);
        setActions(position);
        return convertView;
    }

    private void setHolders(int position) {
        feature = getItem(position);
        characterFeature = character.findCharacterFeature(mContext, feature._id);
        holder.name.setText(feature.name);
        holder.nameEn.setText(feature.nameEn);
        holder.type.setText(feature.getFeatureType(mContext));
        holder.cost.setText(String.format("%d", feature.cost));
        holder.add.setChecked(characterFeature._id != null);
    }

    private void setActions(final int position) {
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = ((CheckBox) v).isChecked();
                feature = getItem(position);
                characterFeature = character.findCharacterFeature(mContext, feature._id);

                Integer cost = feature.cost;
                if (isChecked) {
                    characterFeature = (CharactersFeature) new CharactersFeature(mContext,
                            character._id, feature._id, cost, 1).create();
                } else {
                    cost = -characterFeature.cost;
                    characterFeature.delete();
                }

                character.currentPoints = character.currentPoints + cost;
                character.save();
            }
        });

        holder.full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feature = getItem(position);
                Toast.makeText(mContext.getApplicationContext(),
                        mContext.getResources().getString(R.string.delete_single) +
                                " " + feature._id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    static class ViewHolder {
        TextView name;
        TextView nameEn;
        TextView type;
        TextView cost;
        CheckBox add;
        Button full;
    }
}
