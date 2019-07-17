package Test;

import Model.DataPool;
import Page.BasePage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;
import java.util.HashMap;


import java.io.FileInputStream;

import java.util.Properties;

//@Listeners(CustomListener.class)
public class BaseTest {
    public static Logger LOGGER;
    public DataPool dataPool;

    @BeforeSuite
    public void beforeSuite(ITestContext testContext){
        String log4jConfPath = (System.getProperty("user.dir") + "/src/resources/log4j.properties");
        PropertyConfigurator.configure(log4jConfPath);
        LOGGER = Logger.getLogger(BaseTest.class);
        LOGGER.info("Check");

        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/test/Drivers/chromedriver.exe"));
        BasePage.driver = new ChromeDriver();

        dataPool = new DataPool();
        HashMap<String,String> parameters = new HashMap<>( testContext.getCurrentXmlTest().getAllParameters());
        dataPool.processDataFile(parameters.get( "dataFile" ));

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







    /*@Test
    public void addDressTest(){
        ProductPage dressedPage = new ProductPage();
        dressedPage.buyPrintedDress();
        dressedPage.openCart();
    }*/


}
