package Page;

import Model.User;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class EditYourAddressedPage extends BasePage{



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

   /* public void updateYourAddress(User user) {
        textFieldAdressFirstName.clear();
        textFieldAdressFirstName.sendKeys(user.getFirstName());

        textFieldAdressLastName.clear();
        textFieldAdressLastName.sendKeys(user.getLastName());

        textFieldCompany.clear();
        textFieldCompany.sendKeys(user.getCompany());


        textFieldAdress1.clear();
        textFieldAdress1.sendKeys(user.getAddress1());

        textFieldAdress2.clear();
        textFieldAdress2.sendKeys(user.getAddress2());

        textFieldCity.clear();
        textFieldCity.sendKeys(user.getCity());

        select(user.getState(), selectorState);

        textFieldPostCode.clear();
        textFieldPostCode.sendKeys(user.getPostCode());

        select(user.getCountry(), selectorCountry);

        textFieldHomePhone.clear();
        textFieldHomePhone.sendKeys(user.getHomePhone());

        textFieldMobileNumber.clear();
        textFieldMobileNumber.sendKeys(user.getMobileNumber());

        textFieldAdditionalInformation.clear();
        textFieldAdditionalInformation.sendKeys(user.getAdditionalInformation());

        buttonSave.click();
    }*/

}
