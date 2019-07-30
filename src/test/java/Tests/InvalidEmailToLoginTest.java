package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static Tests.Error_Messages_and_Data.*;

public class InvalidEmailToLoginTest extends BaseTest {

    @Test
    public void invalidEmailToLoginTest() {
        homePage.signIn(INVALID_EMAIL, WRONG_PASSWORD);
        Assert.assertEquals(authenticationPage.findErrorBoxAuthenticationFailed(), MESSAGE_INVALID_EMAIL_ADDRESS);
    }

}
