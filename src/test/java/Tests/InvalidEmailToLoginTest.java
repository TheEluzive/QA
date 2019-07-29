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
        Assert.assertTrue(authenticationPage.findErrorBoxInvalidEmail());
    }

}
