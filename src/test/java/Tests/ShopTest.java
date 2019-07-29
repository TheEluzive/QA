package Tests;

import Pages.BasePage;
import Pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest{

    @Test
    public void shopTest() throws InterruptedException {

        BasePage.driver.get(BasePage.mainPage + "?id_category=3&controller=category");
        ShopPage shopPage = PageFactory.initElements(BasePage.driver, ShopPage.class);

        //JavascriptExecutor js = (JavascriptExecutor)BasePage.driver;
        //WebElement element = (WebElement) js.executeScript("return jQuery.find('#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img');");
        shopPage.buyDress1();
        Thread.sleep(10000);

    }
}