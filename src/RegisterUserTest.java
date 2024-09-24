import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class RegisterUserTest {

    @Test
    public void testRegisterSuccess() {
        String input = "validUser\nvalidPass123\nvalidPass123\n";
        Scanner scanner = new Scanner(input);

        RegisterUser registerUser = new RegisterUser();
        User registeredUser = registerUser.register(scanner);

        assertNotNull(registeredUser, "User should be successfully registered");
        assertEquals("validUser", registeredUser.getUsername(), "Username should be 'validUser'");
        assertNotEquals("validPass123", registeredUser.getHashedPassword(), "Password should be hashed, not plain text");

        scanner.close();
    }

    @Test
    public void testPasswordsDoNotMatch() {
        String input = "testUser\npassword123\npassword321\n";
        Scanner scanner = new Scanner(input);

        RegisterUser registerUser = new RegisterUser();
        User registeredUser = registerUser.register(scanner);

        assertNull(registeredUser, "User registration should fail due to password mismatch");

        scanner.close();
    }

    @Test
    public void testEmptyUsername() {
        String input = "\npassword123\npassword123\n";
        Scanner scanner = new Scanner(input);

        RegisterUser registerUser = new RegisterUser();
        User registeredUser = registerUser.register(scanner);

        assertNull(registeredUser, "User registration should fail due to empty username");

        scanner.close();
    }

    @Test
    public void testEmptyPassword() {
        String input = "testUser\n\n\n";
        Scanner scanner = new Scanner(input);

        RegisterUser registerUser = new RegisterUser();
        User registeredUser = registerUser.register(scanner);

        assertNull(registeredUser, "User registration should fail due to empty password");

        scanner.close();
    }
}
