import Exceptions.UserException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class RegisterUser extends User {
    public RegisterUser(String username, String hashedPassword, String salt) {
        super(username, hashedPassword, salt);
    }

    public RegisterUser() {
        super("", "", "");
    }

    public RegisterUser register(Scanner scanner) {
        try {
            System.out.println("Enter username for registration:");
            String newUsername = scanner.nextLine();

            System.out.println("Enter password for registration:");
            String newPassword = scanner.nextLine();

            System.out.println("Confirm password:");
            String confirmPassword = scanner.nextLine();

            validateInput(newUsername, newPassword, confirmPassword);

            String salt = generateSalt();
            String hashedPassword = hashPassword(newPassword, salt);

            System.out.println("Registration successful!");
            return new RegisterUser(newUsername, hashedPassword, salt);

        } catch (UserException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return null;
        }
    }

    private void validateInput(String username, String password, String confirmPassword) throws UserException {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            throw new UserException("Username and password cannot be empty!");
        }

        if (!password.equals(confirmPassword)) {
            throw new UserException("Passwords do not match!");
        }
    }

    private String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] saltBytes = new byte[16];
        sr.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String saltedPassword = password + salt;
        byte[] hashedBytes = md.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashedBytes);
    }
}
