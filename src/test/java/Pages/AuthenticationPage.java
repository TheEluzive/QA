package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AuthenticationPage extends BasePage {

    //CREATE AN ACCOUNT
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement textFieldEmailAddressForRegistration;

    @FindBy(xpath = "//form[@id='create-account_form']//span[1]")
    WebElement buttonCreateAnAccount;

    //ALREADY REGISTERED?
    @FindBy(xpath = "//input[@id='email']")
    WebElement textFieldEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement textFieldPassword;

    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    WebElement buttonForgotYourPassword;

    @FindBy(xpath = "//p[@class='submit']//span[1]")
    WebElement buttonSignIn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    WebElement errorBoxErrorCreateAccount;

    public String findErrorBoxAuthenticationFailed() {
       return errorBoxErrorCreateAccount.getText();
    }

}
