package ru.gurps.generator.android.fragments.character;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.activities.MenuActivity;
import ru.gurps.generator.android.helpers.CharacterParamsHelper;
import ru.gurps.generator.android.helpers.DmgHelper;
import ru.gurps.generator.android.models.Character;
import ru.gurps.generator.android.singletons.CharacterSingleton;

public class ParamsFragment extends Fragment {
    private Character character = CharacterSingleton.getInstance()
            .getCharacter();

    private View view;

    private EditText characterNameEdit;
    private EditText playerNameEdit;
    private EditText growthEdit;
    private EditText weightEdit;
    private EditText ageEdit;
    private EditText tlEdit;
    private EditText tlCostEdit;
    private EditText smEdit;
    private CheckBox noFineManipulators;
    private EditText stEdit;
    private EditText dxEdit;
    private EditText iqEdit;
    private EditText htEdit;
    private TextView stCost;
    private TextView dxCost;
    private TextView iqCost;
    private TextView htCost;
    private EditText hpEdit;
    private EditText willEdit;
    private EditText perEdit;
    private EditText fpEdit;
    private TextView hpCost;
    private TextView willCost;
    private TextView perCost;
    private TextView fpCost;
    private EditText bsEdit;
    private TextView bsCost;
    private EditText moveEdit;
    private TextView moveCost;
    private TextView bl;
    private TextView doge;
    private TextView damageThrust;
    private TextView damageSwing;

    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_params, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.character_params);

        setElements();
        setCharacterParams();
        return view;
    }

    private void setCharacterParams() {
        smEdit.setText(String.format("%d", character.sm));
        noFineManipulators.setSelected(character.noFineManipulators);

        stEdit.setText(String.format("%d", character.st));
        dxEdit.setText(String.format("%d", character.dx));
        iqEdit.setText(String.format("%d", character.iq));
        htEdit.setText(String.format("%d", character.ht));

        hpEdit.setText(String.format("%d", character.hp));
        willEdit.setText(String.format("%d", character.will));
        perEdit.setText(String.format("%d", character.per));
        fpEdit.setText(String.format("%d", character.fp));

        bsEdit.setText(String.format("%.2f", character.bs));
        moveEdit.setText(String.format("%d", character.move));

        characterNameEdit.setText(character.name);
        playerNameEdit.setText(character.player);
        growthEdit.setText(String.format("%d", character.growth));
        weightEdit.setText(String.format("%d", character.weight));
        ageEdit.setText(String.format("%d", character.age));

        tlEdit.setText(String.format("%d", character.tl));
        tlCostEdit.setText(String.format("%d", character.tlCost));

        stCost.setText(String.format("%d", CharacterParamsHelper.stCost()));
        dxCost.setText(String.format("%d", CharacterParamsHelper.dxCost()));
        iqCost.setText(String.format("%d", CharacterParamsHelper.iqCost()));
        htCost.setText(String.format("%d", CharacterParamsHelper.htCost()));

        hpCost.setText(String.format("%d", CharacterParamsHelper.hpCost()));
        willCost.setText(String.format("%d", CharacterParamsHelper.willCost()));
        perCost.setText(String.format("%d", CharacterParamsHelper.perCost()));
        fpCost.setText(String.format("%d", CharacterParamsHelper.fpCost()));

        bsCost.setText(String.format("%d", CharacterParamsHelper.bsCost()));
        moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));

        bl.setText(String.format("%d", CharacterParamsHelper.bl()));
        doge.setText(String.format("%d", CharacterParamsHelper.doge()));

        damageThrust.setText(DmgHelper.damageThrust(character.st));
        damageSwing.setText(DmgHelper.damageSwing(character.st));

        textEvents();
    }

    protected void textEvents() {
        smSet();
        setNoFineManipulators();
        stSet();
        dxSet();
        iqSet();
        htSet();
        hpSet();
        willSet();
        perSet();
        fpSet();
        bsSet();
        moveSet();
        nameSet();
        playerSet();
        tlSet();
        tlCostSet();
        growthSet();
        weightSet();
    }

    private void smSet() {
        smEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.sm.equals(intValue)) return;
                character.sm = intValue;
                int oldStCost = Integer.parseInt(stCost.getText().toString());
                stCost.setText(String.format("%d", CharacterParamsHelper.stCost()));
                currentPoints(CharacterParamsHelper.stCost(), oldStCost);
                int oldHpCost = Integer.parseInt(hpCost.getText().toString());
                hpCost.setText(String.format("%d", CharacterParamsHelper.hpCost()));
                currentPoints(CharacterParamsHelper.hpCost(), oldHpCost);
            }
        });
    }

    private void setNoFineManipulators() {
        noFineManipulators.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                character.noFineManipulators = isChecked;
                int oldStCost = Integer.parseInt(stCost.getText().toString());
                stCost.setText(String.format("%d", CharacterParamsHelper.stCost()));
                currentPoints(CharacterParamsHelper.stCost(), oldStCost);

                int oldDxCost = Integer.parseInt(dxCost.getText().toString());
                dxCost.setText(String.format("%d", CharacterParamsHelper.dxCost()));
                currentPoints(CharacterParamsHelper.dxCost(), oldDxCost);
            }
        });
    }

    private void stSet() {
        stEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.st.equals(intValue)) return;
                character.st = intValue;
                if (intValue > character.hp) {
                    character.hp = intValue;
                    hpEdit.setText(newValue.toString());
                }

                int oldStCost = Integer.parseInt(stCost.getText().toString());
                stCost.setText(String.format("%d", CharacterParamsHelper.stCost()));
                currentPoints(CharacterParamsHelper.stCost(), oldStCost);

                int oldHpCost = Integer.parseInt(hpCost.getText().toString());
                hpCost.setText(String.format("%d", CharacterParamsHelper.hpCost()));
                currentPoints(CharacterParamsHelper.hpCost(), oldHpCost);

                bl.setText(String.format("%d", CharacterParamsHelper.bl()));
                damageThrust.setText(DmgHelper.damageThrust(character.st));
                damageSwing.setText(DmgHelper.damageSwing(character.st));
            }
        });
    }


    private void dxSet() {
        dxEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.dx.equals(intValue)) return;
                character.dx = intValue;

                int oldDxCost = Integer.parseInt(dxCost.getText().toString());
                dxCost.setText(String.format("%d", CharacterParamsHelper.dxCost()));
                currentPoints(CharacterParamsHelper.dxCost(), oldDxCost);

                int oldBsCost = Integer.parseInt(bsCost.getText().toString());
                bsCost.setText(String.format("%d", CharacterParamsHelper.bsCost()));
                currentPoints(CharacterParamsHelper.bsCost(), oldBsCost);

                int oldMoveCost = Integer.parseInt(moveCost.getText().toString());
                moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));
                currentPoints(CharacterParamsHelper.moveCost(), oldMoveCost);

                doge.setText(String.format("%d", CharacterParamsHelper.doge()));
            }
        });
    }

    private void iqSet() {
        iqEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.iq.equals(intValue)) return;
                character.iq = intValue;

                int oldIqCost = Integer.parseInt(iqCost.getText().toString());
                iqCost.setText(String.format("%d", CharacterParamsHelper.iqCost()));
                currentPoints(CharacterParamsHelper.iqCost(), oldIqCost);

                if (intValue > character.will) {
                    character.will = intValue;
                    willEdit.setText(String.format("%d", character.will));
                }

                if (intValue > character.per) {
                    character.per = intValue;
                    perEdit.setText(String.format("%d", character.per));
                }

                int oldWillCost = Integer.parseInt(willCost.getText().toString());
                willCost.setText(String.format("%d", CharacterParamsHelper.willCost()));
                currentPoints(CharacterParamsHelper.willCost(), oldWillCost);

                int oldPerCost = Integer.parseInt(perCost.getText().toString());
                perCost.setText(String.format("%d", CharacterParamsHelper.perCost()));
                currentPoints(CharacterParamsHelper.perCost(), oldPerCost);
            }
        });
    }

    private void htSet() {
        htEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.ht.equals(intValue)) return;
                character.ht = intValue;

                int oldHtCost = Integer.parseInt(htCost.getText().toString());
                htCost.setText(String.format("%d", CharacterParamsHelper.htCost()));
                currentPoints(CharacterParamsHelper.htCost(), oldHtCost);

                if (intValue > character.fp) {
                    character.fp = intValue;
                    fpEdit.setText(String.format("%d", character.fp));
                }

                int oldFpCost = Integer.parseInt(fpCost.getText().toString());
                fpCost.setText(String.format("%d", CharacterParamsHelper.fpCost()));
                currentPoints(CharacterParamsHelper.fpCost(), oldFpCost);

                int oldBsCost = Integer.parseInt(bsCost.getText().toString());
                bsCost.setText(String.format("%d", CharacterParamsHelper.bsCost()));
                currentPoints(CharacterParamsHelper.bsCost(), oldBsCost);

                int oldMoveCost = Integer.parseInt(moveCost.getText().toString());
                moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));
                currentPoints(CharacterParamsHelper.moveCost(), oldMoveCost);
            }
        });
    }

    private void hpSet() {
        hpEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.hp.equals(intValue)) return;
                character.hp = intValue;

                int oldHpCost = Integer.parseInt(hpCost.getText().toString());
                hpCost.setText(String.format("%d", CharacterParamsHelper.hpCost()));
                currentPoints(CharacterParamsHelper.hpCost(), oldHpCost);
            }
        });
    }

    private void willSet() {
        willEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.will.equals(intValue)) return;
                character.will = intValue;

                int oldWillCost = Integer.parseInt(willCost.getText().toString());
                willCost.setText(String.format("%d", CharacterParamsHelper.willCost()));
                currentPoints(CharacterParamsHelper.willCost(), oldWillCost);
            }
        });
    }

    private void perSet() {
        perEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.per.equals(intValue)) return;
                character.per = intValue;

                int oldPerCost = Integer.parseInt(perCost.getText().toString());
                perCost.setText(String.format("%d", CharacterParamsHelper.perCost()));
                currentPoints(CharacterParamsHelper.perCost(), oldPerCost);
            }
        });
    }

    private void fpSet() {
        fpEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.fp.equals(intValue)) return;
                character.fp = intValue;

                int oldFpCost = Integer.parseInt(fpCost.getText().toString());
                fpCost.setText(String.format("%d", CharacterParamsHelper.fpCost()));
                currentPoints(CharacterParamsHelper.fpCost(), oldFpCost);
            }
        });
    }

    private void bsSet() {
        bsEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                double dNewValue = Double.parseDouble(newValue.toString());
                if (character.bs.equals(dNewValue)) return;
                character.bs = dNewValue;

                int intNewValue = (int) dNewValue;
                if (intNewValue > character.move) {
                    character.move = intNewValue;
                    moveEdit.setText(String.format("%d", character.move));
                }

                int oldBsCost = Integer.parseInt(bsCost.getText().toString());
                bsCost.setText(String.format("%d", CharacterParamsHelper.bsCost()));
                currentPoints(CharacterParamsHelper.bsCost(), oldBsCost);

                int oldMoveCost = Integer.parseInt(moveCost.getText().toString());
                moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));
                currentPoints(CharacterParamsHelper.moveCost(), oldMoveCost);

                doge.setText(String.format("%d", CharacterParamsHelper.doge()));
            }
        });
    }

    private void moveSet() {
        moveEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.move.equals(intValue)) return;
                character.move = intValue;

                int oldMoveCost = Integer.parseInt(moveCost.getText().toString());
                moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));
                currentPoints(CharacterParamsHelper.moveCost(), oldMoveCost);
            }
        });
    }

    private void nameSet() {
        characterNameEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (character.name.equals(newValue.toString())) return;
                character.name = newValue.toString();
                character.update_single("name", newValue);
            }
        });
    }

    private void playerSet() {
        playerNameEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (character.player != null && character.player.equals(newValue.toString())) return;
                character.player = newValue.toString();
                character.update_single("player", newValue.toString());
            }
        });
    }

    private void tlSet() {
        tlEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.tl.equals(intValue)) return;
                character.tl = intValue;
                character.update_single("tl", intValue);
            }
        });
    }

    private void tlCostSet() {
        tlCostEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("") || newValue.toString().equals("-")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.tlCost.equals(intValue)) return;
                character.tlCost = intValue;

                int oldMoveCost = Integer.parseInt(tlCostEdit.getText().toString());
                tlCostEdit.setText(String.format("%d", character.tlCost));
                currentPoints(character.tlCost, oldMoveCost);
            }
        });
    }

    private void growthSet() {
        growthEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.growth.equals(intValue)) return;
                character.growth = intValue;
                character.update_single("growth", intValue);
            }
        });
    }

    private void weightSet() {
        growthEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.weight.equals(intValue)) return;
                character.weight = intValue;
                character.update_single("weight", intValue);
            }
        });
    }

    private void ageSet() {
        ageEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable newValue) {
                if (newValue.toString().equals("")) return;
                Integer intValue = Integer.parseInt(newValue.toString());
                if (character.age.equals(intValue)) return;
                character.age = intValue;
                character.update_single("age", intValue);
            }
        });
    }

    private void setElements() {
        characterNameEdit = (EditText) view.findViewById(R.id.characterNameEdit);
        playerNameEdit = (EditText) view.findViewById(R.id.playerNameEdit);
        growthEdit = (EditText) view.findViewById(R.id.growthEdit);
        weightEdit = (EditText) view.findViewById(R.id.weightEdit);
        ageEdit = (EditText) view.findViewById(R.id.ageEdit);
        tlEdit = (EditText) view.findViewById(R.id.tlEdit);
        tlCostEdit = (EditText) view.findViewById(R.id.tlCostEdit);
        smEdit = (EditText) view.findViewById(R.id.smEdit);
        noFineManipulators = (CheckBox) view.findViewById(R.id.noFineManipulators);
        stEdit = (EditText) view.findViewById(R.id.stEdit);
        dxEdit = (EditText) view.findViewById(R.id.dxEdit);
        iqEdit = (EditText) view.findViewById(R.id.iqEdit);
        htEdit = (EditText) view.findViewById(R.id.htEdit);
        stCost = (TextView) view.findViewById(R.id.stCost);
        dxCost = (TextView) view.findViewById(R.id.dxCost);
        iqCost = (TextView) view.findViewById(R.id.iqCost);
        htCost = (TextView) view.findViewById(R.id.htCost);
        hpEdit = (EditText) view.findViewById(R.id.hpEdit);
        willEdit = (EditText) view.findViewById(R.id.willEdit);
        perEdit = (EditText) view.findViewById(R.id.perEdit);
        fpEdit = (EditText) view.findViewById(R.id.fpEdit);
        hpCost = (TextView) view.findViewById(R.id.hpCost);
        willCost = (TextView) view.findViewById(R.id.willCost);
        perCost = (TextView) view.findViewById(R.id.perCost);
        fpCost = (TextView) view.findViewById(R.id.fpCost);
        bsEdit = (EditText) view.findViewById(R.id.bsEdit);
        bsCost = (TextView) view.findViewById(R.id.bsCost);
        moveEdit = (EditText) view.findViewById(R.id.moveEdit);
        moveCost = (TextView) view.findViewById(R.id.moveCost);
        bl = (TextView) view.findViewById(R.id.bl);
        doge = (TextView) view.findViewById(R.id.doge);
        damageThrust = (TextView) view.findViewById(R.id.damageThrust);
        damageSwing = (TextView) view.findViewById(R.id.damageSwing);

    }

    private void currentPoints(int cost, int oldStCost) {
        ((MenuActivity) getActivity()).setCurrentPoints(character.currentPoints + cost - oldStCost);
    }
}