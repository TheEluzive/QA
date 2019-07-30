package Tests;

import Model.DataPool;
import Model.User;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyAddressesTest extends BaseTest {

    @BeforeSuite
    public void dataPool(ITestContext testContext) {
        dataPool = new DataPool<>("data", testContext, User.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void verifyAddressesTest(User user) {

        myAddressesPage.signIn(user.getPersonalInfo().getEmail(), user.getPersonalInfo().getPassword());
        myAddressesPage.getButtonAccount().click();
        myAccountPage.getButtonMyAddresses().click();
        myAddressesPage.getButtonUpdate().click();

        softAssert.assertEquals(editYourAddressedPage.getUserFirstName(), user.getPersonalInfo().getFirstName());
        softAssert.assertEquals(editYourAddressedPage.getUserLastName(), user.getPersonalInfo().getLastName());
        softAssert.assertEquals(editYourAddressedPage.getUserAddressFromPage(), user.getAddress());
        BaseTest.getSoftAssert().assertAll();
    }
}
