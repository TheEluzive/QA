package Tests;

import org.testng.annotations.Test;

public class VerifyRegistrationPageElementTest extends BaseTest{
    @Test
    public void verifyRegistrationPageElementTest() throws IllegalAccessException {
        registrationPage.inputEmailAndOpenRegistrationPage("kek@gfdgdf.com");
        registrationPage.verifyElementPage();
    }
}
