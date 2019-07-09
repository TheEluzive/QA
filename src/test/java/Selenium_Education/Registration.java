package Selenium_Education;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Registration {
    private WebDriver driver;
    private String url = "http://automationpractice.com";

    @Test(priority = 1)
    public void openRegistration(){

        System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")  + "/src/test/Drivers/chromedriver.exe" ));
        driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//a[@class='login']")).click();

    }

    @Test(priority = 2)
    public void inputEmail(){
        System.out.println("Happened");
        //WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                //.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email_create']")));
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("fdsfs@email.com");
        driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();
        WebElement genderRadio = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_gender1']")));//or 2
        genderRadio.click();

    }

    @Test(priority = 3)
    public void inputPersonalInfomation(){
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("LastName");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Password");
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        selectDay.selectByValue("5");
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectMonth.selectByValue("4");
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByValue("2010");
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Street, 1");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("build 4");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Moscow");
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("43543");
        Select selectCountry = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
        selectCountry.selectByValue("21"); //only 21
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        selectState.selectByValue("5");//1-50
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("something");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("(7897)899879");
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("898977853456789");
        driver.findElement(By.xpath("//input[@id='alias']")).clear();
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("adress 543");
        driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
        driver.quit();


    }




}
