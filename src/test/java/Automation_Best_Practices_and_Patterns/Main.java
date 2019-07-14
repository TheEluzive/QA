package Automation_Best_Practices_and_Patterns;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Main {


    @AfterTest
    public void afterMethod() {
        AbstractPage.quitDriver();
    }


    @Test(dataProvider = "dataProviderNewUser", dataProviderClass = DataProviderNewUser.class)
    public void RegistrationTest(NewUser newUser) {

        AbstractPage homepage = new Homepage();

        homepage.registration(newUser);
        homepage.signIn(newUser.getUsedEmail(), newUser.getPassword());
        AbstractPage.LOGGER.debug("Login: " + newUser.getUsedEmail() + " password: " + newUser.getPassword());
        AbstractPage.LOGGER.info("Login: " + newUser.getUsedEmail() + " password: " + newUser.getPassword());
        try {Assert.assertEquals(AbstractPage.driver.getCurrentUrl(), AbstractPage.personalArea, "Wrong page, registration failed");
        }
        catch (Exception e){
            AbstractPage.LOGGER.error("Wrong page, registration failed");
        }

        homepage.signOut();
        AbstractPage.driver.quit();
    }


    /*@Test
    public void addDressTest(){
        DressedPage dressedPage = new DressedPage();
        dressedPage.buyPrintedDress();
        dressedPage.openCart();
    }*/


}
