package service;

import enums.PlayerClass;
import model.playerClasses.*;

import java.util.HashMap;
import java.util.Map;

public class SetStatsFromClass implements SetStats {
    private final Map<PlayerClass, SetStats> stats = new HashMap<>();

    public SetStatsFromClass() {
        stats.put(PlayerClass.warrior, new Warrior());
        stats.put(PlayerClass.mage, new Mage());
        stats.put(PlayerClass.assassin, new Assassin());
        stats.put(PlayerClass.hunter, new Hunter());
        stats.put(PlayerClass.druid, new Druid());
        stats.put(PlayerClass.priest, new Priest());
        stats.put(PlayerClass.samurai, new Samurai());
        stats.put(PlayerClass.paladin, new Paladin());
        stats.put(PlayerClass.shaman, new shaman());
        stats.put(PlayerClass.monk, new Monk());
        stats.put(PlayerClass.ninja, new Ninja());
    }

    @Override
    public void SetPlayerStatsForClass(PlayerClass playerClass) {
        SetStats selectedStats = stats.get(playerClass);
        if (selectedStats != null) {
            selectedStats.SetPlayerStatsForClass(playerClass);
        } else {
            System.out.println("Player class not found!");
        }
    }
}