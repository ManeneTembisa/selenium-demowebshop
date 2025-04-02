package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    WebDriver driver;

    // Locators for Billing Details
    By billingContinueButton = By.xpath("//input[@onclick='Billing.save()']");

    // Locators for Shipping Details
    By shippingMethodRadio = By.id("shippingoption_1");  // Select Ground Shipping
    By shippingContinueButton = By.xpath("//input[@onclick='ShippingMethod.save()']");

    // Locators for Payment Details
    By paymentMethodRadio = By.id("paymentmethod_0");  // Cash on delivery
    By paymentContinueButton = By.xpath("//input[@onclick='PaymentMethod.save()']");

    // Confirm Payment Information
    By confirmPaymentContinueButton = By.xpath("//input[@onclick='PaymentInfo.save()']");

    // Confirm Order
    By confirmOrderButton = By.xpath("//input[@onclick='ConfirmOrder.save()']");

    // Order Confirmation
    By orderSuccessMessage = By.xpath("//strong[contains(text(), 'Your order has been successfully processed!')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBillingContinue() {
        driver.findElement(billingContinueButton).click();
    }

    public void selectShippingMethod() {
        driver.findElement(shippingMethodRadio).click();
        driver.findElement(shippingContinueButton).click();
    }

    public void selectPaymentMethod() {
        driver.findElement(paymentMethodRadio).click();
        driver.findElement(paymentContinueButton).click();
    }

    public void confirmPaymentInfo() {
        driver.findElement(confirmPaymentContinueButton).click();
    }

    public void confirmOrder() {
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isOrderSuccessMessageDisplayed() {
        return driver.findElement(orderSuccessMessage).isDisplayed();
    }
}
