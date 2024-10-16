package playerClasses;

import enums.PlayerClass;

public class Druid implements SetStats {
    private int attack = 70;
    private int defense = 60;
    private int health = 100 ;
    private int specialAttack = 10;
    private int specialDefense = 60;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("Player Class: " + playerClass);
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
