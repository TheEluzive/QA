package Tests;

import Model.DataPool;
import Model.User;
import Pages.BasePage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditAddressesTest extends BaseTest {

    @BeforeSuite
    public void dataPool(ITestContext testContext) {
        dataPool = new DataPool<>("data", testContext, User.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void editAddressesTest(User user) {

        myAccountPage.signIn(user.getPersonalInfo().getEmail(), user.getPersonalInfo().getPassword());
        LOGGER.debug("Login: " + user.getPersonalInfo().getEmail() + " password: " + user.getPersonalInfo().getPassword());
        myAccountPage.getButtonMyAddresses().click();
        myAddressesPage.updateAddress(user);

        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.mainPage + property.getProperty("addressesPage"));
    }
}
