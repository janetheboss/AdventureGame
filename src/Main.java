import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        userService.registerUser(scanner);

        userService.logInUser(scanner);

        scanner.close();
    }
}
