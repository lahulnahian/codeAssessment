package com.webstaurantstore;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;

public class VerifyItemSearch extends DriverSetup {

    @Test
    public void testSearchAndAddItemToCart() {
        // Navigate to the url
        getDriver().get("https://www.webstaurantstore.com/");
        HomePage mainPage = new HomePage(getDriver());

        // Verify if the main page is loaded by checking the page logo
        Assert.assertTrue(mainPage.checkPageLogo(), "Main page logo is not displayed.");

        // Perform search operation
        mainPage.clickSearchBar();
        mainPage.enterSearchItem("stainless work table");

        // Verify if search results are relevant
        Assert.assertTrue(mainPage.verifySearchList("table"), "Search results are not relevant.");

        // Navigate to search results page
        mainPage.clickSearchButton();
        SearchPage searchPage = new SearchPage(getDriver());

        // Add the final product to the cart and navigate to the cart page
        searchPage.addProductToCart();
        searchPage.viewCart();

        // Verify items in the cart and then remove them
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.checkItemsInCart(), "Cart does not contain expected items.");
        cartPage.removeCartItem();
        Assert.assertFalse(cartPage.checkItemsInCart(), "Items were not removed from the cart.");
    }
}
