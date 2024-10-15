package service;

import Exceptions.UserException;
import inputOutput.RegisterUserInput;
import model.User;
import operation.LogInUser;
import operation.RegisterUser;

import java.util.Scanner;

public class UserService {
    private User registeredUser;
    private RegisterUser registerUser;
    private LogInUser logInUser;
    private RegisterUserInput registerUserInput;

    public UserService() {
        registerUser = new RegisterUser();
        logInUser = new LogInUser();
    }

    public void registerUser(Scanner scanner) {
        boolean isRegistered = false;
        while (!isRegistered) {
            try {
                registerUserInput = getUserRegistrationInput(scanner);
                registeredUser = registerUser.register(registerUserInput);

                if (registeredUser != null) {
                    if (registeredUser.isMarkedForDeletion()) {
                        System.out.println("Account deletion is pending. Registration failed.");
                        continue;
                    }
                    if (registeredUser.isMarkedForDeletion()) {
                        System.out.println("Account deletion is pending. Registration failed.");
                        continue;
                    }

                    System.out.println("Registration successful!");
                    isRegistered = true;
                }
            } catch (UserException e) {
                System.out.println("Registration failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private RegisterUserInput getUserRegistrationInput(Scanner scanner) {
        System.out.println("Enter username for registration: ");
        String username = scanner.nextLine();

        System.out.println("Enter password for registration: ");
        String password = scanner.nextLine();

        System.out.println("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        return new RegisterUserInput(username, password, confirmPassword);
    }

    public void logInUser(Scanner scanner) {
        int attempts = 0;
        boolean isLoggedIn = false;

        while (!isLoggedIn && attempts < 3) {
            logInUser.validation(scanner, registeredUser);
            isLoggedIn = true;
            System.out.println("Login successful!");
        }

        if (!isLoggedIn) {
            System.out.println("Login failed after 3 attempts.");
        }
    }

    public RegisterUserInput getRegisterUserInput() {
        return registerUserInput;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }
}
