package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends WaitHelper {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final WebElement webstaurantTitle = driver.findElement(By.cssSelector("div[data-testid='banner'] a[aria-label='Homepage, WebstaurantStore']:not(.lt\\:hidden)"));
    private final List<WebElement> searchBar = driver.findElements(By.cssSelector("#banner-search-group #searchForm"));
    private final By searchButton = By.cssSelector("button[type='submit']");
    private final List<WebElement> listBoxResultsKeywords = driver.findElements(By.cssSelector("li[data-recommendation-type='keywords'] .result"));
    private final List<WebElement> listBoxResultsCategories = driver.findElements(By.cssSelector("li[data-recommendation-type='categories'] .result"));

    public boolean checkPageLogo() {
        return webstaurantTitle.isDisplayed();
    }

    public WebElement getSearchBar() {
        return searchBar.get(0);
    }

    public void clickSearchBar() {
        getSearchBar().click();
    }

    public void clickSearchButton() {
        getSearchBar().findElement(searchButton).click();
    }

    public void enterSearchItem(String search) {
        WebElement searchInput = getSearchBar().findElement(By.cssSelector("input[type='text']"));
        searchInput.sendKeys(search);
    }

    public boolean verifySearchList(String assertion) {
        for (WebElement keywords : listBoxResultsKeywords) {
            if (!keywords.findElement(By.cssSelector("mark")).getText().contains(assertion))
                return false;
        }
        for (WebElement categories : listBoxResultsCategories) {
            if (!categories.getText().contains(assertion))
                return false;
        }
        return true;
    }
}
