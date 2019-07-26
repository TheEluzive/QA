package Test;
import Model.DataPool;
import Model.User;
import Page.BasePage;
import Page.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseTest {



    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }





    @Test(dataProvider = "personalInformation")
    public void registrationTest(User user) throws IOException {

        BasePage.driver.get(BasePage.mainPage);

        RegistrationPage registrationPage;
        registrationPage = PageFactory.initElements(BasePage.driver, RegistrationPage.class);
        registrationPage.inputEmailAndOpenRegistrationPage(user.getEmail());
        registrationPage.inputPersonalInformation(user);
        BaseTest.makeScreen("registrationTest");
        registrationPage.getButtonLogout().click();
        registrationPage.signIn(user.getEmail(), user.getPassword());
        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        LOGGER.info("Auto-generated email: " + user.getEmail() + " password: " + user.getPassword());
        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.personalArea);
        registrationPage.getButtonLogout().click();
    }


}

