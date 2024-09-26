public class User {
    private String username;
    private String hashedPassword;
    private String salt;

    private static User instance;

    User(String username, String hashedPassword, String salt) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    public static User getInstance() {
        return instance;
    }

    public static void setInstance(String username, String hashedPassword, String salt) {
        if (instance == null) {
            instance = new User(username, hashedPassword, salt);
        }
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

    public static void resetInstance() {
        instance = null;
    }
}
