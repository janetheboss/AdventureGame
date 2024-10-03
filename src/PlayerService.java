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
}
