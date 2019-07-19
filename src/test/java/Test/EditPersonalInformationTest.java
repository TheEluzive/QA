package Test;

import Model.NewUser;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import Page.PersonalInformationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditPersonalInformationTest extends BaseTest {
    @Test(dataProvider = "personalInformation", dataProviderClass = DataProviderNewUserFromJson.class)
    public void editPersonalInformationTest(NewUser newUser) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(newUser);
        MyAdressesPage myAdresses;
        myAdresses = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);

        if (getParameters().get("login").equals("true")) myAdresses.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        //LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyPersonalInformation().click();

        PersonalInformationPage personalInformationPage;
        personalInformationPage = PageFactory.initElements(BasePage.driver, PersonalInformationPage.class);
        personalInformationPage.selectYear("2000");
        personalInformationPage.getTestFieldLastName().clear();
        personalInformationPage.getTestFieldLastName().sendKeys("Ivanov");
        personalInformationPage.getTextFieldCurrentPassword().sendKeys(newUser.getPassword());
        personalInformationPage.getButtonSave().click();

        BaseTest.makeScreen("editPersonalInformationTest");



    }
}
