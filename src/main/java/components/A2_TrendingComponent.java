package components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import webPages.A4_SearchResultsPage_TrendyItems;

 /** This is class is related to the:
  * When we click on Search Box, Few Trendy Items display.
  * So to handle those elements we are creating a seperate class.
  * 
  * This class is having following methods:
  * 
  * 1.  public int getVisibleItemsCount()
  * 2. 	public SearchResultsPage_TrendyItems selectItem(String searchProductName)
  * 
  */

public class A2_TrendingComponent {

	WebDriver driver;
	WebDriverWait wait;
	
	 By trendyItems = By.xpath("//div[@id='st-trending-searches']//ul[@class='st-trending-search-list']//li");

	
	// Constructor
	
	public A2_TrendingComponent(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	/**
	 * This Method is used to Count the No.of Trendy Search Items, when we click on Search Box.
	 * @return
	 */
	
	public int getVisibleItemsCount() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(trendyItems));

        List<WebElement> items = driver.findElements(trendyItems);

        int count = 0;

        for (WebElement item : items) {
            if (item.isDisplayed()) {
                System.out.println(item.getText());
                count++;
            }
        }

        System.out.println("Total Visible Items: " + count);
        return count;
    }
	
	/**
	 * This Method is used to, when we enter Trendy Search Items, it will Click/Select that Item.
	 * @param searchProductName
	 * @return
	 */
	
	public A4_SearchResultsPage_TrendyItems selectItem(String searchProductName) {

	    List<WebElement> items = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(trendyItems));

	    for (WebElement item : items) {

	        String text = item.getText().trim();

	        if (text.equalsIgnoreCase(searchProductName)) {

	            wait.until(ExpectedConditions.elementToBeClickable(item)).click();
	            return new A4_SearchResultsPage_TrendyItems(driver);
	        }
	    }

	    throw new RuntimeException("Item not found in trending list: " + searchProductName);
	}
	
	
	
	
/*
	
	public SearchResultsPage_TrendyItems selectItem(String productName) {

	    List<WebElement> items = driver.findElements(trendyItems);

	    for (WebElement item : items) {

	        if (item.isDisplayed() &&
	            item.getText().equalsIgnoreCase(productName)) {

	            wait.until(ExpectedConditions.elementToBeClickable(item)).click();
	            break;
	        }
	    }

	    
	    return new SearchResultsPage_TrendyItems(driver);
	}
	
	*/
	
	
	
	
	
}
	
	

