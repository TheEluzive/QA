package Test;

import Model.User;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyAdressesTest extends BaseTest {
    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void checkAdressesTest(User user) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(user);
        MyAdressesPage myAdresses;
        myAdresses = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);
        makeScreen("checkAdressesTest");
        if (getParameters().get("login").equals("true"))
            myAdresses.signIn(user.getEmail(), user.getPassword());

        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        //LOGGER.info("Auto-generated email: " + user.getEmail() + " password: " + user.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyAdresses().click();

        softAssert.assertEquals(myAdresses.getAdressedFirstName().getText(), user.getFirstName()+ user.getAdressFirstName()+
                " " + user.getLastName()+ user.getAdressLastName());
        softAssert.assertEquals(myAdresses.getAdress1().getText(), user.getAdress1()+" " + user.getAdress2());
        softAssert.assertEquals(myAdresses.getAdress2().getText(), user.getCity()+", "+"Georgia "+ user.getPostCode());
        softAssert.assertEquals(myAdresses.getCountry().getText(), "United States");
        softAssert.assertEquals(myAdresses.getHomePhone().getText(), user.getHomePhone());
        softAssert.assertEquals(myAdresses.getMobilePhone().getText(), user.getMobileNumber());

        BaseTest.getSoftAssert().assertAll();
        if (getParameters().get("logout").equals("true"))
        BasePage.buttonLogout.click();
    }
}
