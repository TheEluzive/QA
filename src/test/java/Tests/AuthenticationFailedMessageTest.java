package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthenticationFailedMessageTest extends BaseTest {

    @Test
    public void authenticationFailedTest() throws IOException {
        homePage.signIn(WRONG_EMAIL, WRONG_PASSWORD);
        Assert.assertTrue(authenticationPage.findErrorBoxAuthenticationFailed());
    }

}
