package Tests;

import Model.DataPool;
import Model.User;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class VerifyPersonalInformationTest extends BaseTest {

    @BeforeSuite
    public void dataPool(ITestContext testContext) {
        dataPool = new DataPool<>("data", testContext, User.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void verifyPersonalInformationTest(User user) {

        makeAccountAndLogout(user);

        myAddressesPage.signIn(user.getPersonalInfo().getEmail(), user.getPersonalInfo().getPassword());
        myAccountPage.getButtonAccount().click();
        myAccountPage.getButtonMyPersonalInformation().click();

        Assert.assertEquals(personalInformationPage.getPersonalInfoFromPage(user), user.getPersonalInfo());
    }
}
