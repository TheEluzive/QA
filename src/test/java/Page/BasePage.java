package Page;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public abstract class BasePage {
    public static WebDriver driver;
    public static String mainPage="";
    public static String dressesPage="";
    public static String personalArea ="";


    @FindBy(xpath = "//a[@class='login']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement buttonCart;

    @FindBy(xpath = "//div[@id='contact-link']//a[contains(text(),'Contact us')]")
    private WebElement buttonContactUs;


    @FindBy(xpath = "//a[@class='account']")
    private  WebElement buttonAccount;

    public void signIn(String email, String password) {
        buttonSignIn.click();
        AuthenticationPage authenticationPage = PageFactory.initElements(driver, AuthenticationPage.class);
        authenticationPage.textFieldEmail.sendKeys(email);
        authenticationPage.textFieldPassword.sendKeys(password);
        authenticationPage.buttonSignIn.click();
    }


    public void mouseOver(WebElement element) {
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(code, element);
    }


}
