package Page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    WebElement buttonOrderHistoryAndDetails;

    @FindBy(xpath = "//span[contains(text(),'My credit slips')]")
    WebElement buttonMyCreditSlips;

    @FindBy(xpath = "//span[contains(text(),'My addresses')]")
    WebElement buttonMyAddresses;

    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    WebElement buttonMyPersonalInformation;

    @FindBy(xpath = "//span[contains(text(),'My wishlists')]")
    WebElement buttonMyWishlists;

}
