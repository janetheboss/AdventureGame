package model.playerclasses;

import enums.PlayerClass;

public class Ninja implements SetStats{
    private int attack = 210;
    private int defense = 60;
    private int health = 70;
    private int specialAttack = 0;
    private int specialDefense = 60;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("The Players calss : " + playerClass);
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
