package Pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

import static Tests.BaseTest.LOGGER;
import static Tests.BaseTest.makeScreen;

@Data
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


    public static final String MESSAGE_AUTHENTICATION_FAILED ="Authentication failed.";
    public static final String MESSAGE_INVALID_EMAIL_ADDRESS ="Invalid email address.";

    @FindBy(xpath = "//li[contains(text(),'"+ MESSAGE_AUTHENTICATION_FAILED +"')]")
    WebElement errorBoxAuthenticationFailed;

    @FindBy(xpath = "//li[contains(text(),'"+ MESSAGE_INVALID_EMAIL_ADDRESS +"')]")
    WebElement errorBoxInvalidEmail;

    public boolean findErrorBoxAuthenticationFailed() throws IOException {
        try{
            getErrorBoxAuthenticationFailed().isDisplayed();
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_AUTHENTICATION_FAILED +" was output");
            return true;
        }
        catch (Exception e)
        {
            makeScreen("authenticationFailedTest");
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_AUTHENTICATION_FAILED +" wasn`t output");
            return false;
        }
    }

    public boolean findErrorBoxInvalidEmail() throws IOException{
        try{
            getErrorBoxInvalidEmail().isDisplayed();
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_INVALID_EMAIL_ADDRESS +" was output");
            return true;
        }
        catch (Exception e)
        {
            makeScreen("invalidEmailToLoginTest");
            LOGGER.info("Error message: " + AuthenticationPage.MESSAGE_INVALID_EMAIL_ADDRESS +" wasn`t output");
            Assert.fail();
            return false;
        }
    }


}
