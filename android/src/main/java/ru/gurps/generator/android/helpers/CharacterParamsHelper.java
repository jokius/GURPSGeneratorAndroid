package ru.gurps.generator.android.helpers;

import ru.gurps.generator.android.models.Character;
import ru.gurps.generator.android.singletons.CharacterSingleton;

public class CharacterParamsHelper {
    private static Character character = CharacterSingleton.getInstance().getCharacter();

    public static int stCost() {
        int cost = (character.st - 10) * 10;
        if (cost == 0) return cost;
        if (character.noFineManipulators) cost = (int) (cost - (cost * 0.4));
        return costThroughSm(cost);
    }

    public static int dxCost() {
        int cost = (character.dx - 10) * 20;
        if (cost == 0) return cost;
        if (character.noFineManipulators) cost = (int) (cost - (cost * 0.4));
        return cost;
    }

    public static int iqCost() {
        return (character.iq - 10) * 20;
    }

    public static int htCost() {
        return (character.ht - 10) * 10;
    }

    public static int hpCost() {
        int cost = (character.hp - character.st) * 2;
        if (cost == 0) return cost;
        return costThroughSm(cost);
    }

    public static int willCost() {
        return (character.will - character.iq) * 5;
    }

    public static int perCost() {
        return (character.per - character.iq) * 5;
    }

    public static int fpCost() {
        return (character.fp - character.ht) * 3;
    }

    public static double defaultBs() {
        return (character.dx + character.ht) / 4;
    }

    public static int bsCost() {
        int cost = 0;
        double periods = character.bs - defaultBs();

        if (periods >= 0.25) {
            do {
                periods = periods - 0.25;
                cost += 5;
            } while (periods >= 0.25);
        } else if (periods <= -0.25) {
            do {
                periods = periods + 0.25;
                cost -= 5;
            } while (periods <= -0.25);
        }
        return cost;
    }

    public static int moveCost() {
        return (int) (character.move - character.bs);
    }

    public static int bl() {
        return (character.st * character.st) / 5;
    }

    public static int doge() {
        return (int) (character.bs + 3);
    }

    private static int costThroughSm(int cost){
        if (character.sm == 0) return cost;
        if ((character.sm > 0 && character.sm < 8) || (character.sm < 0 && character.sm > -8))
            cost = (int) (cost - (cost * (0.1 * character.sm)));
        else if(character.sm < 0 && character.sm <= -8)
            cost = (int) (cost - (cost * -0.8));
        else cost = (int) (cost - (cost * 0.8));
        return cost;
    }
}
