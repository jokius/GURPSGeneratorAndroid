package ru.gurps.generator.android.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.fragments.tables.features.AdvantagesFragment;
import ru.gurps.generator.android.fragments.character.ParamsFragment;
import ru.gurps.generator.android.helpers.DeprecatedHelper;
import ru.gurps.generator.android.models.Character;
import ru.gurps.generator.android.singletons.CharacterSingleton;

public class MenuActivity extends AppCompatActivity {
    private DrawerLayout dlDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private EditText editMaxPoints;
    private TextView currentPoints;
    private Character character = CharacterSingleton.getInstance()
            .getCharacter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        setupDrawerContent(nvDrawer);
        drawerToggle = setupDrawerToggle();
        dlDrawer.setDrawerListener(drawerToggle);

        LayoutInflater inflater = getLayoutInflater();
        View headerLayout = inflater.inflate(R.layout.nav_header, null, false);
        nvDrawer.addHeaderView(headerLayout);

        currentPoints = (TextView) headerLayout.findViewById(R.id.currentPoints);
        editMaxPoints = (EditText) headerLayout.findViewById(R.id.editMaxPoints);
        editMaxPoints.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                character.maxPoints = Integer.parseInt(newValue.toString());
                character.save();
                setCurrentPointsColor();
            }
        });
        setDefault();
        setHeader();
    }

    private void setDefault() {
        nvDrawer.getMenu().getItem(0).setChecked(true);
        loadFragment(R.id.nav_params_fragment);
    }

    private void loadFragment(int id) {
        Fragment fragment = null;

        Class fragmentClass;
        switch (id) {
            case R.id.nav_params_fragment:
                fragmentClass = ParamsFragment.class;
                break;
            case R.id.nav_advantages_fragment:
                fragmentClass = AdvantagesFragment.class;
                break;
            default:
                fragmentClass = ParamsFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flContent, fragment)
                .commit();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, dlDrawer, toolbar,
                R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerStateChanged(int newState) {
                currentPoints.setText(String.format("%d", character.currentPoints));
                setCurrentPointsColor();
                super.onDrawerStateChanged(newState);
            }
        };
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        loadFragment(menuItem.getItemId());

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        dlDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void setCurrentPoints(int points) {
        currentPoints.setText(String.format("%d", points));
        character.currentPoints = points;
        character.save();
        setCurrentPointsColor();
    }

    public void setHeader(){
        currentPoints.setText(String.format("%d", character.currentPoints));
        editMaxPoints.setText(String.format("%d", character.maxPoints));
        setCurrentPointsColor();
    }

    private void setCurrentPointsColor(){
        if(character.currentPoints <= character.maxPoints)
            currentPoints.setTextColor(DeprecatedHelper.getColor(this, R.color.have_points));
        else currentPoints.setTextColor(DeprecatedHelper.getColor(this, R.color.not_have_points));
    }
}
