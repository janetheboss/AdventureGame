package model.playerClasses;

import enums.PlayerClass;

public class Mage implements SetStats {
    private int attack = 20;
    private int defense = 50;
    private int health = 60;
    private int specialAttack = 120;
    private int specialDefense = 50;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("The players class : " + playerClass);
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
