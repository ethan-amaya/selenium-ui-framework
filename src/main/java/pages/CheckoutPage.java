package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public FinishCheckoutPage detailCheckout(String firstName, String lastName, String postalCode) throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
        return new FinishCheckoutPage(driver);
    }
    
}
