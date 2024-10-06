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
                createPlayer();
            } else {
                System.out.println("Player already exists: " + Player.getInstance().getName());
            }
        } else {
            System.out.println("No registered user. Please register before creating a player.");
        }
    }

    public void changeUserPassword(UserService userService, UserChangePassword userChangePassword) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to change your password? (yes/no): ");
        String changePasswordOption = scanner.nextLine();

        if (changePasswordOption.equalsIgnoreCase("yes")) {
            try {
                userChangePassword.changePassword(userService.getRegisteredUser(), userService.getRegisterUserInput());
            } catch (Exception e) {
                System.out.println("An error occurred during password change: " + e.getMessage());
            }
        }
    }

    public Player editPlayerInfo(String playerName, String newPlayerName, String newPlayerClass) {
        Player currentPlayer = Player.getInstance();

        if (currentPlayer == null) {
            System.out.println("No player instance found.");
            return null;
        }

        if (!playerName.equals(currentPlayer.getName())) {
            System.out.println("Incorrect player name. Please enter the correct name.");
            return null;
        }
        currentPlayer.setName(newPlayerName);
        currentPlayer.setPlayerClass(newPlayerClass);

        System.out.println("Player info updated: " + currentPlayer.getName() + " of class " + currentPlayer.getPlayerClass());

        return currentPlayer;
    }

    public void handleEditPlayerInfo(Scanner scanner) {
        System.out.println("----- Change Player Information -----");
        System.out.println("Enter the current name of the player: ");
        String currentName = scanner.nextLine();
        System.out.println("Enter the new name for the player: ");
        String newPlayerName = scanner.nextLine();
        System.out.println("Enter the new class for the player: ");
        String newPlayerClass = scanner.nextLine();

        editPlayerInfo(currentName, newPlayerName, newPlayerClass);
    }
}
