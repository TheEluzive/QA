package Test;

import Model.User;
import Page.BasePage;
import Page.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseTest {



    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void registrationTest(User user) throws IOException {
        BasePage.driver.get(BasePage.mainPage);

        RegistrationPage registrationPage;
        registrationPage = PageFactory.initElements(BasePage.driver, RegistrationPage.class);
        registrationPage.inputEmailAndOpenRegistrationPage(user.getEmail());
        registrationPage.inputPersonalInformation(user);
        BaseTest.makeScreen("registrationTest");
        BasePage.buttonLogout.click();
        registrationPage.signIn(user.getEmail(), user.getPassword());
        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        LOGGER.info("Auto-generated email: " + user.getEmail() + " password: " + user.getPassword());
        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.personalArea);
        if (getParameters().get("logout").equals("true"))
            BasePage.buttonLogout.click();
    }
}
