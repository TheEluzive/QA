package Test;

import Model.DataPool;
import Model.User;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

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
    public void editPersonalInformationTest(User user, User userForChanges) throws IOException {

        myAccountPage.signIn(user.getPersonalInfo().getEmail(), user.getPassword());
        myAccountPage.getButtonMyPersonalInformation().click();
        personalInformationPage.updateInformation(userForChanges, user.getPassword());

        BaseTest.makeScreen("editPersonalInformationTest");
        Assert.assertTrue(personalInformationPage.messageOfSuccessChanges());
    }
}
