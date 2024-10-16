package test;

import model.User;
import operation.DeleteUser;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DeleteUserTest {
    private User user;
    private DeleteUser deleteUser;
    private Scanner scanner;

    @Before
    public void setUp() {
        user = User.getInstance("testUser", "hashedPassword", "salt");
    }

    @Test
    public void testRequestAccountDeletion_Success() {
        InputStream in = new ByteArrayInputStream("testUser\n".getBytes());
        scanner = new Scanner(in);
        deleteUser = new DeleteUser(scanner, user);

        assertFalse(user.isMarkedForDeletion());

        deleteUser.requestAccountDeletion();

        assertTrue(user.isMarkedForDeletion());
    }

    @Test
    public void testRequestAccountDeletion_Failure_UsernameMismatch() {
        InputStream in = new ByteArrayInputStream("wrongUser\n".getBytes());
        scanner = new Scanner(in);
        deleteUser = new DeleteUser(scanner, user);

        assertFalse(user.isMarkedForDeletion());

        deleteUser.requestAccountDeletion();

        assertFalse(user.isMarkedForDeletion());
    }
}
