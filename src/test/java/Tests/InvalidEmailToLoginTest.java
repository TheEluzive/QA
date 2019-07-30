package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;


import static Pages.AuthenticationPage.MESSAGE_INVALID_EMAIL_ADDRESS;

public class InvalidEmailToLoginTest extends BaseTest {

    @Test
    public void invalidEmailToLoginTest() {
        homePage.signIn(INVALID_EMAIL, WRONG_PASSWORD);
        Assert.assertEquals(authenticationPage.findErrorBoxAuthenticationFailed(), MESSAGE_INVALID_EMAIL_ADDRESS);
    }

}
