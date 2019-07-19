package Test;

import Model.NewUser;
import Page.BasePage;
import Page.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class RegistrationTest extends BaseTest {



    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void registrationTest(NewUser newUser) throws IOException {
        BasePage.driver.get(BasePage.mainPage);

        RegistrationPage registrationPage;
        registrationPage = PageFactory.initElements(BasePage.driver, RegistrationPage.class);
        registrationPage.inputEmailAndOpenRegistrationPage(newUser.getEmail());
        registrationPage.inputPersonalInformation(newUser);
        BaseTest.makeScreen("registrationTest");
        BasePage.buttonLogout.click();
        registrationPage.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.personalArea);
        BasePage.buttonLogout.click();
    }
}
