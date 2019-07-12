package Automation_Best_Practices_and_Patterns;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class Main {
    @AfterTest
    public void afterMethod(){
        Page.quitDriver();
    }

    @Test(dataProvider = "dataProviderNewUser", dataProviderClass = DataProviderNewUser.class)
    public void RegistrationTest(NewUser newUser) {
        Logger logger = Logger.getLogger(String.valueOf(MyLogger.class));
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
