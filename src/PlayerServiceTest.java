import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {
    private PlayerService playerService;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        playerService = new PlayerService();
        PlayerData.seedPlayers(playerService);
    }

    @Test
    void testEditInfo_Success() {
        playerService.addPlayer(new Player("ValidPlayer", "Mage")); // Create a player for testing

        Player updatedPlayer = playerService.editPlayerInfo("ValidPlayer", "UpdatedPlayer", "Warrior");

        assertNotNull(updatedPlayer);
        assertEquals("UpdatedPlayer", updatedPlayer.getName());
        assertEquals("Warrior", updatedPlayer.getPlayerClass());
    }

    @Test
    void testEditInfo_Failure_IncorrectName() {
        Player updatedPlayer = playerService.editPlayerInfo("WrongPlayer", "UpdatedPlayer", "Warrior");

        assertNull(updatedPlayer);
    }

    @Test
    void testEditInfo_Failure_NoPlayers() {
        PlayerService emptyPlayerService = new PlayerService();
        Player updatedPlayer = emptyPlayerService.editPlayerInfo("SomeName", "UpdatedPlayer", "Warrior");

        assertNull(updatedPlayer);
    }

    @Test
    void testSearchPlayerByName_Success() {
        String input = "Alice\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        playerService.searchPlayerByName(new Scanner(System.in));

        String expectedOutput = "Players found:\nAlice (Warrior)\n"; // Adjust according to the expected output
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }

    @Test
    void testSearchPlayerByName_Failure_NoResults() {
        String input = "NonExistentPlayer\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        playerService.searchPlayerByName(new Scanner(System.in));

        String expectedOutput = "No players found with the name: NonExistentPlayer";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }

    @Test
    void testDisplayAllPlayers_ValidPage() {
        String input = "1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        playerService.displayAllPlayers(new Scanner(System.in));

        String expectedOutput = "Displaying page 1 of ";
        assertTrue(outContent.toString().contains(expectedOutput));
        System.setOut(originalOut);
    }

    @Test
    void testDisplayAllPlayers_EmptyList() {
        PlayerService emptyPlayerService = new PlayerService();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        emptyPlayerService.displayAllPlayers(new Scanner(System.in));

        String expectedOutput = "No players found.";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }

    @Test
    void testDisplayAllPlayers_InvalidPage() {
        String input = "10\n1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        playerService.displayAllPlayers(new Scanner(System.in));

        String expectedOutput = "Invalid page number";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }
}
