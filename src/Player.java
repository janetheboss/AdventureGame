import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Item> inventory;

    public Player(String name, List<Item> items) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
