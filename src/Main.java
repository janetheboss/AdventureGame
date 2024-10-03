import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        PlayerService playerService = new PlayerService();
        UserChangePassword userChangePassword = new UserChangePassword();

        System.out.println("----- Registration -----");
        userService.registerUser(scanner);

        System.out.println("----- Login -----");
        userService.logInUser(scanner);

        playerService.changeUserPassword(userService, userChangePassword);

        System.out.println("----- Create Player -----");
        playerService.createPlayerIfUserExists(userService.getRegisteredUser());

        scanner.close();
    }
}
