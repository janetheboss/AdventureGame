package model.playerClasses;

import enums.PlayerClass;

public class Priest implements SetStats{
    private int attack = 60;
    private int defense = 50;
    private int health = 70;
    private int specialAttack = 70;
    private int specialDefense = 50;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("The Players class " + playerClass);
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
