import Exceptions.UserException;

import java.util.Scanner;

public class RegisterUser extends User {

    public RegisterUser(String username, String password) {
        super(username, password);
    }

    public static RegisterUser register(Scanner scanner) {
        try {
            System.out.println("Enter username for registration:");
            String newUsername = scanner.nextLine();

            System.out.println("Enter password for registration:");
            String newPassword = scanner.nextLine();

            System.out.println("Confirm password:");
            String confirmPassword = scanner.nextLine();

            validateInput(newUsername, newPassword, confirmPassword);

            System.out.println("Registration successful!");
            return new RegisterUser(newUsername, newPassword);

        } catch (UserException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return null;
        }
    }

    private static void validateInput(String username, String password, String confirmPassword) throws UserException {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            throw new UserException("Username and password cannot be empty!");
        }

        if (!password.equals(confirmPassword)) {
            throw new UserException("Passwords do not match!");
        }
    }
}
