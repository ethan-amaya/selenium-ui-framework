package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test
    public void invalidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "invalid_password");
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface: Username and password do not match any user in this service"), "Expected error not displayed");
    }
    
    @Test
    public void validLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed");
    }
}
