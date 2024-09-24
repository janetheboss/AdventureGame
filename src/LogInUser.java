import Exceptions.UserException;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class LogInUser {
    public void validation(Scanner scanner, User registeredUser) {
        try {
            System.out.println("Enter username for LogIn:");
            String inputUsername = scanner.nextLine();

            System.out.println("Enter password for LogIn:");
            String inputPassword = scanner.nextLine();

            validateCredentials(inputUsername, inputPassword, registeredUser);

            System.out.println("You have successfully logged in.");

        } catch (UserException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private void validateCredentials(String username, String password, User registeredUser) throws UserException {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            throw new UserException("Username and password cannot be empty!");
        }

        if (!registeredUser.getUsername().equals(username) || !isPasswordValid(password, registeredUser)) {
            throw new UserException("Invalid username or password. Please try again.");
        }
    }

    private boolean isPasswordValid(String inputPassword, User registeredUser) {
        try {
            String hashedInputPassword = new RegisterUser().hashPassword(inputPassword, registeredUser.getSalt());
            return hashedInputPassword.equals(registeredUser.getHashedPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
