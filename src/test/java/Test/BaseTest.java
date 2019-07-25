package Test;

import Model.DataPool;
import Model.User;
import Page.BasePage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

//@Listeners(CustomListener.class)
public class BaseTest {
    public static Logger LOGGER;
   // public DataPool dataPool;
    public static  int timeOut;
    public HashMap<String, String> getParameters() {
        return parameters;
    }

    HashMap<String, String> parameters;
    Properties property;
    public static SoftAssert softAssert = new SoftAssert();

    public static SoftAssert getSoftAssert() {
        return softAssert;
    }
    DataPool dataPool;

    @BeforeClass
    public void beforeClass(ITestContext testContext){
        dataPool = new DataPool("dataFile", testContext, User.class);
        dataPool.fillNewDataPool("dataFileToReplace", testContext, User.class);
    }
    @BeforeSuite
    public void beforeSuite(ITestContext testContext) {
        String log4jConfPath = "src/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        LOGGER = Logger.getLogger(BaseTest.class);
        LOGGER.info("Check");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        BasePage.driver = new ChromeDriver();



        LOGGER.info("dataPool created!");

        FileInputStream fis;
        property = new Properties();
        try {
            fis = new FileInputStream("src/resources/config.properties");
            property.load(fis);


            BasePage.mainPage = property.getProperty("mainPage");
            BasePage.dressesPage = BasePage.mainPage + "index.php?id_category=8&controller=category";
            BasePage.personalArea = BasePage.mainPage + "index.php?controller=my-account";
            LOGGER.info("url = " + BasePage.mainPage);
            timeOut = Integer.parseInt(property.getProperty("timeout"));

        } catch (IOException e) {
            LOGGER.error("Properties files wasn`t found");
        }

    }


    @AfterSuite
    public void afterSuite(ITestContext testContext) {
        BasePage.driver.quit();
    }


    public static void makeScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot) BasePage.driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/" + name + System.currentTimeMillis() + ".jpg"));
    }




}
