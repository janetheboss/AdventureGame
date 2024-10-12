package service;

import input_output.Player;
import input_output.User;
import operation.UserChangePassword;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private List<Player> players = new ArrayList<>();

    public Player createPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("Choose your class: ");
        String playerClass = scanner.nextLine();

        Player player = new Player(playerName, playerClass);
        players.add(player);

        System.out.println("input_output.Player " + player.getName() + " of class " + playerClass + " created.");
        return player;
    }

    public void createPlayerIfUserExists(User registeredUser) {
        if (registeredUser != null) {
            createPlayer();
        } else {
            System.out.println("No registered user. Please register before creating a player.");
        }
    }

    public void changeUserPassword(UserService userService, UserChangePassword userChangePassword) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to change your password? (yes/no): ");
        String changePasswordOption = scanner.nextLine();

        if (changePasswordOption.equalsIgnoreCase("yes")) {
            try {
                userChangePassword.changePassword(userService.getRegisteredUser(), userService.getRegisterUserInput());
            } catch (Exception e) {
                System.out.println("An error occurred during password change: " + e.getMessage());
            }
        }
    }

    public Player editPlayerInfo(String playerName, String newPlayerName, String newPlayerClass) {
        Player currentPlayer = findPlayerByName(playerName);

        if (currentPlayer == null) {
            System.out.println("input_output.Player with name '" + playerName + "' not found.");
            return null;
        }

        currentPlayer.setName(newPlayerName);
        currentPlayer.setPlayerClass(newPlayerClass);

        System.out.println("input_output.Player info updated: " + currentPlayer.getName() + " of class " + currentPlayer.getPlayerClass());

        return currentPlayer;
    }

    public void handleEditPlayerInfo(Scanner scanner) {
        System.out.println("----- Change input_output.Player Information -----");
        System.out.println("Enter the current name of the player: ");
        String currentName = scanner.nextLine();
        System.out.println("Enter the new name for the player: ");
        String newPlayerName = scanner.nextLine();
        System.out.println("Enter the new class for the player: ");
        String newPlayerClass = scanner.nextLine();

        editPlayerInfo(currentName, newPlayerName, newPlayerClass);
    }

    private Player findPlayerByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                return player;
            }
        }
        return null;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void displayAllPlayers(Scanner scanner) {
        int pageSize = 5;
        int pageNumber = 1;

        while (true) {
            int totalPlayers = players.size();
            int totalPages = (int) Math.ceil((double) totalPlayers / pageSize);

            if (totalPlayers == 0) {
                System.out.println("No players found.");
                return;
            }
            displayPlayers(players, pageNumber, pageSize);

            System.out.print("Enter page number to view (0 to exit): ");
            if (scanner.hasNextInt()) {
                pageNumber = scanner.nextInt();
                scanner.nextLine();

                if (pageNumber == 0) {
                    break;
                } else if (pageNumber < 1 || pageNumber > totalPages) {
                    System.out.println("Invalid page number. Please try again.");
                    pageNumber = 1;
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                pageNumber = 1;
            }
        }
    }

    private void displayPlayers(List<Player> players, int pageNumber, int pageSize) {
        int totalPlayers = players.size();
        int totalPages = (int) Math.ceil((double) totalPlayers / pageSize);

        int start = (pageNumber - 1) * pageSize;
        int end = Math.min(start + pageSize, totalPlayers);

        System.out.println("Displaying page " + pageNumber + " of " + totalPages + ":");
        for (int i = start; i < end; i++) {
            System.out.println((i + 1) + ": " + players.get(i).getName() + " (" + players.get(i).getPlayerClass() + ")");
        }
    }

    public void searchPlayerByName(Scanner scanner) {
        System.out.print("Enter the name of the player you're looking for: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        List<Player> foundPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getName().toLowerCase().contains(searchTerm)) {
                foundPlayers.add(player);
            }
        }

        if (foundPlayers.isEmpty()) {
            System.out.println("No players found with the name: " + searchTerm);
        } else {
            System.out.println("Players found:");
            for (Player player : foundPlayers) {
                System.out.println(player.getName() + " (" + player.getPlayerClass() + ")");
            }
        }
    }

    public void createAndAddPlayer(Scanner scanner) {
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter player class: ");
        String playerClass = scanner.nextLine();

        Player newPlayer = new Player(playerName, playerClass);
        addPlayer(newPlayer);

        System.out.println("input_output.Player " + newPlayer.getName() + " (" + newPlayer.getPlayerClass() + ") created and added to the list.");
    }

}
