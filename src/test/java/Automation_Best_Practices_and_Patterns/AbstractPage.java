package Automation_Best_Practices_and_Patterns;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AbstractPage {
    protected static WebDriver driver;
    public static final String mainPage = "http://automationpractice.com/";
    public static final String dressesPage = mainPage + "index.php?id_category=8&controller=category";
    protected static final Logger LOGGER = Logger.getLogger(Main.class);
    public static final String personalArea = "http://automationpractice.com/index.php?controller=my-account";



    AbstractPage(){
        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/test/Drivers/chromedriver.exe"));
        driver = new ChromeDriver();
        driver.get(mainPage);

    }



    void contactUs(){}

    void signIn(String email, String password) {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
    }
    void signOut(){
        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }


    public String[] registration(NewUser newUser) {
        //registrated user and return String email and password
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement inputEmail = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email_create']")));//or 2
        inputEmail.clear();
        newUser.setUsedEmail(System.currentTimeMillis() + newUser.getEmail());
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(newUser.getUsedEmail());
        driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();


        WebElement genderRadio = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_gender1']")));//or 2
        genderRadio.click();
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(newUser.getFirstname());
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(newUser.getLastname());
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(newUser.getPassword());
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        selectDay.selectByValue(newUser.getDay());
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectMonth.selectByValue(newUser.getMonth());
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByValue(newUser.getYear());
        if (newUser.isNewsletterRadio()) driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        if (newUser.isOptinRadio()) driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(newUser.getFirstname2());
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(newUser.getLastname2());
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(newUser.getAdress1());
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(newUser.getAdress2());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(newUser.getCity());
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(newUser.getPostcode());
        Select selectCountry = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
        selectCountry.selectByValue(newUser.getCountry()); //only 21
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        selectState.selectByValue(newUser.getState());//1-50
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(newUser.getAdditionalInformation());
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(newUser.getHomePhone());
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(newUser.getMobileNumber());
        driver.findElement(By.xpath("//input[@id='alias']")).clear();
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(newUser.getAddressAlias());
        driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
        WebElement buttonLogout = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='logout']")));//or 2
        buttonLogout.click();
        return new String[] {newUser.getUsedEmail(), newUser.getPassword()};
    }
    void openCart(){
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
    }
    public void mouseOver(WebElement element) {
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor)driver).executeScript(code, element);
    }


    public static void quitDriver() {
        driver.quit();
    }
}
