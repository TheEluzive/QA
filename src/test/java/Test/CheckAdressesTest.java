package Test;

import Model.NewUser;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class CheckAdressesTest extends BaseTest {
    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void checkAdressesTest(NewUser newUser) throws InterruptedException {
        System.out.println(newUser);
        MyAdressesPage myAdresses;
        myAdresses = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);

        myAdresses.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        //LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyAdresses().click();
        Assert.assertEquals(myAdresses.getAdressedFirstName().getText(), newUser.getFirstName()+newUser.getAdressFirstName()+
                " " + newUser.getLastName()+newUser.getAdressLastName());
        Assert.assertEquals(myAdresses.getAdress1().getText(), newUser.getAdress1()+" " + newUser.getAdress2());
        Assert.assertEquals(myAdresses.getAdress2().getText(), newUser.getCity()+", "+"Georgia "+newUser.getPostCode());
        Assert.assertEquals(myAdresses.getCountry().getText(), newUser.getCountry());
        Assert.assertEquals(myAdresses.getHomePhone().getText(), newUser.getHomePhone());
        Assert.assertEquals(myAdresses.getMobilePhone().getText(), newUser.getMobileNumber());





        BasePage.buttonLogout.click();
    }
}
