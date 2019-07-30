package Pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

@Getter
public class ShopPage extends BasePage {

    /* @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
     WebElement buttonClose;*/
    private int amountProducts;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    WebElement buttonClose2;

    @FindBy(xpath = "//span[@class='heading-counter']")
    WebElement textAboutAmountProducts;

    ArrayList<WebElement> products = new ArrayList<>();
    ArrayList<WebElement> buttonsAddToCart = new ArrayList<>();

    public String getAmountProductsFromPage() {
         return textAboutAmountProducts.getText().toString().replaceAll("\\D+","");
    }

    public void makeListOfProducts() {

        for (int i = 1; i <= Integer.parseInt(getAmountProductsFromPage()); i++) {
            products.add(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div")));
            buttonsAddToCart.add(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[2]/a[1]/span")));

        }
    }

    public void addToCart(int productNumber) throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , products.get(productNumber));

        mouseOver(products.get(productNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , buttonsAddToCart.get(productNumber));
        buttonsAddToCart.get(productNumber).click();
        Thread.sleep(2000);
        buttonClose2.click();



    }


}
