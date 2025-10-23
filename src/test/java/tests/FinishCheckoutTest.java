package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.CheckoutPage;

public class FinishCheckoutTest extends BaseTest{
    
    @Test
    public void finishCheckout() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemsToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.detailCheckout("Bob", "Bobby", "98039");
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"), "Checking out failed");
    }
}
