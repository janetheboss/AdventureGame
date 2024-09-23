import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Exceptions.UserException;
import java.util.Scanner;

public class RegisterUserTest {
    @Test
    public void testRegisterSuccess() throws UserException {
        String input = "validUser\nvalidPass123\nvalidPass123\n";
        Scanner scanner = new Scanner(input);

        RegisterUser registeredUser = RegisterUser.register(scanner);

        assertNotNull(registeredUser, "User should be successfully registered");
        assertEquals("validUser", registeredUser.getUsername(), "Username should be validUser");
        assertEquals("validPass123", registeredUser.getPassword(), "Password should be validPass123");

        scanner.close();
    }

    @Test
    public void testPasswordsDoNotMatch() {
        String input = "testUser\npassword123\npassword321\n";
        Scanner scanner = new Scanner(input);

        RegisterUser registeredUser = RegisterUser.register(scanner);

        assertNull(registeredUser, "User registration should fail due to password mismatch");

        scanner.close();
    }
    @Test
    public void testUsernameIsEmpty() {
        String inputEmptyUsername = "\npassword123\npassword123\n";
        Scanner scannerEmptyUsername = new Scanner(inputEmptyUsername);

        RegisterUser registeredUser = RegisterUser.register(scannerEmptyUsername);
        assertNull(registeredUser, "User registration should fail due to empty username");
        scannerEmptyUsername.close();

        String inputEmptyPassword = "testUser\n\n\n";
        Scanner scannerEmptyPassword = new Scanner(inputEmptyPassword);
        registeredUser = RegisterUser.register(scannerEmptyPassword);
        assertNull(registeredUser, "User registration should fail due to empty password");
        scannerEmptyPassword.close();
    }
}
