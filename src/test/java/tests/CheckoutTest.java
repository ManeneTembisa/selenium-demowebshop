package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Step 1: Select Billing Address & Continue
        checkoutPage.clickBillingContinue();

        // Step 2: Select Shipping Method & Continue
        checkoutPage.selectShippingMethod();

        // Step 3: Select Payment Method & Continue
        checkoutPage.selectPaymentMethod();

        // Step 4: Confirm Payment Information
        checkoutPage.confirmPaymentInfo();

        // Step 5: Confirm Order
        checkoutPage.confirmOrder();

        // Step 6: Validate Order Completion
        Assert.assertTrue(checkoutPage.isOrderSuccessMessageDisplayed(), "Order was not successfully completed!");
    }
}
