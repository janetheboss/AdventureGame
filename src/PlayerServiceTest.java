import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        playerService = new PlayerService();
        Player.getInstance("ValidPlayer", "Mage");
    }

    @Test
    void testEditInfo_Success() {
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
    void testEditInfo_Failure_NoPlayer() {

        Player.setInstance(null);
        Player updatedPlayer = playerService.editPlayerInfo("SomeName", "UpdatedPlayer", "Warrior");

        assertNull(updatedPlayer);
    }
}
