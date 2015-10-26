package ru.gurps.generator.android.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.models.Character;

public class CharactersAdapter extends ArrayAdapter<Character> {
    private Context mContext;
    private ArrayList<Character> characters;

    public CharactersAdapter(Context mContext, ArrayList<Character> characters){
        super(mContext, android.R.layout.simple_list_item_2, characters);
        this.mContext = mContext;
        this.characters = characters;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(android.R.id.text1);
            holder.max_points = (TextView) convertView.findViewById(android.R.id.text2);
            convertView.setTag(holder);
        }
        else holder = (ViewHolder) convertView.getTag();

        Character character = getItem(position);
        holder.name.setText(character.name);
        holder.max_points.setText(String.format("%d", character.maxPoints));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(character.currentPoints <= character.maxPoints)
                holder.max_points.setTextColor(mContext.getResources()
                        .getColor(R.color.have_points, mContext.getTheme()));
            else holder.max_points.setTextColor(mContext.getResources()
                    .getColor(R.color.not_have_points, mContext.getTheme()));
        }
        else {
            if(character.currentPoints <= character.maxPoints)
                holder.max_points.setTextColor(mContext.getResources()
                        .getColor(R.color.have_points));
            else holder.max_points.setTextColor(mContext.getResources()
                    .getColor(R.color.not_have_points));
        }

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView max_points;
    }
}
