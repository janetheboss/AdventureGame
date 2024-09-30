import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String playerClass;
    private List<Item> inventory;

    private static Player instance;

    private Player(String name, String playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        this.inventory = new ArrayList<>();
    }

    public static Player getInstance(String name, String playerClass) {
        if (instance == null) {
            instance = new Player(name, playerClass);
        }
        return instance;
    }

    public static Player getInstance() {
        return instance;
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
        System.out.println(item.getName() + " added to your inventory.");
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void showInventory() {
        System.out.println("The inventory of the player is :");
        if (inventory.isEmpty()) {
            System.out.println(" - empty - ");
        } else {
            for (Item item : inventory) {
                System.out.println(" - " + item.getName());
            }
        }
    }
}
