package model.playerclasses;

import enums.PlayerClass;

public class Warrior implements SetStats {
    private int attack = 90;
    private int defense = 80;
    private int health = 100;
    private int specialAttack = 20;
    private int specialDefense = 10;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("Setting stats for Warrior");
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
