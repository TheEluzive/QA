package Test;

import Model.NewUser;
import Page.BasePage;
import Page.MyAccountPage;
import Page.MyAdressesPage;
import Page.PersonalInformationPage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Test.BaseTest.LOGGER;



public class VerifyPersonalInformationTest extends BaseTest {

    @Test(dataProvider = "personalInformation", dataProviderClass=DataProviderNewUserFromJson.class)
    public void verifyPersonalInformationTest(NewUser newUser) throws IOException {
        BasePage.driver.get(BasePage.mainPage);
        System.out.println(newUser);
        MyAdressesPage myAdresses;
        myAdresses = PageFactory.initElements(BasePage.driver, MyAdressesPage.class);
        MyAccountPage myAccountPage;
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);

        if (getParameters().get("login").equals("true"))
            myAdresses.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        //LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        BasePage.buttonAccount.click();
        myAccountPage.getButtonMyPersonalInformation().click();

        PersonalInformationPage personalInformationPage;
        personalInformationPage = PageFactory.initElements(BasePage.driver, PersonalInformationPage.class);

        softAssert.assertEquals(personalInformationPage.getTextFieldFirstName().getAttribute("value"), newUser.getFirstName());
        softAssert.assertEquals(personalInformationPage.getTestFieldLastName().getAttribute("value"), newUser.getLastName());
        softAssert.assertEquals(personalInformationPage.getTextFieldEmail().getAttribute("value"), newUser.getEmail());
        softAssert.assertEquals(personalInformationPage.getSelectorDay().getAttribute("value"), newUser.getDay());
        softAssert.assertEquals(personalInformationPage.getSelectorMonth().getAttribute("value"), newUser.getMonth(), "fial");
        softAssert.assertEquals(personalInformationPage.getSelectorYear().getAttribute("value"), newUser.getYear());
        personalInformationPage.getTextFieldCurrentPassword().sendKeys(newUser.getPassword());

        BaseTest.getSoftAssert().assertAll();
        BaseTest.makeScreen("verifyPersonalInformationTest");
        BasePage.buttonLogout.click();


    }
}
