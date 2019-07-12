package Automation_Best_Practices_and_Patterns;

public class Homepage extends AbstractPage {
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
