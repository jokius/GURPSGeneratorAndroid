package ru.gurps.generator.android.adapters.features;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Range;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.helpers.CharacterParamsHelper;
import ru.gurps.generator.android.helpers.DmgHelper;
import ru.gurps.generator.android.models.Character;
import ru.gurps.generator.android.models.characters.CharactersAddon;
import ru.gurps.generator.android.models.characters.CharactersFeature;
import ru.gurps.generator.android.models.rules.Addon;
import ru.gurps.generator.android.singletons.CharacterSingleton;

public class AddonsAdapter extends ArrayAdapter<Addon> {
    private Context mContext;
    private ViewHolder holder;
    private Character character = CharacterSingleton.getInstance().getCharacter();
    private Addon addon;
    private CharactersAddon characterAddon;

    public AddonsAdapter(Context mContext, ArrayList<Addon> addons) {
        super(mContext, R.layout.list_item_addon, addons);
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
            holder.levelString = (TextView) convertView.findViewById(R.id.levelString);
            holder.levelEdit = (EditText) convertView.findViewById(R.id.levelEdit);
            holder.levelSpinner = (Spinner) convertView.findViewById(R.id.levelSpinner);
            holder.costString = (TextView) convertView.findViewById(R.id.costString);
            holder.costEdit = (EditText) convertView.findViewById(R.id.costEdit);
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
        addon = getItem(position);
        holder.name.setText(addon.name);
        holder.nameEn.setText(addon.nameEn);
        setCharacterAddon();
        setLevel();
        setCost();
    }

    private void setCharacterAddon(){
        characterAddon = character.findCharacterAddon(mContext, addon._id);
        if(characterAddon._id == null) holder.add.setChecked(false);
        else {
            holder.add.setChecked(true);
            addon.level = characterAddon.level;
            addon.resultCost = characterAddon.cost;
        }
    }

    private void setLevel(){
        if(addon.maxLevel == 0) holder.levelEdit.setVisibility(View.VISIBLE);
        else if(addon.maxLevel == 1) holder.levelString.setVisibility(View.VISIBLE);
        else if(addon.maxLevel > 1){
            Integer levels[] = new Integer[addon.maxLevel - 1];
            for(Integer i = 1; addon.maxLevel >= i; i++) levels[i - 1] = i;
            ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(mContext,
                    android.R.layout.simple_spinner_item, levels);

            holder.levelSpinner.setAdapter(adapter);
            holder.levelSpinner.setSelection(addon.level - 1);
            holder.levelSpinner.setVisibility(View.VISIBLE);
        }
    }

    private void setCost(){
        if(addon.cost == 0) holder.costEdit.setVisibility(View.VISIBLE);
        else {
            holder.costString.setText(String.format("%d",
                    addon.resultCost == 0 ? addon.cost : addon.resultCost));
            holder.costString.setVisibility(View.VISIBLE);
        }
    }

    private void setActions(final int position) {
        holder.levelSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(addon.level - 1 == position) return;
                addon.level = position + 1;
            }
        });

        holder.levelEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (addon.level.equals(intValue)) return;
                addon.level = intValue;
            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = ((CheckBox) v).isChecked();
                addon = getItem(position);
                characterAddon = character.findCharacterAddon(mContext, addon._id);

                int cost = addon.cost * addon.level;
                addon.resultCost = cost;
                if (isChecked) {
                    characterAddon = (CharactersAddon) new CharactersAddon(mContext,
                            character._id, addon.featureId, addon._id, cost, addon.level).create();
                } else {
                    cost = -characterAddon.cost;
                    characterAddon.delete();
                }

                character.currentPoints = character.currentPoints + cost;
                character.save();
            }
        });

        holder.full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addon = getItem(position);
                Toast.makeText(mContext.getApplicationContext(),
                        mContext.getResources().getString(R.string.delete_single) +
                                " " + addon._id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    static class ViewHolder {
        TextView name;
        TextView nameEn;
        TextView levelString;
        EditText levelEdit;
        Spinner levelSpinner;
        TextView costString;
        EditText costEdit;
        CheckBox add;
        Button full;
    }
}
