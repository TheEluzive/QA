package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.AuthenticationPage.MESSAGE_AUTHENTICATION_FAILED;

public class AuthenticationFailedMessageTest extends BaseTest {

    @Test
    public void authenticationFailedTest() {
        homePage.signIn(WRONG_EMAIL, WRONG_PASSWORD);
        Assert.assertEquals(authenticationPage.findErrorBoxAuthenticationFailed(), MESSAGE_AUTHENTICATION_FAILED);
    }

}
