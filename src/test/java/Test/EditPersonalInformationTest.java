package Test;

import Model.User;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import Page.PersonalInformationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditPersonalInformationTest extends BaseTest {
    @Test(dataProvider = "personalInformation", dataProviderClass = DataProviderNewUserFromJson.class)
    public void editPersonalInformationTest(User user) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(user);
        MyAdressesPage myAdresses;
        myAdresses = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);

        if (getParameters().get("login").equals("true")) myAdresses.signIn(user.getEmail(), user.getPassword());
        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        //LOGGER.info("Auto-generated email: " + user.getEmail() + " password: " + user.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyPersonalInformation().click();

        PersonalInformationPage personalInformationPage;
        personalInformationPage = PageFactory.initElements(BasePage.driver, PersonalInformationPage.class);
        personalInformationPage.selectYear("2000");
        personalInformationPage.getTestFieldLastName().clear();
        personalInformationPage.getTestFieldLastName().sendKeys("Ivanov");
        personalInformationPage.getTextFieldCurrentPassword().sendKeys(user.getPassword());
        personalInformationPage.getButtonSave().click();

        BaseTest.makeScreen("editPersonalInformationTest");

        if (getParameters().get("logout").equals("true"))
            BasePage.buttonLogout.click();


    }
}
