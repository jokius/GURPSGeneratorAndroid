package ru.gurps.generator.android.activities.rules;

import android.app.ListActivity;
import android.os.Bundle;

import ru.gurps.generator.android.R;

public class FeatureActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);
    }
}
