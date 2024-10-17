package model.playerClasses;

import enums.PlayerClass;

public class shaman implements SetStats{
    private int attack = 40;
    private int defense = 60;
    private int health = 70;
    private int specialAttack = 80;
    private int specialDefense = 50;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("The player clss "+ playerClass);
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
