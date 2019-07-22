package Test;

import Model.User;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import Page.PersonalInformationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;


public class VerifyPersonalInformationTest extends BaseTest {

    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void verifyPersonalInformationTest(User user) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(user);
        MyAdressesPage myAdresses;
        myAdresses = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);

        if (getParameters().get("login").equals("true"))
            myAdresses.signIn(user.getEmail(), user.getPassword());
        LOGGER.debug("Login: " + user.getEmail() + " password: " + user.getPassword());
        //LOGGER.info("Auto-generated email: " + user.getEmail() + " password: " + user.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyPersonalInformation().click();

        PersonalInformationPage personalInformationPage;
        personalInformationPage = PageFactory.initElements(BasePage.driver, PersonalInformationPage.class);

        softAssert.assertEquals(personalInformationPage.getTextFieldFirstName().getAttribute("value"), user.getFirstName());
        softAssert.assertEquals(personalInformationPage.getTestFieldLastName().getAttribute("value"), user.getLastName());
        softAssert.assertEquals(personalInformationPage.getTextFieldEmail().getAttribute("value"), user.getEmail());
        softAssert.assertEquals(personalInformationPage.getSelectorDay().getAttribute("value"), user.getDay());
        softAssert.assertEquals(personalInformationPage.getSelectorMonth().getAttribute("value"), user.getMonth(), "fial");
        softAssert.assertEquals(personalInformationPage.getSelectorYear().getAttribute("value"), user.getYear());
        personalInformationPage.getTextFieldCurrentPassword().sendKeys(user.getPassword());

        BaseTest.getSoftAssert().assertAll();
        BaseTest.makeScreen("verifyPersonalInformationTest");
        if (getParameters().get("logout").equals("true"))
            BasePage.buttonLogout.click();


    }
}
