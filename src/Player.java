import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private List<Item> inventory;
    private Room currentRoom;

    public Player(String name, int health, List<Item> items, Room currentRoom) {
        this.name = name;
        this.health = 100;
        this.inventory = new ArrayList<>();
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void damageTaken(int dmg) {
        health -= dmg;
        System.out.println("The current health after taking damage is : " + health);
        if(health <=0 )
        {
            System.out.println("The players has died ,because they have 0 hp");
        }else  System.out.println("The current health after taking damage is : " + health);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + " added to your inventory.");
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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
