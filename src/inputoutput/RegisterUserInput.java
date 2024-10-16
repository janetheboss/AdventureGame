package inputoutput;

public class RegisterUserInput {
    private String username;
    private String password;
    private String confirmPassword;

    public RegisterUserInput(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public boolean isPasswordConfirmed() {
        return this.password.equals(this.confirmPassword);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
        this.confirmPassword = newPassword;
    }

}
