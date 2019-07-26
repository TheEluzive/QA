package Test;

import Model.User;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import Page.PersonalInformationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditPersonalInformationTest extends BaseTest {
    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void editPersonalInformationTest(User user, User userForChanges) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(user);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);
        myAccountPage.signIn(user.getEmail(), user.getPassword());
        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        makeScreen("personalInformation");
        myAccountPage.getButtonMyPersonalInformation().click();


        PersonalInformationPage personalInformationPage;
        personalInformationPage = PageFactory.initElements(BasePage.driver, PersonalInformationPage.class);
        //personalInformationPage.updateInformation(userForChanges, user.getPassword());

        BaseTest.makeScreen("editPersonalInformationTest");
        Assert.assertEquals(BasePage.driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=identity");



    }
}
