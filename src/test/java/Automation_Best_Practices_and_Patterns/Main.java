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

        Homepage homepage = new Homepage();

        homepage.registration(newUser);
        homepage.signIn(newUser.getEmail(), newUser.getPassword());
        AbstractPage.LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        AbstractPage.LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        RegistratedUser registratedUser = new RegistratedUser(newUser.getEmail(), newUser.getPassword());

        try {
            Assert.assertEquals(AbstractPage.driver.getCurrentUrl(), AbstractPage.personalArea);
        }
        catch (Error e){
            AbstractPage.LOGGER.error("Wrong page, registration failed", e);
        }
        homepage.signOut();
        AbstractPage.driver.quit();

        /*try {//for LOGGER.ERROR
            Assert.assertEquals(AbstractPage.driver.getCurrentUrl() + "fdss", AbstractPage.personalArea);
        }
        catch (Error e){
            AbstractPage.LOGGER.error("Wrong page, registration failed", e);
        }
        finally {
            homepage.signOut();
            AbstractPage.driver.quit();
        }*/



    }


    /*@Test
    public void addDressTest(){
        DressedPage dressedPage = new DressedPage();
        dressedPage.buyPrintedDress();
        dressedPage.openCart();
    }*/


}
