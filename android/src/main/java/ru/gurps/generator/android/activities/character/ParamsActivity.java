package ru.gurps.generator.android.activities.character;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import ru.gurps.generator.android.R;
import ru.gurps.generator.android.helpers.CharacterParamsHelper;
import ru.gurps.generator.android.helpers.DmgHelper;
import ru.gurps.generator.android.models.Character;
import ru.gurps.generator.android.singletons.CharacterSingleton;


public class ParamsActivity extends Activity {
    private Character character = CharacterSingleton.getInstance().getCharacter();

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);
        setElements();
        setCharacterParams();
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
//            currentPoints(stCost, oldStCost);

                int oldHpCost = Integer.parseInt(hpCost.getText().toString());
                hpCost.setText(String.format("%d", CharacterParamsHelper.hpCost()));
//            currentPoints(hpCost, oldHpCost);
                character.save();
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
//                currentPoints(stCost, oldStCost);

                int oldDxCost = Integer.parseInt(dxCost.getText().toString());
                dxCost.setText(String.format("%d", CharacterParamsHelper.dxCost()));
//                currentPoints(dxCost, oldDxCost);
                character.save();
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
//            currentPoints(stCost, oldStCost);

                int oldHpCost = Integer.parseInt(hpCost.getText().toString());
                hpCost.setText(String.format("%d", CharacterParamsHelper.hpCost()));
//            currentPoints(hpCost, oldHpCost);

                bl.setText(String.format("%d", CharacterParamsHelper.bl()));
                damageThrust.setText(DmgHelper.damageThrust(character.st));
                damageSwing.setText(DmgHelper.damageSwing(character.st));

                character.save();
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
//            currentPoints(dxCost, oldDxCost);

                int oldBsCost = Integer.parseInt(bsCost.getText().toString());
                bsCost.setText(String.format("%d", CharacterParamsHelper.bsCost()));
//            currentPoints(bsCost, oldBsCost);

                int oldMoveCost = Integer.parseInt(moveCost.getText().toString());
                moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));
//            currentPoints(moveCost, oldMoveCost);

                doge.setText(String.format("%d", CharacterParamsHelper.doge()));
                character.save();
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
//            currentPoints(iqCost, oldIqCost);

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
//            currentPoints(willCost, oldWillCost);

                int oldPerCost = Integer.parseInt(perCost.getText().toString());
                perCost.setText(String.format("%d", CharacterParamsHelper.perCost()));
//            currentPoints(perCost, oldPerCost);
                character.save();
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
//            currentPoints(htCost, oldHtCost);

                if (intValue > character.fp) {
                    character.fp = intValue;
                    fpEdit.setText(String.format("%d", character.fp));
                }

                int oldFpCost = Integer.parseInt(fpCost.getText().toString());
                fpCost.setText(String.format("%d", CharacterParamsHelper.fpCost()));
//            currentPoints(fpCost, oldFpCost);

                int oldBsCost = Integer.parseInt(bsCost.getText().toString());
                bsCost.setText(String.format("%d", CharacterParamsHelper.bsCost()));
//            currentPoints(bsCost, oldBsCost);

                int oldMoveCost = Integer.parseInt(moveCost.getText().toString());
                moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));
//            currentPoints(moveCost, oldMoveCost);
                character.save();
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
//            currentPoints(hpCost, oldHpCost);
                character.save();
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
//            currentPoints(willCost, oldWillCost);
                character.save();
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
//            currentPoints(perCost, oldPerCost);
                character.save();
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
//            currentPoints(fpCost, oldFpCost);
                character.save();
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
            if(intNewValue > character.move) {
                character.move = intNewValue;
                moveEdit.setText(String.format("%d", character.move));
            }

            int oldBsCost = Integer.parseInt(bsCost.getText().toString());
            bsCost.setText(String.format("%d", CharacterParamsHelper.bsCost()));
//            currentPoints(bsCost, oldBsCost);

            int oldMoveCost = Integer.parseInt(moveCost.getText().toString());
            moveCost.setText(String.format("%d", CharacterParamsHelper.moveCost()));
//            currentPoints(moveCost, oldMoveCost);

            doge.setText(String.format("%d", CharacterParamsHelper.doge()));
                character.save();
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
//            currentPoints(moveCost, oldMoveCost);
                character.save();
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
                if(character.name.equals(newValue.toString())) return;
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
                if (character.player.equals(newValue.toString())) return;
                character.player = newValue.toString();
            character.update_single("player", newValue);
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
//                currentPoints(tlCost, oldMoveCost);
                character.save();
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
        characterNameEdit = (EditText) findViewById(R.id.characterNameEdit);
        playerNameEdit = (EditText) findViewById(R.id.playerNameEdit);
        growthEdit = (EditText) findViewById(R.id.growthEdit);
        weightEdit = (EditText) findViewById(R.id.weightEdit);
        ageEdit = (EditText) findViewById(R.id.ageEdit);
        tlEdit = (EditText) findViewById(R.id.tlEdit);
        tlCostEdit = (EditText) findViewById(R.id.tlCostEdit);
        smEdit = (EditText) findViewById(R.id.smEdit);
        noFineManipulators = (CheckBox) findViewById(R.id.noFineManipulators);
        stEdit = (EditText) findViewById(R.id.stEdit);
        dxEdit = (EditText) findViewById(R.id.dxEdit);
        iqEdit = (EditText) findViewById(R.id.iqEdit);
        htEdit = (EditText) findViewById(R.id.htEdit);
        stCost = (TextView) findViewById(R.id.stCost);
        dxCost = (TextView) findViewById(R.id.dxCost);
        iqCost = (TextView) findViewById(R.id.iqCost);
        htCost = (TextView) findViewById(R.id.htCost);
        hpEdit = (EditText) findViewById(R.id.hpEdit);
        willEdit = (EditText) findViewById(R.id.willEdit);
        perEdit = (EditText) findViewById(R.id.perEdit);
        fpEdit = (EditText) findViewById(R.id.fpEdit);
        hpCost = (TextView) findViewById(R.id.hpCost);
        willCost = (TextView) findViewById(R.id.willCost);
        perCost = (TextView) findViewById(R.id.perCost);
        fpCost = (TextView) findViewById(R.id.fpCost);
        bsEdit = (EditText) findViewById(R.id.bsEdit);
        bsCost = (TextView) findViewById(R.id.bsCost);
        moveEdit = (EditText) findViewById(R.id.moveEdit);
        moveCost = (TextView) findViewById(R.id.moveCost);
        bl = (TextView) findViewById(R.id.bl);
        doge = (TextView) findViewById(R.id.doge);
        damageThrust = (TextView) findViewById(R.id.damageThrust);
        damageSwing = (TextView) findViewById(R.id.damageSwing);

    }
}
