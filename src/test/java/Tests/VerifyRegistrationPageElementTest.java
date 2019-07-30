package Tests;

import Pages.RegistrationPage;
import org.testng.annotations.Test;

public class VerifyRegistrationPageElementTest extends BaseTest{
    @Test
    public void verifyRegistrationPageElementTest() throws IllegalAccessException, InterruptedException {
        registrationPage.inputEmailAndOpenRegistrationPage("kek@gfdgdf.com");
        Thread.sleep(5000);
        registrationPage.verifyElementPage();
    }
}
