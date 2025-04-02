package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DesktopPage {
    WebDriver driver;

    By sortDropdown = By.id("products-orderby");
    By addToCartButtons = By.xpath("//input[@value='Add to cart']");
    By cartLink = By.xpath("//span[@class='cart-label']");

    public DesktopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortProducts(String sortOption) {
        WebElement dropdown = driver.findElement(sortDropdown);
        dropdown.sendKeys(sortOption);  // Example: "Price: High to Low"
    }

    public void addAllDesktopsToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (WebElement button : buttons) {
            button.click();
        }
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
