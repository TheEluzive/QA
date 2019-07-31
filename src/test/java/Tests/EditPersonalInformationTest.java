package Tests;

import Model.DataPool;
import Model.User;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditPersonalInformationTest extends BaseTest {

    @BeforeSuite
    public void dataPool(ITestContext testContext) {
        dataPool = new DataPool<>("data", testContext, User.class);
        dataPool.fillNewDataPool("dataFileToReplace", testContext, User.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }


    @Test(dataProvider = "personalInformation")
    public void editPersonalInformationTest(User user, User userForChanges) {

        makeAccountAndLogout(user);

        myAccountPage.signIn(user.getPersonalInfo().getEmail(), user.getPersonalInfo().getPassword());
        myAccountPage.getButtonMyPersonalInformation().click();
        personalInformationPage.updateInformation(userForChanges, user.getPersonalInfo().getPassword());

        Assert.assertTrue(personalInformationPage.messageOfSuccessChanges());
    }
}
