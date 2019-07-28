package Tests;

import Pages.BasePage;
import Pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest{

    @Test
    public void shopTest() throws InterruptedException {

        BasePage.driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        ShopPage shopPage = PageFactory.initElements(BasePage.driver, ShopPage.class);



        JavascriptExecutor js = (JavascriptExecutor)BasePage.driver;
        //WebElement element = (WebElement) js.executeScript("return jQuery.find('#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img');");
       WebElement dress1 = BasePage.driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
        shopPage.mouseOver(dress1);

        WebElement addToCart = BasePage.driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        addToCart.click();

        Thread.sleep(10000);

    }
}
