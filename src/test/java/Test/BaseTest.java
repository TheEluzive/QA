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
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import java.io.FileInputStream;

import java.util.Properties;

//@Listeners(CustomListener.class)
public class BaseTest {
    public static Logger LOGGER;
    public static DataPool dataPool;

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    HashMap<String,String> parameters;
    public static SoftAssert softAssert = new SoftAssert();
    public static SoftAssert getSoftAssert() {
        return softAssert;
    }

    @BeforeSuite
    public void beforeSuite(ITestContext testContext){
        String log4jConfPath = (System.getProperty("user.dir") + "/src/resources/log4j.properties");
        PropertyConfigurator.configure(log4jConfPath);
        LOGGER = Logger.getLogger(BaseTest.class);
        LOGGER.info("Check");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        BasePage.driver = new ChromeDriver();

        dataPool = new DataPool();
         parameters = new HashMap<>( testContext.getCurrentXmlTest().getAllParameters());

        dataPool.processDataFile(parameters.get("dataFile"), User.class);

        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\config.properties");
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
    public void afterSuite(ITestContext testContext) {
        BasePage.driver.quit();
    }


    public static void makeScreen(String name) throws IOException {
        File screenshot = ((TakesScreenshot) BasePage.driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/"+name + System.currentTimeMillis()+ ".bmp"));
    }







    /*@Test
    public void addDressTest(){
        ProductPage dressedPage = new ProductPage();
        dressedPage.buyPrintedDress();
        dressedPage.openCart();
    }*/


}
