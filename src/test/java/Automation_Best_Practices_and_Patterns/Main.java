package Automation_Best_Practices_and_Patterns;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Main {
    //org.apache.log4j.Logger logger = Logger.getLogger(Main.class);

    @AfterTest
    public void afterMethod() {
        AbstractPage.quitDriver();
    }


    @Test(dataProvider = "dataProviderNewUser", dataProviderClass = DataProviderNewUser.class)
    public void RegistrationTest(NewUser newUser) {
        AbstractPage homepage = new Homepage();

        homepage.registration(newUser);
        homepage.signIn(newUser.getUsedEmail(), newUser.getPassword());
       // logger.debug("Login: " + newUser.getUsedEmail() + " password: " + newUser.getPassword());
        MyLogger.LOGGER.debug("Login: " + newUser.getUsedEmail() + " password: " + newUser.getPassword());
        ;
        homepage.signOut();
    }


    /*@Test
    public void addDressTest(){
        DressedPage dressedPage = new DressedPage();
        dressedPage.buyPrintedDress();
        dressedPage.openCart();
    }*/


}
