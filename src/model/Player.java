package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String playerClass;
    private List<Item> inventory;

    public Player(String name, String playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
