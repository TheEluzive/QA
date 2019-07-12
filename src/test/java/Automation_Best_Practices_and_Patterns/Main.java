package Automation_Best_Practices_and_Patterns;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.logging.Logger;

@Listeners (CustomListener.class)
public class Main {
    @AfterTest
    public void afterMethod(){
        AbstractPage.quitDriver();
    }



    @Test(dataProvider = "dataProviderNewUser", dataProviderClass = DataProviderNewUser.class)

    public void RegistrationTest(NewUser newUser) {
        Logger logger = Logger.getLogger(String.valueOf(Main.class));
        AbstractPage homepage = new Homepage();
        logger.info("Registration was started");
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
