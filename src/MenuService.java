import java.util.Scanner;

public class MenuService {
    private final Scanner scanner;
    private final UserService userService;
    private final PlayerService playerService;
    private final UserChangePassword userChangePassword;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
        this.userService = new UserService();
        this.playerService = new PlayerService();
        this.userChangePassword = new UserChangePassword();

        PlayerData.seedPlayers(playerService);
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

            exit = switch (choice) {
                case 1 -> {
                    System.out.println("----- Registration -----");
                    userService.registerUser(scanner);
                    yield false;
                }
                case 2 -> {
                    System.out.println("----- Login -----");
                    userService.logInUser(scanner);
                    yield false;
                }
                case 3 -> {
                    System.out.println("----- Change Password -----");
                    playerService.changeUserPassword(userService, userChangePassword);
                    yield false;
                }
                case 4 -> {
                    System.out.println("----- Create Player -----");
                    playerService.createAndAddPlayer(scanner);
                    yield false;
                }
                case 5 -> {
                    System.out.println("----- Edit Player Information -----");
                    playerService.handleEditPlayerInfo(scanner);
                    yield false;
                }
                case 6 -> {
                    System.out.println("----- Display All Players -----");
                    playerService.displayAllPlayers(scanner);
                    yield false;
                }
                case 7 -> {
                    System.out.println("----- Search Player by Name -----");
                    playerService.searchPlayerByName(scanner);
                    yield false;
                }
                case 8 -> {
                    System.out.println("----- Request Account Deletion -----");
                    DeleteUser deleteUser = new DeleteUser(scanner, userService.getRegisteredUser());
                    deleteUser.requestAccountDeletion();
                    yield false;
                }
                case 9 -> {
                    System.out.println("----- Cancel Account Deletion Request -----");
                    DeleteUser deleteUserCancel = new DeleteUser(scanner, userService.getRegisteredUser());
                    deleteUserCancel.cancelAccountDeletionRequest();
                    yield false;
                }
                case 0 -> {
                    System.out.println("Exiting program...");
                    yield true;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    yield false;
                }
            };
        }

        scanner.close();
    }
}
