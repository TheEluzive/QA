package Page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyAdressesPage extends BasePage {
    @FindBy(xpath = "//div[@class='addresses']//li[2]")
    WebElement adressedFirstName;

    @FindBy(xpath = "//div[@class='columns-container']//li[4]")
    WebElement adress1;

    @FindBy(xpath = "//div[@class='columns-container']//li[5]")
    WebElement adress2;

    @FindBy(xpath = "//div[@class='columns-container']//li[6]")
    WebElement country;

    @FindBy(xpath = "//div[@class='columns-container']//li[7]")
    WebElement homePhone;

    @FindBy(xpath = "//span[@class='address_phone_mobile']")
    WebElement mobilePhone;

    @FindBy(xpath = "//span[contains(text(),'Update')]")
    WebElement buttonUpdate;



}
