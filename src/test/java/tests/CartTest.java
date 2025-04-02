package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.DesktopPage;

public class CartTest extends BaseTest {

    @Test
    public void testAddAndRemoveItems() {
        DesktopPage desktopPage = new DesktopPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 1: Navigate & Sort Products
        desktopPage.sortProducts("Price: High to Low");

        // Step 2: Add Items to Cart
        desktopPage.addAllDesktopsToCart();

        // Step 3: Navigate to Cart
        desktopPage.goToCart();

        // Step 4: Validate Total Price
        double initialTotal = cartPage.getTotalPrice();
        System.out.println("Total Price Before Removal: $" + initialTotal);

        // Step 5: Remove Item from Cart
        cartPage.removeItemFromCart();

        // Step 6: Validate Updated Total Price
        double newTotal = cartPage.getTotalPrice();
        System.out.println("Total Price After Removal: $" + newTotal);

        Assert.assertTrue(newTotal < initialTotal, "Total price should decrease after removal.");
    }
}
