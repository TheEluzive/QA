package Tests;

import Pages.AuthenticationPage;
import Pages.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthenticationFailedMessageTest extends BaseTest {

    @Test
    public void authenticationFailedTest() throws IOException {
        homePage.signIn(WRONG_EMAIL, WRONG_PASSWORD);
        try{
            AuthenticationPage authenticationPage = PageFactory.initElements(BasePage.driver, AuthenticationPage.class);
            authenticationPage.getErrorBoxAuthenticationFailed().isDisplayed();
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_AUTHENTICATION_FAILED +" was output");
        }
        catch (Exception e)
        {
            makeScreen("authenticationFailedTest");
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_AUTHENTICATION_FAILED +" wasn`t output");
            Assert.fail();
        }
    }

}
