package playerClasses;

import enums.PlayerClass;

public class Monk implements SetStats{
    private int attack = 60;
    private int defense = 60;
    private int health = 60;
    private int specialAttack = 60;
    private int specialDefense = 60;

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        System.out.println("Player Class: " + playerClass);
    }
}
