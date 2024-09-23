import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RegisterUser registeredUser = null;
        while (registeredUser == null) {
            registeredUser = RegisterUser.register(scanner);
        }
        LogInUser logIn = new LogInUser();
        logIn.validation(scanner, registeredUser);
        scanner.close();
    }
}
