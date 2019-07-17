package Test;

import Model.NewUser;
import Page.BasePage;
import Page.RegistrationPage;
import Util.CustomListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners(CustomListener.class)
public class BaseTest {
    public static Logger LOGGER;
    @BeforeSuite
    public void beforeSuite(){
        String log4jConfPath = (System.getProperty("user.dir") + "/src/resources/log4j.properties");
        PropertyConfigurator.configure(log4jConfPath);
        LOGGER = Logger.getLogger(BaseTest.class);
        LOGGER.info("Check");
        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/test/Drivers/chromedriver.exe"));
        BasePage.driver = new ChromeDriver();


        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("C:\\Users\\evgeny.tkach\\Desktop\\projects\\QA\\src\\resources\\config.properties");
            property.load(fis);
            BasePage.mainPage = property.getProperty("mainPage");
            BasePage.dressesPage = BasePage.mainPage + "index.php?id_category=8&controller=category";
            BasePage.personalArea = BasePage.mainPage +"index.php?controller=my-account";
            LOGGER.info("url = " + BasePage.mainPage);

        } catch (IOException e) {
            LOGGER.error("Properties files wasn`t found");
        }

    }

    @AfterSuite
    public void afterSuite() {
        BasePage.driver.quit();
    }




    @Test(dataProvider = "dataProviderNewUser", dataProviderClass = DataProviderNewUser.class)
    public void RegistrationTest(NewUser newUser) {

        RegistrationPage registrationPage;
        registrationPage = PageFactory.initElements(BasePage.driver, RegistrationPage.class);
        registrationPage.inputEmailAndOpenRegistrationPage(newUser.getEmail());
        registrationPage.inputPersonalInformation(newUser);
        BasePage.buttonLogout.click();
        registrationPage.signIn(newUser.getEmail(), newUser.getPassword());
        LOGGER.debug("Login: " + newUser.getEmail() + " password: " + newUser.getPassword());
        LOGGER.info("Auto-generated email: " + newUser.getEmail() + " password: " + newUser.getPassword());
        Assert.assertEquals(BasePage.driver.getCurrentUrl(), BasePage.personalArea);
        BasePage.buttonLogout.click();
    }


    /*@Test
    public void addDressTest(){
        ProductPage dressedPage = new ProductPage();
        dressedPage.buyPrintedDress();
        dressedPage.openCart();
    }*/


}
