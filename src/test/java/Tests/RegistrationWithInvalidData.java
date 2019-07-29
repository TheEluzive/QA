package Tests;

import Model.DataPool;
import Model.User;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationWithInvalidData extends BaseTest {
    @BeforeSuite
    public void dataPool(ITestContext testContext){
        dataPool = new DataPool<>("data", testContext, User.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void registrationWithInvalidData(User user) throws IOException {
        registrationPage.inputEmailAndOpenRegistrationPage(user.getPersonalInfo().getEmail());
        registrationPage.inputPersonalInformation(user);
        Assert.assertTrue(registrationPage.findError());
        makeScreen("registrationWithInvalidData");
    }
}
