package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    WebDriver driver;

    By cartItems = By.cssSelector(".cart-item-row");
    By totalPrice = By.cssSelector(".order-total");
    By removeButtons = By.name("removefromcart");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public double getTotalPrice() {
        String priceText = driver.findElement(totalPrice).getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public void removeItemFromCart() {
        List<WebElement> removeBtns = driver.findElements(removeButtons);
        if (!removeBtns.isEmpty()) {
            removeBtns.get(0).click();  // Remove the first item
        }
    }
}
