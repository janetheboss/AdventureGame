import java.util.ArrayList;
import java.util.Scanner;

public class CreatePlayer {
    public void createPlyer(Scanner scanner)
    {
        System.out.println("Welcome User here you can make a new playable character");
        System.out.println("If you are ready press enter the name of the playable character : ");
        String playerName = scanner.nextLine();
        System.out.println("Enter the class of the character");
        String playerClass = scanner.nextLine();
        System.out.println("You have created a character called : " + playerName + "with the class of : "+ playerClass);
        //later add class
    }
}
