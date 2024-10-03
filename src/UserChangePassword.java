import java.security.NoSuchAlgorithmException;

public class UserChangePassword {
    private String oldPassword;
    private String newPassword;
    private String repeatPassword;

    private RegisterUser registerUser = new RegisterUser();

    public UserChangePassword(String oldPassword, String newPassword, String repeatPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.repeatPassword = repeatPassword;
    }

    public UserChangePassword() {

    }

    public void changePassword(User user, RegisterUserInput input) throws NoSuchAlgorithmException {
        String hashedOldPassword = registerUser.hashPassword(oldPassword, user.getSalt());
        if (!hashedOldPassword.equals(user.getHashedPassword())) {
            System.out.println("Old password is incorrect. Please try again.");
            return;
        }

        String hashedNewPassword = registerUser.hashPassword(newPassword, user.getSalt());
        user.setHashedPassword(hashedNewPassword);
        System.out.println("Password has been successfully changed.");

        input.setPassword(newPassword);
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
