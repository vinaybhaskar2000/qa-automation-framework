package actualTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import webPages.A1_HomePage;

public class A3_TrendingSearchTest extends A1_BaseTest {

	//  METHOD : 1
	
	@Test(enabled = true, priority = 1)
	public void verifyTrendingItemsAreDisplayed() {
		// Step 1: Home Page
		A1_HomePage home = new A1_HomePage(driver);

		// Step 2: Click on Search Box.

		home.getHeader().clickOnSearchBox();

	}

	//  METHOD : 2
	
	@Test(enabled = true, priority = 2)
	public void verifyTrendingItemsList() {
		// Step 1: Home Page
		A1_HomePage home = new A1_HomePage(driver);

		// Step 2: Click on Search Box.

		int count = home.getHeader().clickOnSearchBox().getVisibleItemsCount();
		Assert.assertTrue(count > 0, "Trending items are not displayed");

	}
	
	
	//  METHOD : 3
	
	@Test(enabled = true, priority = 3)
	public void verifyUserCanSelectTrendingItem() {
		// Step 1: Home Page
		A1_HomePage home = new A1_HomePage(driver);

		// Step 2: Click on Search Box.
		home.getHeader().clickOnSearchBox().selectItem("Chimneys");

	}
	
	
	
	
}
