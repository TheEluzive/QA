package Tests;

import Model.DataPool;
import Model.User;
import Pages.BasePage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    public void registrationTest(User user) {

        makeAccountAndLogout(user);
        registrationPage.signIn(user.getPersonalInfo().getEmail(), user.getPersonalInfo().getPassword());

        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.mainPage + property.getProperty("myAccountPage"));
    }


}

