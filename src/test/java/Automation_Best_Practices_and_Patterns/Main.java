package Automation_Best_Practices_and_Patterns;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Main {
    @AfterTest
    public void afterTest(){
        Page.quitDriver();
    }

    @Test(dataProvider = "dataProviderNewUser", dataProviderClass = DataProviderNewUser.class)
    public void RegistrationTest(NewUser newUser) {
        Page homepage = new Homepage();
        homepage.registration(newUser);
        homepage.signIn(newUser.getUsedEmail(), newUser.getPassword());
        homepage.signOut();
    }


    @Test
    public void addDressTest(){
        DressedPage dressedPage = new DressedPage();
        dressedPage.buyPrintedDress();
        dressedPage.openCart();
    }






}
