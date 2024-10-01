import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreatedMonsterForBattle{
    private List<MonsterModel> monsters;

    public CreatedMonsterForBattle() {
        monsters = new ArrayList<>();
        createMonsters();
    }

    private void createMonsters() {

        monsters.add(new MonsterModel("Fire Drake", "Dragon", 120, 80, 300, 150, 100));
        monsters.add(new MonsterModel("Goblin Warlord", "Goblin", 90, 60, 150, 70, 40));
        monsters.add(new MonsterModel("Shadow Stalker", "Specter", 110, 70, 200, 130, 90));
        monsters.add(new MonsterModel("Mountain Troll", "Troll", 140, 100, 400, 60, 80));
        monsters.add(new MonsterModel("Serpent Queen", "Snake", 100, 50, 250, 120, 60));
        monsters.add(new MonsterModel("Cursed Knight", "Undead", 130, 90, 220, 140, 110));
        monsters.add(new MonsterModel("Forest Guardian", "Ent", 70, 130, 350, 60, 140));
        monsters.add(new MonsterModel("Vampire Lord", "Vampire", 150, 70, 180, 160, 70));
        monsters.add(new MonsterModel("Lava Golem", "Golem", 160, 120, 500, 80, 130));
        monsters.add(new MonsterModel("Ice Sorceress", "Human", 100, 60, 180, 140, 100));
    }

    public MonsterModel chooseMonster(Scanner scanner) {
        System.out.println("Choose a monster by entering a number from 1 to 10:");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ". " + monsters.get(i).getName() + " (" + monsters.get(i).getRace() + ")");
        }

        int choice = -1;
        while (choice < 1 || choice > 10) {
            System.out.print("Enter a number between 1 and 10: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        MonsterModel chosenMonster = monsters.get(choice - 1);
        System.out.println("You chose: " + chosenMonster.getName() + " (" + chosenMonster.getRace() + ")");
        return chosenMonster;
    }

    public void displayMonsterDetails(MonsterModel monster) {
        System.out.println("\nMonster Details:");
        System.out.println("Name: " + monster.getName());
        System.out.println("Race: " + monster.getRace());
        System.out.println("Attack: " + monster.getAttack());
        System.out.println("Defense: " + monster.getDefense());
        System.out.println("Health: " + monster.getHealth());
        System.out.println("Special Attack: " + monster.getSpecialAttack());
        System.out.println("Special Defense: " + monster.getSpecialDefense());
    }
}
