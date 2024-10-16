package playerClasses;

import enums.PlayerClass;

public class Samurai implements SetStats{
    private int attack = 100;
    private int defense = 50;
    private int health = 80;
    private int specialAttack = 20;
    private int specialDefense = 50;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("The player class " + playerClass);
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }
}
