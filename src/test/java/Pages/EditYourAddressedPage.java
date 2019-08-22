package Pages;

import Model.Address;
import Model.User;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class EditYourAddressedPage extends BasePage {


    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement textFieldAdressFirstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement textFieldAdressLastName;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement textFieldCompany;

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

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement buttonSave;

    private void select(String string, WebElement selector) {
        Select select = new Select(selector);
        selector.click();
        select.selectByVisibleText(string);
    }

    private void cleanFieldAndSendString(WebElement webElement, String textField) {
        webElement.clear();
        webElement.sendKeys(textField);
    }

    void updateYourAddress(User user) {
        cleanFieldAndSendString(textFieldAdressFirstName, user.getPersonalInfo().getFirstName());
        cleanFieldAndSendString(textFieldAdressLastName, user.getPersonalInfo().getLastName());
        cleanFieldAndSendString(textFieldCompany, user.getAddress().getCompany());
        cleanFieldAndSendString(textFieldAdress1, user.getAddress().getAddress1());
        cleanFieldAndSendString(textFieldAdress2, user.getAddress().getAddress2());
        cleanFieldAndSendString(textFieldCity, user.getAddress().getAddress2());
        cleanFieldAndSendString(textFieldCity, user.getAddress().getCity());
        cleanFieldAndSendString(textFieldPostCode, user.getAddress().getPostCode());
        select(user.getAddress().getState(), selectorState);
        select(user.getAddress().getCountry(), selectorCountry);
        cleanFieldAndSendString(textFieldHomePhone, user.getAddress().getHomePhone());
        cleanFieldAndSendString(textFieldMobileNumber, user.getAddress().getMobileNumber());
        cleanFieldAndSendString(textFieldAdditionalInformation, user.getAddress().getAdditionalInformation());
        buttonSave.click();
    }

    public String getUserFirstName() {
        return textFieldAdressFirstName.getAttribute("value");
    }

    public String getUserLastName() {
        return textFieldAdressLastName.getAttribute("value");
    }

    public Address getUserAddressFromPage() {
        String country = new Select(selectorCountry).getFirstSelectedOption().getText();
        String state = new Select(selectorState).getFirstSelectedOption().getText();

        return new Address(
                textFieldCompany.getAttribute("value"),
                textFieldAdress1.getAttribute("value"),
                textFieldAdress2.getAttribute("value"),
                textFieldCity.getAttribute("value"),
                textFieldPostCode.getAttribute("value"),
                country,
                state,
                textFieldAdditionalInformation.getAttribute("value"),
                textFieldHomePhone.getAttribute("value"),
                textFieldMobileNumber.getAttribute("value"),
                textFieldAdressAlias.getAttribute("value")
        );
    }
}
