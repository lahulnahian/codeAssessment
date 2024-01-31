package com.webstaurantstore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverSetup {
    protected WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void quit() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            // Print the custom error message along with the exception details
            System.err.println("An error occurred while quitting the driver: " + e.getMessage());
        }
    }

}
