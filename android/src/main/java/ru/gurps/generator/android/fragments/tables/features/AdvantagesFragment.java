package ru.gurps.generator.android.fragments.tables.features;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.gurps.generator.android.R;

public class AdvantagesFragment extends FeaturesFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feature, container, false);
        setup(true);
        return view;
    }
}