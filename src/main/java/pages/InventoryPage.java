package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    private By backpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By bikelightAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartButton = By.id("shopping_cart_container");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public CartPage addItemsToCart(){
        driver.findElement(backpackAddToCartButton).click();
        driver.findElement(bikelightAddToCartButton).click();
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
