package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest{
    
    @Test
    public void checkout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemsToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"), "Checking out failed");
    }
}
