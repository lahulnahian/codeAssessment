package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends WaitHelper {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement cartHeaderTitle = driver.findElement(By.xpath("//h1[contains(text(),'Cart')]"));
    private final By cartItems = By.cssSelector("div.cartItem[data-itemnumber]");
    private final By deleteCartItemBtn = By.cssSelector("div.itemDelete > button");
    private final By emptyCart = By.cssSelector("div.cartEmpty");

    public boolean checkItemsInCart() {
        waitForElement(cartHeaderTitle);
        try {
            return !driver.findElement(emptyCart).isDisplayed();
        } catch (NoSuchElementException ignore) {
            waitForElement(cartItems);
        }
        return true;
    }

    public void removeCartItem() {
        driver.findElement(deleteCartItemBtn).click();
        waitForElement(emptyCart);
    }
}
