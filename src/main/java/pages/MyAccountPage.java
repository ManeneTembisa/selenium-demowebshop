package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;

    // Locators
    By myAccountFooterLink = By.linkText("My account");  // My Account link in the footer
    By ordersTab = By.linkText("Orders");  // Orders tab in My Account page
    By orderDetails = By.className("order-number"); // Order confirmation details

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to My Account Page
    public void goToMyAccount() {
        driver.findElement(myAccountFooterLink).click();
    }

    // Navigate to Orders Page
    public void goToOrders() {
        driver.findElement(ordersTab).click();
    }

    // Validate Order Exists
    public boolean isOrderCreated() {
        return driver.findElement(orderDetails).isDisplayed();
    }
}
