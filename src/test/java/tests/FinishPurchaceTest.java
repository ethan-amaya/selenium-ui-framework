package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.FinishCheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class FinishPurchaceTest extends BaseTest{
    
    @Test
    public void finishPurchace() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemsToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.detailCheckout("Bob", "Bobby", "98039");
        FinishCheckoutPage finishCheckoutPage = new FinishCheckoutPage(driver);
        finishCheckoutPage.finishCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"), "Checking out failed");
    }
}
