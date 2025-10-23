package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
            "--disable-save-password-bubble",
            "--disable-notifications",
            "--disable-infobars",
            "--disable-features=PasswordManagerOnboarding,PasswordLeakDetection",
            "--disable-blink-features=AutomationControlled"
        );

        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "enable-logging"));

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUpMethod() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
