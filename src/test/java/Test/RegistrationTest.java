package Test;
import Model.DataPool;
import Model.User;
import Page.BasePage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseTest {

    @BeforeSuite
    public void dataPool(ITestContext testContext){
        dataPool = new DataPool<>("data", testContext, User.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }


    @Test(dataProvider = "personalInformation")
    public void registrationTest(User user) throws IOException {

        registrationPage.inputEmailAndOpenRegistrationPage(user.getPersonalInfo().getEmail());
        registrationPage.inputPersonalInformation(user);
        makeScreen("registrationTest");

        registrationPage.getButtonLogout().click();
        registrationPage.signIn(user.getPersonalInfo().getEmail(), user.getPassword());

        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.mainPage + property.getProperty("myAccountPage"));
    }


}

