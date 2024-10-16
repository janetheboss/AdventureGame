package operation;

import java.util.Scanner;
import model.User;

public class DeleteUser {
    private Scanner scanner;
    private User user;

    public DeleteUser(Scanner scanner, User user) {
        this.scanner = scanner;
        this.user = user;
    }

    public void requestAccountDeletion() {
        System.out.print("Please enter your username to confirm deletion: ");
        String usernameInput = scanner.nextLine();

        if (usernameInput.equals(user.getUsername())) {
            if (!user.isMarkedForDeletion()) {
                user.setMarkedForDeletion(true);
                System.out.println("Account has been marked for deletion.");
            } else {
                System.out.println("Account is already marked for deletion.");
            }
        } else {
            System.out.println("Username does not match. Deletion request denied.");
        }
    }

    public void cancelAccountDeletionRequest() {
        System.out.print("Please enter your username to confirm cancellation: ");
        String usernameInput = scanner.nextLine();

        if (usernameInput.equals(user.getUsername())) {
            if (user.isMarkedForDeletion()) {
                user.setMarkedForDeletion(false);
                System.out.println("Account deletion request has been canceled.");
            } else {
                System.out.println("Account is not marked for deletion.");
            }
        } else {
            System.out.println("Username does not match. Cancellation request denied.");
        }
    }
}

