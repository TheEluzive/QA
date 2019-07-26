package Page;

import Model.User;
import Test.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Test.BaseTest.LOGGER;


public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement radioGender;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement textFieldFirstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement testFieldLastName;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement textFieldPassword;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement selectorDay;

    private void selectDay(String day) {
        Select select = new Select(selectorDay);
        select.selectByValue(day);
    }

    @FindBy(xpath = "//select[@id='months']")
    private WebElement selectorMonth;

    private void selectMonth(String month) {
        Select select = new Select(selectorMonth);
        select.selectByValue(month);
    }

    @FindBy(xpath = "//select[@id='years']")
    private WebElement selectorYear;

    private void selectYear(String year) {
        Select select = new Select(selectorYear);
        select.selectByValue(year);
    }

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

    private void selectCountry(String country) {
        Select select = new Select(selectorCountry);
        selectorCountry.click();
        select.selectByVisibleText(country);
    }

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement selectorState;

    private void selectState(String state) {
        Select select = new Select(selectorState);
        selectorState.click();
        select.selectByVisibleText(state);
    }

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


    public void inputPersonalInformation(User user) {
        radioGender = (new WebDriverWait(driver, BaseTest.timeOut))
                .until(ExpectedConditions.visibilityOf(radioGender));//or 2
        radioGender.click();
        textFieldFirstName.sendKeys(user.getPersonalInfo().getFirstName());
        testFieldLastName.sendKeys(user.getPersonalInfo().getLastName());
        textFieldPassword.sendKeys(user.getPassword());
        selectDay(user.getPersonalInfo().getDay());
        selectMonth(user.getPersonalInfo().getMonth());
        selectYear(user.getPersonalInfo().getYear());
        if (user.isNewsLetterRadio()) radioNewsLetterRadio.click();
        if (user.isOptinRadio()) radioOptin.click();
        textFieldAdress1.sendKeys(user.getAddress().getAddress1());
        textFieldAdress2.sendKeys(user.getAddress().getAddress2());
        textFieldCity.sendKeys(user.getAddress().getCity());
        textFieldPostCode.sendKeys(user.getAddress().getPostCode());
        selectCountry(user.getAddress().getCountry());
        selectState(user.getAddress().getState());
        textFieldAdditionalInformation.sendKeys(user.getAddress().getAdditionalInformation());
        textFieldHomePhone.sendKeys(user.getAddress().getHomePhone());
        textFieldMobileNumber.sendKeys(user.getAddress().getMobileNumber());
        textFieldAdressAlias.clear();
        textFieldAdressAlias.sendKeys(user.getAddress().getAddressAlias());
        buttonRegister.click();
    }
}
