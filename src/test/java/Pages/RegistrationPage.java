package Pages;

import Model.User;
import Tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Tests.BaseTest.LOGGER;
import static Tests.Error_Messages_and_Data.*;


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
    private WebElement textFieldAddressLastName;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement textFieldAddress1;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement textFieldAddress2;

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
    private WebElement textFieldAddressAlias;

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


    private final ArrayList<String> registrationErrors = new ArrayList<>();

    @FindBy(css = "div.alert li")
    private List<WebElement> ourRegistrationError;

    private void fillErrorArrayList() {
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
        textFieldPassword.sendKeys(user.getPersonalInfo().getPassword());
        selectByValue(selectorDay, user.getPersonalInfo().getDay());
        selectByValue(selectorMonth, user.getPersonalInfo().getMonth());
        selectByValue(selectorYear, user.getPersonalInfo().getYear());
        if (user.isSubscribeToNews()) radioNewsLetterRadio.click();
        if (user.isSubscribeForSpecialOffers()) radioOptin.click();
        textFieldAddress1.sendKeys(user.getAddress().getAddress1());
        textFieldAddress2.sendKeys(user.getAddress().getAddress2());
        textFieldCity.sendKeys(user.getAddress().getCity());
        textFieldPostCode.sendKeys(user.getAddress().getPostCode());
        selectByText(selectorCountry, user.getAddress().getCountry());
        selectByText(selectorState, user.getAddress().getState());
        textFieldAdditionalInformation.sendKeys(user.getAddress().getAdditionalInformation());
        textFieldHomePhone.sendKeys(user.getAddress().getHomePhone());
        textFieldMobileNumber.sendKeys(user.getAddress().getMobileNumber());
        textFieldAddressAlias.clear();
        textFieldAddressAlias.sendKeys(user.getAddress().getAddressAlias());
        buttonRegister.click();
    }

    public boolean verifyElementPage() throws IllegalAccessException {
        RegistrationPage obj = PageFactory.initElements(BasePage.driver, RegistrationPage.class);

        List<Field> allElements = new ArrayList<>(Arrays.asList(RegistrationPage.class.getDeclaredFields()));
        List<WebElement> webElementsInPage = new ArrayList<>();
        for (Field allElement : allElements)
            if (allElement.getType().toString().equals("interface org.openqa.selenium.WebElement")) {
                webElementsInPage.add(((WebElement) allElement.get(obj)));
            }

        radioGenderMale = (new WebDriverWait(driver, BaseTest.timeOut))
                .until(ExpectedConditions.visibilityOf(radioGenderMale));

        for (int i = 1; i < webElementsInPage.size(); i++) {
            webElementsInPage.get(i).click();
            if (!webElementsInPage.get(i).isDisplayed() && !webElementsInPage.get(i).isEnabled()) {
                LOGGER.debug(!webElementsInPage.get(i).isDisplayed());
                LOGGER.debug(!webElementsInPage.get(i).isEnabled());
                LOGGER.debug(webElementsInPage.get(i).toString());
                return false;
            }
        }
        return true;

       /* RegistrationPage obj  =  new RegistrationPage();
        Field field  =   RegistrationPage.class.getDeclaredField  ("buttonRegister");
        field.setAccessible   (true);
        PixelFormat.DataType value  =  (PixelFormat.DataType) field.get(obj);*/

    }
}
