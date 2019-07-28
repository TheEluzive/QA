package Pages;

import Model.User;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MyAdressesPage extends BasePage {
    @FindBy(xpath = "//div[@class='addresses']//li[2]")
    WebElement addressedFirstName;

    @FindBy(xpath = "//div[@class='columns-container']//li[4]")
    WebElement address1;

    @FindBy(xpath = "//div[@class='columns-container']//li[5]")
    WebElement address2;

    @FindBy(xpath = "//div[@class='columns-container']//li[6]")
    WebElement country;

    @FindBy(xpath = "//div[@class='columns-container']//li[7]")
    WebElement homePhone;

    @FindBy(xpath = "//span[@class='address_phone_mobile']")
    WebElement mobilePhone;

    @FindBy(xpath = "//span[contains(text(),'Update')]")
    WebElement buttonUpdate;


    public void updateAddress(User user) {
        buttonUpdate.click();
        EditYourAddressedPage editYourAdressedPage = PageFactory.initElements(BasePage.driver, EditYourAddressedPage.class);
        editYourAdressedPage.updateYourAddress(user);
    }

}
