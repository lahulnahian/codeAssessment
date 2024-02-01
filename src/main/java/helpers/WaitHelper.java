package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class WaitHelper {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofSeconds(5));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    private static final int DEFAULT_TIMEOUT = 20; // Example default timeout of 10 seconds

    public void waitForElement(By byElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (TimeoutException e) {
            // Log the exception or handle it as per your requirement
            throw new NoSuchElementException("Element not found within the timeout period: " + byElement);
        }
    }

    public void waitForElement(WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            // Log the exception or handle it as per your requirement
            throw new NoSuchElementException("WebElement not visible within the timeout period.");
        }
    }


}
