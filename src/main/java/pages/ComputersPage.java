package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ComputersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Sidebar category links
    private By computersTab = By.linkText("Computers");
    private By desktopsOption = By.linkText("Desktops");

    // Sorting dropdown
    private By sortDropdown = By.id("products-orderby");

    // Add to cart buttons for desktops
    private By addToCartButtons = By.xpath("//input[@value='Add to cart']");

    // Cart elements
    private By shoppingCartLink = By.linkText("Shopping cart");
    private By totalPrice = By.xpath("//span[@class='product-subtotal']");
    private By removeItemButton = By.name("removefromcart");

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToDesktops() {
        wait.until(ExpectedConditions.elementToBeClickable(computersTab)).click();
        wait.until(ExpectedConditions.elementToBeClickable(desktopsOption)).click();
    }

    public void sortDesktopsByAllOptions() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            select.selectByVisibleText(option.getText());
        }
    }

    public void addAllDesktopsToCart() {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        for (WebElement button : buttons) {
            button.click();
        }
    }

    public double getTotalCartPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText());
    }

    public void removeOneItemFromCart() {
        List<WebElement> removeButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeItemButton));
        if (!removeButtons.isEmpty()) {
            removeButtons.get(0).click();
        }
    }
}
