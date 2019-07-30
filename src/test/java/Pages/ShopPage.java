package Pages;

import Tests.BaseTest;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

@Getter
public class ShopPage extends BasePage {

     @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
     WebElement textAmountProductInCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    WebElement buttonCloseMessageAdding;

    @FindBy(xpath = "//span[@class='heading-counter']")
    WebElement textAboutAmountProducts;

    ArrayList<WebElement> products = new ArrayList<>();
    ArrayList<WebElement> buttonsAddToCart = new ArrayList<>();

    public int getAmountProductsInShopPage() {
         return Integer.parseInt(textAboutAmountProducts.getText().replaceAll("\\D+",""));
    }

    public int getAmountProductsInCart(){
        return Integer.parseInt(textAmountProductInCart.getText());
    }

    public void makeListOfProducts() {

        for (int i = 1; i <= getAmountProductsInShopPage(); i++) {
            products.add(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div")));
            buttonsAddToCart.add(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[2]/a[1]/span")));

        }
    }

    public void addToCart(int productNumber){

        scrollToElement(products.get(productNumber));
        mouseOver(products.get(productNumber));

        scrollToElement(buttonsAddToCart.get(productNumber));
        buttonsAddToCart.get(productNumber).click();

        buttonCloseMessageAdding = (new WebDriverWait(driver, BaseTest.timeOut))
                .until(ExpectedConditions.visibilityOf(buttonCloseMessageAdding));
        buttonCloseMessageAdding.click();
    }


}
