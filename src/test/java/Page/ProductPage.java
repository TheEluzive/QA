package Page;

import org.openqa.selenium.By;

class ProductPage extends BasePage {
    ProductPage() {
        super();
        driver.get(dressesPage);
    }



    void buyPrintedDress(){
        /*WebElement element = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-container']")
        );
        mouseOver(element);*/
        driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")).click();
        driver.findElement(By.xpath("//span[@class='cross']")).click();

    }
}
