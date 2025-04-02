package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComputersPage;

public class ComputersTest extends BaseTest {
    @Test
    public void testAddAndRemoveDesktopItems() {
        ComputersPage computersPage = new ComputersPage(driver);

        computersPage.navigateToDesktops();
        computersPage.sortDesktopsByAllOptions();
        computersPage.addAllDesktopsToCart();

        double totalBefore = computersPage.getTotalCartPrice();

        computersPage.removeOneItemFromCart();

        double totalAfter = computersPage.getTotalCartPrice();
        Assert.assertTrue(totalAfter < totalBefore, "Total price should decrease after removing an item.");
    }
}
