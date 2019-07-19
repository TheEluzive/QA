package Page;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class BasePage {
    public static WebDriver driver;


    public static String mainPage="";
    public static String dressesPage = mainPage + "index.php?id_category=8&controller=category";
    public static String personalArea = mainPage + "index.php?controller=my-account";
    private String pageUrl;

    @FindBy(xpath = "//a[@class='login']")
    static WebElement buttonSignIn;

    @FindBy(xpath = "//a[@class='logout']")
    public static WebElement buttonLogout;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    static WebElement buttonCart;

    @FindBy(xpath = "//div[@id='contact-link']//a[contains(text(),'Contact us')]")
    static WebElement buttonContactUs;

    @FindBy(xpath = "//a[@class='account']")
    public static WebElement buttonAccount;






    public void signIn(String email, String password) {
        buttonSignIn.click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
    }




    public void mouseOver(WebElement element) {
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(code, element);
    }


}
