package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishCheckoutPage {
    
    private WebDriver driver;

    private By finishButton = By.id("finish");

    public FinishCheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void finishCheckout() throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(finishButton).click();
    }
}
