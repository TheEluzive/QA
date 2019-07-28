package Tests;

import Pages.AuthenticationPage;
import Pages.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class InvalidEmailToLoginTest extends BaseTest {

    @Test
    public void invalidEmailToLoginTest() throws IOException {
        homePage.signIn(INVALID_EMAIL, WRONG_PASSWORD);

        try{
            AuthenticationPage authenticationPage = PageFactory.initElements(BasePage.driver, AuthenticationPage.class);
            authenticationPage.getErrorBoxInvalidEmail().isDisplayed();
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_INVALID_EMAIL_ADDRESS +" was output");
        }
        catch (Exception e)
        {
            makeScreen("invalidEmailToLoginTest");
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_INVALID_EMAIL_ADDRESS +" wasn`t output");
            Assert.fail();
        }
    }

}
