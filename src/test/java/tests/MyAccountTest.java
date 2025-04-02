package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;

public class MyAccountTest extends BaseTest {

    @Test
    public void testOrderExistsInMyAccount() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Step 1: Navigate to My Account from Footer
        myAccountPage.goToMyAccount();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/customer/info",
                "Failed to navigate to My Account page");

        // Step 2: Click on Orders Tab
        myAccountPage.goToOrders();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/customer/orders",
                "Failed to navigate to Orders page");

        // Step 3: Validate Order Exists
        Assert.assertTrue(myAccountPage.isOrderCreated(), "No order was found!");
    }
}
