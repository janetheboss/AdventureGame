package input_output;

public class User {
    private static User instance;

    private String username;
    private String hashedPassword;
    private String salt;
    private boolean isMarkedForDeletion;

    public User(String username, String hashedPassword, String salt) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.isMarkedForDeletion = false;
    }

    public static User getInstance(String username, String hashedPassword, String salt) {
        if (instance == null) {
            instance = new User(username, hashedPassword, salt);
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isMarkedForDeletion() {
        return isMarkedForDeletion;
    }

    public void setMarkedForDeletion(boolean isMarkedForDeletion) {
        this.isMarkedForDeletion = isMarkedForDeletion;
    }
}
