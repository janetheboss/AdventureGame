import java.util.ArrayList;
import java.util.List;

public class Room {
 private String name;
 private String description;
 private List<Item> items;

 public Room(String name, String description) {
  this.name = name;
  this.description = description;
  this.items = new ArrayList<>();
 }

 public String getName() {
  return name;
 }

 public String getDescription() {
  return description;
 }

 public void addItem(Item item) {
  items.add(item);
 }

 public boolean removeItem(String itemName) {
  for (Item item : items) {
   if (item.getName().equalsIgnoreCase(itemName)) {
    items.remove(item);
    return true;
   }
  }
  return false;
 }
 public List<Item> getItems() {
  return items;
 }

 public void describeRoom() {
  System.out.println("\nYou are in " + name);
  System.out.println(description);

  if (!items.isEmpty()) {
   System.out.println("You see the following items:");
   for (Item item : items) {
    System.out.println("- " + item.getName());
   }
  } else {
   System.out.println("There are no items in this room.");
  }
 }
}
