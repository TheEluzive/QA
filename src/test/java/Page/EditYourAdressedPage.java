package Page;

import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class EditYourAdressedPage extends BasePage{



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

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement buttonSave;


}
