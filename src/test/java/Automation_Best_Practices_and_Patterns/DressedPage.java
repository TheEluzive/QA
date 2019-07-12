package Automation_Best_Practices_and_Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DressedPage extends AbstractPage {
    DressedPage() {
        super();
        driver.get(dressesPage);
    }

    @Override
    void contactUs() {
        super.contactUs();
    }

    @Override
    void signIn(String email, String password) {
        super.signIn(email, password);
    }

    @Override
    void signOut() {
        super.signOut();
    }

    @Override
    public String[] registration(NewUser newUser) {
        return super.registration(newUser);
    }

    @Override
    void openCart() {
        super.openCart();
    }

    @Override
    public void mouseOver(WebElement element) {
        super.mouseOver(element);
    }

    void buyPrintedDress(){
        /*WebElement element = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-container']")
        );
        mouseOver(element);*/
        driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")).click();
        driver.findElement(By.xpath("//span[@class='cross']")).click();

    }
}
