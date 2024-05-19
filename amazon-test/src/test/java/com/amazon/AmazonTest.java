package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        wait = new WebDriverWait(driver, 10); // Initialize the wait object here
    }

    @Test
    public void testAmazonCart() {
        // Search for "hats for men" and add to cart
        searchAndAddHatToCart("hats for men", 2);

        // Open cart and assert total price and quantity for the first item
        verifyCartItemQuantityAndPrice(2, 100);

        // Search for "hats for women" and add to cart
        searchAndAddHatToCart("hats for women", 1);

        // Open cart and assert total price and quantity for the second item
        verifyCartItemQuantityAndPrice(1, 100);

        // Change quantity for the item selected at step 3 from 2 to 1
        changeCartItemQuantity(2, 1);
    }

    private void searchAndAddHatToCart(String searchTerm, int quantity) {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.clear();
        searchBox.sendKeys(searchTerm);
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
        searchButton.click();

        for (int i = 2; ; i++) { // Start with the first result and increment
            try {
                WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-cel-widget='search_result_" + i + "']")));
                result.click();
                System.out.println("Clicked on search result " + i);

                // Ensure the page is fully loaded
                waitForPageLoad();

                try {
                    WebElement quantityDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("quantity")));
                    Select quantitySelect = new Select(quantityDropdown);
                    quantitySelect.selectByValue(String.valueOf(quantity));
                    System.out.println("Selected quantity " + quantity);

                    // Click outside the dropdown to close it
                    Actions actions = new Actions(driver);
                    actions.moveByOffset(0, 0).click().perform();

                    // Wait a moment to ensure the quantity selection is processed
                    Thread.sleep(1000);

                    // Scroll to the top of the page
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

                    WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
                    addToCartButton.click();
                    System.out.println("Added to cart");

                    // Verify the price is not more than $100
                    WebElement priceElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#corePrice_feature_div .a-price .a-offscreen")));
                    String priceText = priceElement.getText().replace("$", "").replace(",", "");
                    double price = Double.parseDouble(priceText);
                    Assert.assertTrue(price <= 100, "Price of the hat is more than $100: " + price);

                    return; // Exit the loop once the item is successfully added to the cart
                } catch (Exception e) {
                    // If quantity dropdown or Add to Cart button is not available, go back and try the next result
                    System.out.println("Quantity dropdown or Add to Cart button not available for search result " + i);
                    driver.navigate().back();
                }
            } catch (Exception e) {
                System.out.println("No more search results available");
                break; // If no more search results are available, break the loop
            }
        }
    }

    private void waitForPageLoad() {
        new WebDriverWait(driver, 10).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    private void verifyCartItemQuantityAndPrice(int expectedQuantity, double maxPrice) {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart")));
        cartButton.click();
        WebElement cartQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-action-quantity input")));
        WebElement cartPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sc-price")));

        Assert.assertEquals(cartQuantity.getAttribute("value"), String.valueOf(expectedQuantity));
        
        String priceText = cartPrice.getText().replace("$", "").replace(",", "");
        double price = Double.parseDouble(priceText);
        Assert.assertTrue(price <= maxPrice, "Price of the hat in cart is more than $100: " + price);
    }

    private void changeCartItemQuantity(int currentQuantity, int newQuantity) {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart")));
        cartButton.click();

        // Find the cart item with the specified current quantity
        WebElement cartItem = findCartItemByQuantity(currentQuantity);
        if (cartItem != null) {
            // Change the quantity of the found cart item
            Select quantityDropdown = new Select(cartItem.findElement(By.cssSelector("select[name='quantity']")));
            quantityDropdown.selectByValue(String.valueOf(newQuantity));
            System.out.println("Changed quantity from " + currentQuantity + " to " + newQuantity);

            // Optionally, click the update button if available
            WebElement updateButton = cartItem.findElement(By.cssSelector(".sc-update-link"));
            if (updateButton.isDisplayed()) {
                updateButton.click();
            }

            // Wait for the update to complete
            wait.until(ExpectedConditions.textToBePresentInElement(cartItem.findElement(By.cssSelector(".a-dropdown-prompt")), String.valueOf(newQuantity)));
            Assert.assertEquals(cartItem.findElement(By.cssSelector(".a-dropdown-prompt")).getText(), String.valueOf(newQuantity));
        } else {
            System.out.println("No cart item found with quantity " + currentQuantity);
        }
    }

    private WebElement findCartItemByQuantity(int quantity) {
        // Find all cart items
        for (WebElement cartItem : driver.findElements(By.cssSelector(".sc-list-item"))) {
            Select quantityDropdown = new Select(cartItem.findElement(By.cssSelector("select[name='quantity']")));
            if (quantityDropdown.getFirstSelectedOption().getText().equals(String.valueOf(quantity))) {
                return cartItem;
            }
        }
        return null;
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
