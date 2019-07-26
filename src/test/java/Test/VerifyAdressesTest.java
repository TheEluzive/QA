package Test;

import Model.User;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyAdressesTest extends BaseTest {
    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUserFromJson() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void checkAdressesTest(User user, User userForChanges) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(user);
        MyAdressesPage myAdressesPage;
        myAdressesPage = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);
        makeScreen("checkAdressesTest");
        if (getParameters().get("login").equals("true"))
            myAdressesPage.signIn(user.getEmail(), user.getPassword());

        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        //LOGGER.info("Auto-generated email: " + user.getEmail() + " password: " + user.getPassword());
        myAdressesPage.getButtonAccount().click();
        myAccountPage.getButtonMyAddresses().click();

        /*softAssert.assertEquals(myAdressesPage.getAddressedFirstName().getText(), user.getFirstName()+ user.getAddressFirstName()+
                " " + user.getLastName()+ user.getAddressLastName());
        softAssert.assertEquals(myAdressesPage.getAddress1().getText(), user.getAddress1()+" " + user.getAddress2());
        softAssert.assertEquals(myAdressesPage.getAddress2().getText(), user.getCity()+", "+"Georgia "+ user.getPostCode());
        softAssert.assertEquals(myAdressesPage.getCountry().getText(), "United States");
        softAssert.assertEquals(myAdressesPage.getHomePhone().getText(), user.getHomePhone());
        softAssert.assertEquals(myAdressesPage.getMobilePhone().getText(), user.getMobileNumber());*/

        BaseTest.getSoftAssert().assertAll();

    }
}
