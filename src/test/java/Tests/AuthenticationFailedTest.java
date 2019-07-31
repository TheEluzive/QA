package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static Tests.Error_Messages_and_Data.*;

public class AuthenticationFailedTest extends BaseTest {

    @Test
    public void authenticationFailedTest() {
        homePage.signIn(WRONG_EMAIL, WRONG_PASSWORD);
        Assert.assertEquals(authenticationPage.findErrorBoxAuthenticationFailed(), MESSAGE_AUTHENTICATION_FAILED);
    }

}
