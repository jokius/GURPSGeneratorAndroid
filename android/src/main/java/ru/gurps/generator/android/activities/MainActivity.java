package ru.gurps.generator.android.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.adapters.CharactersAdapter;
import ru.gurps.generator.android.models.Character;

public class MainActivity extends ListActivity {
    private Character character;
    EditText character_name;
    EditText max_points;

    private Button create;
    private Button select;
    private Button delete;
    private View last_view;
    private int default_color;
    private CharactersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        character_name = (EditText) findViewById(R.id.character_name);
        max_points = (EditText) findViewById(R.id.max_points);

        create = (Button) findViewById(R.id.create);
        select = (Button) findViewById(R.id.select);
        delete = (Button) findViewById(R.id.delete);

        adapter = new CharactersAdapter(this, new Character(this).all());
        setListAdapter(adapter);

        character_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (max_points.getText().toString().equals("")) return;
                create.setEnabled(true);
            }
        });

        max_points.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (character_name.getText().toString().equals("") || max_points.getText()
                        .toString().equals("")) return;
                create.setEnabled(true);
            }
        });
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        character = (Character) getListAdapter().getItem(position);
        if (last_view == null) {
            last_view = v;
            default_color = v.getDrawingCacheBackgroundColor();
        } else {
            last_view.setBackgroundColor(default_color);
            last_view = v;
        }

        v.setBackgroundColor(getResources().getColor(R.color.select_color));
        select.setEnabled(true);
        delete.setEnabled(true);
    }

    public void onCreate(View view) {
        character = (Character) new Character(this, character_name.getText().toString(),
                Integer.parseInt(max_points.getText().toString())).create();
        Toast.makeText(getApplicationContext(), "Создан " + character.name, Toast.LENGTH_SHORT).show();
    }

    public void onSelect(View view) {
        Toast.makeText(getApplicationContext(), "Выбран " + character.name, Toast.LENGTH_SHORT).show();
    }

    public void onDelete(View view) {
        character.delete();
        adapter.remove(character);
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.delete_single) + " " + character.name, Toast.LENGTH_SHORT).show();
    }
}
