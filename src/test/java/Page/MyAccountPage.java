package Page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'My addresses')]")
    WebElement buttonMyAdresses;
}
