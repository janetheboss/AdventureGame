import Exceptions.UserException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class RegisterUser {

    public User register(RegisterUserInput input) throws UserException, NoSuchAlgorithmException {
        if (input.getUsername().trim().isEmpty() || input.getPassword().trim().isEmpty()) {
            throw new UserException("Username and password cannot be empty!");
        }

        if (!input.isPasswordConfirmed()) {
            throw new UserException("Passwords do not match!");
        }

        String salt = generateSalt();
        String hashedPassword = hashPassword(input.getPassword(), salt);

        return new User(input.getUsername(), hashedPassword, salt);
    }

        public String generateSalt() throws NoSuchAlgorithmException {
         SecureRandom sr = SecureRandom.getInstanceStrong();
         byte[] saltBytes = new byte[16];
         sr.nextBytes(saltBytes);
         return Base64.getEncoder().encodeToString(saltBytes);
    }

    public String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String saltedPassword = password + salt;
        byte[] hashedBytes = md.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashedBytes);
    }
}
