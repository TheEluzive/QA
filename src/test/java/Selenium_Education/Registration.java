package Selenium_Education;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Scanner;

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

    @Test(priority = 2, dataProvider = "dataProviderEmail", dataProviderClass = DataProviderClass.class)
    public void inputEmail(String email){
        System.out.println("Happened");
        //WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                //.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email_create']")));
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
        driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();
        WebElement genderRadio = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_gender1']")));//or 2
        genderRadio.click();

    }

    @Test(priority = 3, dataProvider = "dataProviderForRegistration", dataProviderClass = DataProviderClass.class)
    public void inputPersonalInformation(String firstName, String lastName, String password, String day, String month,
                                         String year, boolean newsletter, boolean optin, String firstNameAgain, String lastNameAgain,
                                         String adress1, String adress2, String city, String postcode, String country,
                                         String state, String additional, String homePhone, String mobilePhone, String adressOptional){
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        selectDay.selectByValue(day);
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectMonth.selectByValue(month);
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByValue(year);
        if (newsletter)   driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        if (optin) driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstNameAgain);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastNameAgain);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(adress1);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(adress2);
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(postcode);
        Select selectCountry = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
        selectCountry.selectByValue(country); //only 21
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        selectState.selectByValue(state);//1-50
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(additional);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(homePhone);
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(mobilePhone);
        driver.findElement(By.xpath("//input[@id='alias']")).clear();
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(adressOptional);
        driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
        Scanner in = new Scanner(System.in);
        in.next();
        driver.quit();


    }




}
