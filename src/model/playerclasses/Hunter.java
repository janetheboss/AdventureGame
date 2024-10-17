package model.playerclasses;

import enums.PlayerClass;

public class Hunter implements SetStats{
    private int attack = 130;
    private int defense = 20;
    private int health = 70;
    private int specialAttack = 40;
    private int specialDefense = 40;

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
