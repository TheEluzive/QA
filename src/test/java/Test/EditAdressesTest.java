package Test;

import Model.NewUser;
import Page.BasePage;
import Page.EditYourAdressedPage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class EditAdressesTest extends BaseTest{
    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void editAdressesTest(NewUser newUser) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(newUser);
        MyAdressesPage myAdressesPage;
        myAdressesPage = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);

        if (getParameters().get("login").equals("true")) myAdressesPage.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        //LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyAdresses().click();
        myAdressesPage.getButtonUpdate().click();
        EditYourAdressedPage editYourAdressedPage;
        editYourAdressedPage = PageFactory.initElements(BasePage.driver, EditYourAdressedPage.class);
        editYourAdressedPage.getTextFieldAdditionalInformation().clear();
        editYourAdressedPage.getTextFieldAdditionalInformation().sendKeys("This field was automatically edit!");
        editYourAdressedPage.getButtonSave().click();

        BaseTest.makeScreen("editAdressesTest");

    }
}
