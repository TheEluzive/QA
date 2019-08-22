package Tests;

import Model.DataPool;
import Model.User;
import Pages.*;
import Util.CustomListener;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Listeners(CustomListener.class)
public class BaseTest {

    public static Logger LOGGER;
    public static int timeOut;

    MyAccountPage myAccountPage;
    MyAddressesPage myAddressesPage;
    PersonalInformationPage personalInformationPage;
    RegistrationPage registrationPage;
    EditYourAddressedPage editYourAddressedPage;
    HomePage homePage;
    AuthenticationPage authenticationPage;

    Properties property;
    static final SoftAssert softAssert = new SoftAssert();

    static SoftAssert getSoftAssert() {
        return softAssert;
    }

    DataPool dataPool;




    @BeforeSuite
    public void beforeSuite(ITestContext testContext) {

        String log4jConfPath = "src/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        LOGGER = Logger.getLogger(BaseTest.class);


        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        BasePage.driver = new ChromeDriver();

        FileInputStream fis;
        property = new Properties();
        try {
            fis = new FileInputStream("src/resources/config.properties");
            property.load(fis);
            BasePage.mainPage = property.getProperty("mainPage");
            LOGGER.info("url = " + BasePage.mainPage);
            timeOut = Integer.parseInt(property.getProperty("timeout"));

        } catch (IOException e) {
            LOGGER.error("Properties files wasn`t found");
        }
        BasePage.driver.get(BasePage.mainPage);
        homePage = PageFactory.initElements(BasePage.driver, HomePage.class);
        myAccountPage = PageFactory.initElements(BasePage.driver, MyAccountPage.class);
        myAddressesPage = PageFactory.initElements(BasePage.driver, MyAddressesPage.class);
        personalInformationPage = PageFactory.initElements(BasePage.driver, PersonalInformationPage.class);
        registrationPage = PageFactory.initElements(BasePage.driver, RegistrationPage.class);
        editYourAddressedPage = PageFactory.initElements(BasePage.driver, EditYourAddressedPage.class);
        authenticationPage = PageFactory.initElements(BasePage.driver, AuthenticationPage.class);

    }


    /*@AfterSuite
    public void afterSuite(ITestContext testContext) {
        BasePage.driver.quit();
    }*/

    //@Attachment(value = "Page screenshot", type = "image/png")

    public static void makeScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot) BasePage.driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("target/surefire-reports/screenshots/" + name + System.currentTimeMillis() + ".jpg"));
    }

    public void makeAccountAndLogout(User user){
        user.getPersonalInfo().setEmail(System.currentTimeMillis()+user.getPersonalInfo().getEmail());
        LOGGER.debug(user.getPersonalInfo().getEmail());
        registrationPage.inputEmailAndOpenRegistrationPage(user.getPersonalInfo().getEmail());
        registrationPage.inputPersonalInformation(user);
        registrationPage.getButtonLogout().click();
    }


}
