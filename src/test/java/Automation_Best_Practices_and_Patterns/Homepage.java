package Automation_Best_Practices_and_Patterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Homepage extends Page {
    @Override
    void contactUs() {
        super.contactUs();
    }

    @Override
    void signIn(String email, String password) {
        super.signIn(email, password);
    }

    @Override
    void signOut() {
        super.signOut();
    }

    @Override
    public String[] registration(NewUser newUser) {
        return super.registration(newUser);
    }

    @Override
    void openCart() {
        super.openCart();
    }



}
