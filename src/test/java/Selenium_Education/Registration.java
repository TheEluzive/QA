package Selenium_Education;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email_create']")));
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("fdsfs@email.com");
    }



}
