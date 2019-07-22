package Test;

import Model.User;
import Page.BasePage;
import Page.EditYourAdressedPage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditAdressesTest extends BaseTest{
    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void editAdressesTest(User user) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(user);
        MyAdressesPage myAdressesPage;
        myAdressesPage = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);

        if (getParameters().get("login").equals("true")) myAdressesPage.signIn(user.getEmail(), user.getPassword());
        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        //LOGGER.info("Auto-generated email: " + user.getEmail() + " password: " + user.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyAdresses().click();
        myAdressesPage.getButtonUpdate().click();
        EditYourAdressedPage editYourAdressedPage;
        editYourAdressedPage = PageFactory.initElements(BasePage.driver, EditYourAdressedPage.class);
        editYourAdressedPage.getTextFieldAdditionalInformation().clear();
        editYourAdressedPage.getTextFieldAdditionalInformation().sendKeys("This field was automatically edit!");
        editYourAdressedPage.getButtonSave().click();

        BaseTest.makeScreen("editAdressesTest");
        if (getParameters().get("logout").equals("true"))
            BasePage.buttonLogout.click();
    }
}
