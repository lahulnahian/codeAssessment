package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class SearchPage extends WaitHelper {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final List<WebElement> productContainers = driver.findElements(By.cssSelector("#ProductBoxContainer"));
    private final By productItemAddToCartBtn = By.cssSelector("input[data-testid='itemAddCart']");

    private final By cartPopup = By.cssSelector("div[data-role='notification']");
    private final By cartPopupViewCartBtn = By.cssSelector("div.notification__action a.btn-primary");

    public int getResultsSize() {
        return productContainers.size();
    }

    public void addProductToCart() {
        WebElement finalElement = productContainers.get(getResultsSize() - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(finalElement).perform();

        finalElement.findElement(productItemAddToCartBtn).click();
    }

    public void viewCart() {
        waitForElement(cartPopup);
        driver.findElement(cartPopupViewCartBtn).click();
    }
}
