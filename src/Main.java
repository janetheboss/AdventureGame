import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        PlayerService playerService = new PlayerService();
        UserChangePassword userChangePassword = new UserChangePassword();
        PlayerData.seedPlayers(playerService);

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

            switch (choice) {
                case 1:
                    System.out.println("----- Registration -----");
                    userService.registerUser(scanner);
                    break;

                case 2:
                    System.out.println("----- Login -----");
                    userService.logInUser(scanner);
                    break;

                case 3:
                    System.out.println("----- Change Password -----");
                    playerService.changeUserPassword(userService, userChangePassword);
                    break;

                case 4:
                    System.out.println("----- Create Player -----");
                    playerService.createAndAddPlayer(scanner);
                    break;

                case 5:
                    System.out.println("----- Edit Player Information -----");
                    playerService.handleEditPlayerInfo(scanner);
                    break;

                case 6:
                    System.out.println("----- Display All Players -----");
                    playerService.displayAllPlayers(scanner);
                    break;

                case 7:
                    System.out.println("----- Search Player by Name -----");
                    playerService.searchPlayerByName(scanner);
                    break;

                case 8:
                    System.out.println("----- Request Account Deletion -----");
                    DeleteUser deleteUser = new DeleteUser(scanner, userService.getRegisteredUser());
                    deleteUser.requestAccountDeletion();
                    break;

                case 9:
                    System.out.println("----- Cancel Account Deletion Request -----");
                    DeleteUser deleteUserCancel = new DeleteUser(scanner, userService.getRegisteredUser());
                    deleteUserCancel.cancelAccountDeletionRequest();
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
