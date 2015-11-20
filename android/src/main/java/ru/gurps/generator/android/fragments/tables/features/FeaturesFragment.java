package ru.gurps.generator.android.fragments.tables.features;

import android.support.v4.app.ListFragment;
import android.support.v7.widget.Toolbar;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.adapters.FeaturesAdapter;
import ru.gurps.generator.android.models.rules.Feature;

public class FeaturesFragment extends ListFragment {
    protected void setup(boolean isAdvantage){
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);


        toolbar.setTitle(isAdvantage ? R.string.advantages : R.string.disadvantages);
        FeaturesAdapter adapter = new FeaturesAdapter(getContext(),
                new Feature(getContext()).where("advantage", isAdvantage ? 1 : 0));
        setListAdapter(adapter);
    }
}
