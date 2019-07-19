package Test;

import Model.NewUser;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.logging.Logger;

public class VerifyAdressesTest extends BaseTest {
    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void checkAdressesTest(NewUser newUser) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(newUser);
        MyAdressesPage myAdresses;
        myAdresses = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);
        makeScreen("checkAdressesTest");
        if (getParameters().get("login").equals("true"))
            myAdresses.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        //LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyAdresses().click();

        softAssert.assertEquals(myAdresses.getAdressedFirstName().getText(), newUser.getFirstName()+newUser.getAdressFirstName()+
                " " + newUser.getLastName()+newUser.getAdressLastName());
        softAssert.assertEquals(myAdresses.getAdress1().getText(), newUser.getAdress1()+" " + newUser.getAdress2());
        softAssert.assertEquals(myAdresses.getAdress2().getText(), newUser.getCity()+", "+"Georgia "+newUser.getPostCode());
        softAssert.assertEquals(myAdresses.getCountry().getText(), "United States");
        softAssert.assertEquals(myAdresses.getHomePhone().getText(), newUser.getHomePhone());
        softAssert.assertEquals(myAdresses.getMobilePhone().getText(), newUser.getMobileNumber());

        BaseTest.getSoftAssert().assertAll();
        BasePage.buttonLogout.click();
    }
}
