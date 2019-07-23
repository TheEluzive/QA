package Page;

import Model.User;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class PersonalInformationPage extends BasePage {


    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement radioGenderMen;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement radioGenderWomen;

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

    public void selectYear(String year) {
        Select select = new Select(selectorYear);
        select.selectByValue(year);
    }

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

    public void updateInformation(User user){
        textFieldFirstName.clear();
        textFieldFirstName.sendKeys(user.getFirstName());

        testFieldLastName.clear();
        testFieldLastName.sendKeys(user.getLastName());

        textFieldEmail.clear();
        textFieldEmail.sendKeys(user.getEmail());

        select(user.getDay(), selectorDay);
        select(user.getMonth(), selectorMonth);
        select(user.getYear(), selectorYear);

        getTextFieldCurrentPassword().sendKeys(user.getPassword());

        textFieldNewPassword.sendKeys(user.getPassword());
        textFieldConfirmPassword.sendKeys(user.getPassword());

        getButtonSave().click();
    }

}
