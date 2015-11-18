package ru.gurps.generator.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.models.rules.Feature;

public class FeaturesAdapter extends ArrayAdapter<Feature> {
    private Context mContext;
    public FeaturesAdapter(Context mContext, ArrayList<Feature> features){
        super(mContext, R.layout.list_item_feature, features);
        this.mContext = mContext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_feature, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.nameEn = (TextView) convertView.findViewById(R.id.nameEn);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.cost = (TextView) convertView.findViewById(R.id.cost);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            convertView.setTag(holder);
        }
        else holder = (ViewHolder) convertView.getTag();

        Feature feature = getItem(position);
        holder.name.setText(feature.name);
        holder.nameEn.setText(feature.nameEn);
        holder.type.setText(feature.getFeatureType());
        holder.cost.setText(String.format("%d", feature.cost));
        holder.description.setText(feature.description);

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView nameEn;
        TextView type;
        TextView cost;
        TextView description;
    }
}
