package Automation_Best_Practices_and_Patterns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SignIn_Out_And_Registration {
    private String mainPage = "http://automationpractice.com";
    public WebDriver driver;
    public SignIn_Out_And_Registration() {

        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/test/Drivers/chromedriver.exe"));
        driver = new ChromeDriver();
        driver.get(mainPage);
    }

    public String[] registration(WebDriver driver, NewUser newUser) {
        //registrated user and return String email and password
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement inputEmail = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email_create']")));//or 2
        inputEmail.clear();
        String usedEmail = System.currentTimeMillis() + newUser.getEmail();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(usedEmail);
        System.out.println("Used email: " + usedEmail);
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
        return new String[] {usedEmail, newUser.getPassword()};
    }
    public void signInAndOut(WebDriver driver, String email, String password){
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }


}
