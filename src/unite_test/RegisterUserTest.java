package unite_test;

import static org.junit.jupiter.api.Assertions.*;

import Exceptions.UserException;
import input_output.RegisterUserInput;
import input_output.User;
import operation.RegisterUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;

public class RegisterUserTest {

    @Test
    public void testRegisterSuccess() throws UserException, NoSuchAlgorithmException {
        RegisterUserInput input = new RegisterUserInput("validUser", "validPass123", "validPass123");

        RegisterUser registerUser = new RegisterUser();
        User registeredUser = registerUser.register(input);

        Assertions.assertNotNull(registeredUser, "input_output.User should be successfully registered");
        Assertions.assertEquals("validUser", registeredUser.getUsername(), "Username should be 'validUser'");
        Assertions.assertNotEquals("validPass123", registeredUser.getHashedPassword(), "Password should be hashed, not plain text");
    }

    @Test
    public void testPasswordsDoNotMatch() {
        RegisterUserInput input = new RegisterUserInput("testUser", "password123", "password321");

        RegisterUser registerUser = new RegisterUser();

        Exception exception = assertThrows(UserException.class, () -> {
            registerUser.register(input);
        });

        assertEquals("Passwords do not match!", exception.getMessage(), "Password mismatch should trigger exception");
    }

    @Test
    public void testEmptyUsername() {
        RegisterUserInput input = new RegisterUserInput("", "password123", "password123");

        RegisterUser registerUser = new RegisterUser();

        Exception exception = assertThrows(UserException.class, () -> {
            registerUser.register(input);
        });

        assertEquals("Username and password cannot be empty!", exception.getMessage(), "Empty username should trigger exception");
    }

    @Test
    public void testEmptyPassword() {
        RegisterUserInput input = new RegisterUserInput("testUser", "", "");

        RegisterUser registerUser = new RegisterUser();

        Exception exception = assertThrows(UserException.class, () -> {
            registerUser.register(input);
        });

        assertEquals("Username and password cannot be empty!!!", exception.getMessage(), "Empty password should trigger exception");
    }
}
