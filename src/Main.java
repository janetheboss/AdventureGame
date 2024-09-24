import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegisterUser registerUser = new RegisterUser();
        User registeredUser = null;

        while (registeredUser == null) {
            registeredUser = registerUser.register(scanner);
        }

        LogInUser logInUser = new LogInUser();
        logInUser.validation(scanner, registeredUser);

        scanner.close();
    }
}
