import java.util.Scanner;

public class UserService {
    private User registeredUser;
    private RegisterUser registerUser;
    private LogInUser logInUser;

    public UserService() {
        registerUser = new RegisterUser();
        logInUser = new LogInUser();
    }

    public void registerUser(Scanner scanner) {
        while (registeredUser == null) {
            registeredUser = registerUser.register(scanner);
        }
    }

    public void logInUser(Scanner scanner) {
        logInUser.validation(scanner, registeredUser);
    }
}
