package Test;

import Model.User;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditAddressesTest extends BaseTest {
    @Test(dataProvider = "personalInformation", dataProviderClass = DataProviderNewUserFromJson.class)
    public void editAddressesTest(User user, User userForChange) throws InterruptedException, IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(user);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);
        myAccountPage.signIn(user.getEmail(), user.getPassword());
        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        makeScreen("editAddressesTest");
        myAccountPage.getButtonMyAddresses().click();

        MyAdressesPage myAdressesPage = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        myAdressesPage.updateAdress(userForChange);

        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.mainPage+"index.php?controller=addresses");



    }
}
