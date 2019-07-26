package Page;

import Model.PersonalInfo;
import Model.User;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class PersonalInformationPage extends BasePage {


    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement radioGenderMale;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement radioGenderFemale;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement textFieldFirstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement testFieldLastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement textFieldEmail;

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

    @FindBy(xpath = "//input[@id='old_passwd']")
    private WebElement textFieldCurrentPassword;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement textFieldNewPassword;

    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement textFieldConfirmPassword;

    @FindBy(xpath = "//span[contains(text(),'Save')]//i[@class='icon-chevron-right right']")
    private WebElement buttonSave;

    private void select(String string, WebElement selector) {
        Select select = new Select(selector);
        select.selectByValue(string);
    }

    public PersonalInfo getPersonalInfoFromPage() {
        boolean gender;
        gender = getRadioGenderMale().isSelected();
        return new PersonalInfo(
                gender,
                getTextFieldEmail().getAttribute("value"),
                getTextFieldFirstName().getAttribute("value"),
                getTestFieldLastName().getAttribute("value"),

                getSelectorDay().getAttribute("value"),
                getSelectorMonth().getAttribute("value"),
                getSelectorYear().getAttribute("value")
        );
    }

    private void clearFieldAndSendString(WebElement webElement, String textField) {
        webElement.clear();
        webElement.sendKeys(textField);
    }

    public void updateInformation(User user, String oldPassword) {
        if (user.getPersonalInfo().isGender()) //men
            if (!radioGenderMale.isSelected())
                radioGenderMale.click();
        clearFieldAndSendString(textFieldFirstName, user.getPersonalInfo().getFirstName());
        clearFieldAndSendString(testFieldLastName, user.getPersonalInfo().getLastName());
        clearFieldAndSendString(textFieldEmail, user.getPersonalInfo().getEmail());
        select(user.getPersonalInfo().getDay(), selectorDay);
        select(user.getPersonalInfo().getMonth(), selectorMonth);
        select(user.getPersonalInfo().getYear(), selectorYear);
        getTextFieldCurrentPassword().sendKeys(oldPassword);
        textFieldNewPassword.sendKeys(user.getPassword());
        textFieldConfirmPassword.sendKeys(user.getPassword());
        getButtonSave().click();
    }

    public boolean messageOfSuccessChanges() {
        boolean message;
        try {
            message = BasePage.driver.findElement((By.xpath("//p[@class='alert alert-success']"))).isDisplayed();
        } catch (Exception e) {
            message = false;
        }
        return message;
    }

}
