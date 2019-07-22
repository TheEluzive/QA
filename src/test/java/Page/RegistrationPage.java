package Page;

import Model.User;
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
        select.selectByValue(country);
    }

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement selectorState;

    private void selectState(String state) {
        Select select = new Select(selectorState);
        select.selectByValue(state);
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

        buttonSignIn.click();
        LOGGER.debug("Registration called");
        LOGGER.debug("using mail: " + email);
        textFieldEmailInAuthenticationPage = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(textFieldEmailInAuthenticationPage));//or 2
        textFieldEmailInAuthenticationPage.clear();
        textFieldEmailInAuthenticationPage.sendKeys(email);
        buttonCreateAnAccountInAuthenticationPage.click();
    }


    public void inputPersonalInformation(User user) {
        radioGender = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(radioGender));//or 2
        radioGender.click();
        textFieldFirstName.sendKeys(user.getFirstName());
        testFieldLastName.sendKeys(user.getLastName());
        textFieldPassword.sendKeys(user.getPassword());
        selectDay(user.getDay());
        selectMonth(user.getMonth());
        selectYear(user.getYear());
        if (user.isNewsLetterRadio()) radioNewsLetterRadio.click();
        if (user.isOptinRadio()) radioOptin.click();
        textFieldAdressFirstName.sendKeys(user.getAdressFirstName());
        textFieldAdressLastName.sendKeys(user.getAdressLastName());
        textFieldAdress1.sendKeys(user.getAdress1());
        textFieldAdress2.sendKeys(user.getAdress2());
        textFieldCity.sendKeys(user.getCity());
        textFieldPostCode.sendKeys(user.getPostCode());
        selectCountry(user.getCountry()); //only 21
        selectState(user.getState());//1-50
        textFieldAdditionalInformation.sendKeys(user.getAdditionalInformation());
        textFieldHomePhone.sendKeys(user.getHomePhone());
        textFieldMobileNumber.sendKeys(user.getMobileNumber());
        textFieldAdressAlias.clear();
        textFieldAdressAlias.sendKeys(user.getAddressAlias());
        buttonRegister.click();
    }
}
