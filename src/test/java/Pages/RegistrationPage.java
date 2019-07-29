package Pages;

import Model.User;
import Tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

import static Tests.BaseTest.LOGGER;


public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement radioGenderMale;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement radioGenderFemale;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement textFieldFirstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement testFieldLastName;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement textFieldPassword;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement selectorDay;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement selectorMonth;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement selectorYear;

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
    private WebElement selectorCountry;

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement selectorState;

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

    private void selectByValue(WebElement selector, String value) {
        Select select = new Select(selector);
        selector.click();
        select.selectByValue(value);
    }

    private void selectByText(WebElement selector, String value) {
        Select select = new Select(selector);
        selector.click();
        select.selectByVisibleText(value);
    }

    public void inputEmailAndOpenRegistrationPage(String email) {

        getButtonSignIn().click();
        LOGGER.debug("Registration called");
        LOGGER.debug("using mail: " + email);
        AuthenticationPage authenticationPage = PageFactory.initElements(driver, AuthenticationPage.class);
        authenticationPage.textFieldEmailAddressForRegistration = (new WebDriverWait(driver, BaseTest.timeOut))
                .until(ExpectedConditions.visibilityOf(authenticationPage.textFieldEmailAddressForRegistration));//or 2
        authenticationPage.textFieldEmailAddressForRegistration.clear();
        authenticationPage.textFieldEmailAddressForRegistration.sendKeys(email);
        authenticationPage.buttonCreateAnAccount.click();
    }

    public static final String MESSAGE_PHONE_IS_REQUIRED = "You must register at least one phone number.";
    public static final String MESSAGE_LAST_NAME_IS_INVALID = "lastname is invalid.";
    public static final String MESSAGE_FIRST_NAME_IS_INVALID = "firstname is invalid.";
    public static final String MESSAGE_EMAIL_IS_INVALID = "email is invalid.";
    public static final String MESSAGE_PASSWORD_IS_REQUIRED = "passwd is required.";
    public static final String MESSAGE_PASSWORD_IS_INVALID = "passwd is invalid.";
    public static final String MESSAGE_ERROR_ADDRESS1 = "address1 is too long. Maximum length: 128";
    public static final String MESSAGE_COUNTRY_IS_INVALID = "Country is invalid";
    public static final String MESSAGE_CITY_IS_REQUIRED = "city is required.";
    public static final String MESSAGE_STATE_IS_REQUIRED = "This country requires you to choose a State."; //if country chosen
    public static final String MESSAGE_POST_CODE_IS_REQUIRED = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";//if country chosen

    private ArrayList<String> registrationErrors = new ArrayList<>();

    public void fillErrorArrayList(){
        registrationErrors.add(MESSAGE_PHONE_IS_REQUIRED);
        registrationErrors.add(MESSAGE_LAST_NAME_IS_INVALID);
        registrationErrors.add(MESSAGE_FIRST_NAME_IS_INVALID);
        registrationErrors.add(MESSAGE_EMAIL_IS_INVALID);
        registrationErrors.add(MESSAGE_PASSWORD_IS_REQUIRED);
        registrationErrors.add(MESSAGE_PASSWORD_IS_INVALID);
        registrationErrors.add(MESSAGE_ERROR_ADDRESS1);
        registrationErrors.add(MESSAGE_COUNTRY_IS_INVALID);
        registrationErrors.add(MESSAGE_CITY_IS_REQUIRED);
        registrationErrors.add(MESSAGE_STATE_IS_REQUIRED);
        registrationErrors.add(MESSAGE_POST_CODE_IS_REQUIRED);


    }

    @FindBy(css = "div.alert li")
    List<WebElement> ourRegistrationError;

    public boolean findError() {
        fillErrorArrayList();

        for (WebElement webElement : ourRegistrationError) {
            if (!registrationErrors.contains(webElement.getText())) {
                LOGGER.error("Error message: " + webElement.getText() + " wasn`t output");
                return false;
            }
        }
        LOGGER.info("All error messages was output");
        return true;
    }


    public void inputPersonalInformation(User user) {
        if (user.getPersonalInfo().isGender()) {
            radioGenderMale = (new WebDriverWait(driver, BaseTest.timeOut))
                    .until(ExpectedConditions.visibilityOf(radioGenderMale));//or 2
            radioGenderMale.click();
        } else {

            radioGenderFemale = (new WebDriverWait(driver, BaseTest.timeOut))
                    .until(ExpectedConditions.visibilityOf(radioGenderFemale));//or 2
            radioGenderFemale.click();
        }
        textFieldFirstName.sendKeys(user.getPersonalInfo().getFirstName());
        testFieldLastName.sendKeys(user.getPersonalInfo().getLastName());
        textFieldPassword.sendKeys(user.getPassword());
        selectByValue(selectorDay, user.getPersonalInfo().getDay());
        selectByValue(selectorMonth, user.getPersonalInfo().getMonth());
        selectByValue(selectorYear, user.getPersonalInfo().getYear());
        if (user.isNewsLetterRadio()) radioNewsLetterRadio.click();
        if (user.isOptinRadio()) radioOptin.click();
        textFieldAdress1.sendKeys(user.getAddress().getAddress1());
        textFieldAdress2.sendKeys(user.getAddress().getAddress2());
        textFieldCity.sendKeys(user.getAddress().getCity());
        textFieldPostCode.sendKeys(user.getAddress().getPostCode());
        selectByText(selectorCountry, user.getAddress().getCountry());
        selectByText(selectorState, user.getAddress().getState());
        textFieldAdditionalInformation.sendKeys(user.getAddress().getAdditionalInformation());
        textFieldHomePhone.sendKeys(user.getAddress().getHomePhone());
        textFieldMobileNumber.sendKeys(user.getAddress().getMobileNumber());
        textFieldAdressAlias.clear();
        textFieldAdressAlias.sendKeys(user.getAddress().getAddressAlias());
        buttonRegister.click();
    }
}