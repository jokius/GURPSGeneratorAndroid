package ru.gurps.generator.android.singletons;

import ru.gurps.generator.android.models.Character;

public class CharacterSingleton {
    private static CharacterSingleton mInstance = new CharacterSingleton();
    private Character character;

    public static CharacterSingleton getInstance() {
        if(mInstance == null) mInstance = new CharacterSingleton();
        return mInstance;
    }

    private CharacterSingleton() {
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
