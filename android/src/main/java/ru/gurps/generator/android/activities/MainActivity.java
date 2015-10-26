package ru.gurps.generator.android.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.models.rules.Spell;


public class MainActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Spells", new Spell(this).all().toString());
//        setContentView(R.layout.activity_main);
    }
}
