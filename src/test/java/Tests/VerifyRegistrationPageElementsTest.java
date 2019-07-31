package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyRegistrationPageElementsTest extends BaseTest {

    @Test
    public void verifyRegistrationPageElementsTest() throws IllegalAccessException {
        registrationPage.inputEmailAndOpenRegistrationPage("kek@gfdgdf.com");
        Assert.assertTrue(registrationPage.verifyElementPage());
    }
}
