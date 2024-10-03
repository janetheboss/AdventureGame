import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserChangePasswordTest {
    private User registeredUser;
    private RegisterUserInput userInput;
    private UserChangePassword userChangePassword;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        RegisterUser registerUser = new RegisterUser();
        String initialPassword = "oldPassword123";
        String salt = registerUser.generateSalt();
        String hashedPassword = registerUser.hashPassword(initialPassword, salt);

        registeredUser = new User("testUser", hashedPassword, salt);
        userInput = new RegisterUserInput("testUser", initialPassword, initialPassword);
        userChangePassword = new UserChangePassword();
    }

    @Test
    public void testChangePassword_Success() throws NoSuchAlgorithmException {
        String oldPassword = "oldPassword123";
        String newPassword = "newPassword123";
        String repeatPassword = "newPassword123";

        userChangePassword.setOldPassword(oldPassword);
        userChangePassword.setNewPassword(newPassword);
        userChangePassword.setRepeatPassword(repeatPassword);

        userChangePassword.changePassword(registeredUser, userInput);

        String hashedNewPassword = new RegisterUser().hashPassword(newPassword, registeredUser.getSalt());
        assertEquals(hashedNewPassword, registeredUser.getHashedPassword(), "Password should be updated successfully.");
    }

    @Test
    public void testChangePassword_Failure_IncorrectOldPassword() throws NoSuchAlgorithmException {
        String oldPassword = "wrongOldPassword";
        String newPassword = "newPassword123";
        String repeatPassword = "newPassword123";

        userChangePassword.setOldPassword(oldPassword);
        userChangePassword.setNewPassword(newPassword);
        userChangePassword.setRepeatPassword(repeatPassword);

        userChangePassword.changePassword(registeredUser, userInput);

        String hashedOldPassword = new RegisterUser().hashPassword("oldPassword123", registeredUser.getSalt());
        assertEquals(hashedOldPassword, registeredUser.getHashedPassword(), "Password should not be updated due to incorrect old password.");
    }
}
