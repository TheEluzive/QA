package Automation_Best_Practices_and_Patterns;

public class RegistratedUser {
    private String email;
    private String password;

    public RegistratedUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegistratedUser(){
        this.email ="";
        this.password = "";
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
