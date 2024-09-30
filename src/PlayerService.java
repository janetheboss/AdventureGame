import java.util.Scanner;

public class PlayerService {

    public Player createPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("Choose your class: ");
        String playerClass = scanner.nextLine();

        Player player = Player.getInstance(playerName, playerClass);

        System.out.println("Player " + player.getName() + " of class " + playerClass + " created.");
        return player;
    }

    public void createPlayerIfUserExists(User registeredUser) {
        if (registeredUser != null) {
            if (Player.getInstance() == null) {
                Player player = createPlayer();
                System.out.println("You have created a character: " + player.getName());
            } else {
                System.out.println("Player already exists: " + Player.getInstance().getName());
            }
        } else {
            System.out.println("No registered user. Please register before creating a player.");
        }
    }
}
