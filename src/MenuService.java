import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuService {
    private final Scanner scanner;
    private final UserService userService;
    private final PlayerService playerService;
    private final UserChangePassword userChangePassword;
    private final Map<Integer, Runnable> actions;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
        this.userService = new UserService();
        this.playerService = new PlayerService();
        this.userChangePassword = new UserChangePassword();
        this.actions = new HashMap<>();

        PlayerData.seedPlayers(playerService);

        actions.put(1, () -> {
            System.out.println("----- Registration -----");
            userService.registerUser(scanner);
        });

        actions.put(2, () -> {
            System.out.println("----- Login -----");
            userService.logInUser(scanner);
        });

        actions.put(3, () -> {
            System.out.println("----- Change Password -----");
            playerService.changeUserPassword(userService, userChangePassword);
        });

        actions.put(4, () -> {
            System.out.println("----- Create Player -----");
            playerService.createAndAddPlayer(scanner);
        });

        actions.put(5, () -> {
            System.out.println("----- Edit Player Information -----");
            playerService.handleEditPlayerInfo(scanner);
        });

        actions.put(6, () -> {
            System.out.println("----- Display All Players -----");
            playerService.displayAllPlayers(scanner);
        });

        actions.put(7, () -> {
            System.out.println("----- Search Player by Name -----");
            playerService.searchPlayerByName(scanner);
        });

        actions.put(8, () -> {
            System.out.println("----- Request Account Deletion -----");
            DeleteUser deleteUser = new DeleteUser(scanner, userService.getRegisteredUser());
            deleteUser.requestAccountDeletion();
        });

        actions.put(9, () -> {
            System.out.println("----- Cancel Account Deletion Request -----");
            DeleteUser deleteUserCancel = new DeleteUser(scanner, userService.getRegisteredUser());
            deleteUserCancel.cancelAccountDeletionRequest();
        });
    }
    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println("----- Main Menu -----");
            System.out.println("1. Register User");
            System.out.println("2. Log In User");
            System.out.println("3. Change User Password");
            System.out.println("4. Create Player");
            System.out.println("5. Edit Player Information");
            System.out.println("6. Display All Players");
            System.out.println("7. Search Player by Name");
            System.out.println("8. Request Account Deletion");
            System.out.println("9. Cancel Account Deletion Request");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            Runnable action = actions.get(choice);
            if (action != null) {
                action.run();
            } else if (choice == 0) {
                exit = true;
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
