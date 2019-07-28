package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class ShopPage extends BasePage {
    public static final int AMOUNT_DRESSES = 10;
  //  ArrayList<WebElement> dresses2 = new ArrayList<>(10);
    //WebElement[] dresses;


    @FindBy(css = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement dress1;









}
