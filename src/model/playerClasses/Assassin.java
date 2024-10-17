package model.playerClasses;

import enums.PlayerClass;

public class Assassin implements SetStats {
    private int attack = 20;
    private int defense = 30;
    private int health = 70;
    private int specialAttack = 110;
    private int specialDefense = 70;

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

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("Player Class: " + playerClass);
    }
}

