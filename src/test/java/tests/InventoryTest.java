package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest{
    
    @Test
    public void addItemsToCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemsToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Adding items to cart failed");
    }

}
