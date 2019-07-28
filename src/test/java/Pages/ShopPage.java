package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ShopPage extends BasePage {
    public static final int AMOUNT_DRESSES = 10;
  //  ArrayList<WebElement> dresses2 = new ArrayList<>(10);
    //WebElement[] dresses;


    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement dress1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span" )
    WebElement dress1AddToCart;

   public void buyDress1(){
       mouseOver(dress1);
       dress1AddToCart.click();
   }







}
