package Tests;

import Pages.BasePage;
import Pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest{

    @Test
    public void shopTest() {

        BasePage.driver.get(BasePage.mainPage + "?id_category=3&controller=category");
        ShopPage shopPage = PageFactory.initElements(BasePage.driver, ShopPage.class);
        BasePage.driver.manage().window().maximize();

        int addedProducts = 0;
        shopPage.makeListOfProducts();

        for (int i = 0; i<shopPage.getAmountProductsInShopPage(); i++){
            shopPage.addToCart(i);
            addedProducts++;
        }
        Assert.assertEquals(shopPage.getAmountProductsInCart(), addedProducts);
    }
}
