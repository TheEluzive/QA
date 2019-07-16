package Page;

import Model.NewUser;
import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Test.BaseTest.LOGGER;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement textFieldEmailInAuthenticationPage;

    @FindBy(xpath = "//form[@id='create-account_form']//span[1]")
    private WebElement buttonCreateAnAccountInAuthenticationPage;

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement radioGender;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement textFieldFirstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement testFieldLastName;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement textFieldPassword;

    @FindBy(xpath = "//select[@id='days']")
    private Select selectorDay;

    @FindBy(xpath = "//select[@id='months']")
    private Select selectorMonth;

    @FindBy(xpath = "//select[@id='years']")
    private Select selectorYear;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement radioNewsLetterRadio;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement radioOptin;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement textFieldAdressFirstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement textFieldAdressLastName;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement textFieldAdress1;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement textFieldAdress2;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement textFieldCity;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement textFieldPostCode;

    @FindBy(xpath = "//select[@id='id_country']")
    private Select selectorCountry;

    @FindBy(xpath = "//select[@id='id_state']")
    private Select selectorState;

    @FindBy(xpath = "//textarea[@id='other']")
    private WebElement textFieldAdditionalInformation;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement textFieldHomePhone;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement textFieldMobileNumber;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement textFieldAdressAlias;

    @FindBy(xpath = "//span[contains(text(),'Register')]")
    private WebElement buttonRegister;


    public void inputEmailAndOpenRegistrationPage(String email) {

        buttonSignIn.click();
        LOGGER.debug("Registration called");
        LOGGER.debug("using mail: " + email);
        textFieldEmailInAuthenticationPage = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(textFieldEmailInAuthenticationPage));//or 2
        textFieldEmailInAuthenticationPage.clear();
        textFieldEmailInAuthenticationPage.sendKeys(email);
        buttonCreateAnAccountInAuthenticationPage.click();
    }


    public void inputPersonalInformation(NewUser newUser) {
        radioGender = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(radioGender));//or 2
        radioGender.click();
        textFieldFirstName.sendKeys(newUser.getFirstName());
        testFieldLastName.sendKeys(newUser.getLastName());
        textFieldPassword.sendKeys(newUser.getPassword());
        selectorDay.selectByValue(newUser.getDay());
        selectorMonth.selectByValue(newUser.getMonth());
        selectorYear.selectByValue(newUser.getYear());
        if (newUser.isNewsLetterRadio()) radioNewsLetterRadio.click();
        if (newUser.isOptinRadio()) radioOptin.click();
        textFieldAdressFirstName.sendKeys(newUser.getAdressFirstName());
        textFieldAdressLastName.sendKeys(newUser.getAdressLastName());
        textFieldAdress1.sendKeys(newUser.getAdress1());
        textFieldAdress2.sendKeys(newUser.getAdress2());
        textFieldCity.sendKeys(newUser.getCity());
        textFieldPostCode.sendKeys(newUser.getPostCode());
        selectorCountry.selectByValue(newUser.getCountry()); //only 21
        selectorState.selectByValue(newUser.getState());//1-50
        textFieldAdditionalInformation.sendKeys(newUser.getAdditionalInformation());
        textFieldHomePhone.sendKeys(newUser.getHomePhone());
        textFieldMobileNumber.sendKeys(newUser.getMobileNumber());
        textFieldAdressAlias.clear();
        textFieldAdressAlias.sendKeys(newUser.getAddressAlias());
        buttonRegister.click();
    }
}
