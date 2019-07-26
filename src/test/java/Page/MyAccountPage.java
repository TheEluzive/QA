package Page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    private WebElement buttonOrderHistoryAndDetails;

    @FindBy(xpath = "//span[contains(text(),'My credit slips')]")
    private WebElement buttonMyCreditSlips;

    @FindBy(xpath = "//span[contains(text(),'My addresses')]")
    private WebElement buttonMyAddresses;

    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    private WebElement buttonMyPersonalInformation;

    @FindBy(xpath = "//span[contains(text(),'My wishlists')]")
    private WebElement buttonMyWishlists;

}
