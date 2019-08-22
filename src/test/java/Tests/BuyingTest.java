package Tests;

import Pages.BasePage;
import Pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingTest extends BaseTest {

    @Test
    public void buyingTest() throws InterruptedException {
//don`t move mouse in this test
        BasePage.driver.get(BasePage.mainPage + property.getProperty("shopPage"));
        ShopPage shopPage = PageFactory.initElements(BasePage.driver, ShopPage.class);
        BasePage.driver.manage().window().maximize();

        int addedProducts = 0;
        shopPage.makeListOfProducts();

        for (int i = 0; i < shopPage.getAmountProductsInShopPage(); i++) {
            shopPage.addToCart(i);
            addedProducts++;
        }
        LOGGER.debug("Amount added products: " + addedProducts);
        Assert.assertEquals(shopPage.getAmountProductsInCart(), addedProducts);
    }
}
