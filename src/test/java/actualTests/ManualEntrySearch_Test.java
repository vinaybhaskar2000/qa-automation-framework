package actualTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import webPages.A1_HomePage;
import webPages.ManualEntry_SearchResultsPage;
import webPages.A5_ProductDetailsPage;


public class ManualEntrySearch_Test extends A1_BaseTest {

	//String prodSearch = "abcd";
	
	
	
	// TEST 1 --> VALID SEARCH
	
	@Test(priority=3,enabled = false)
	void verifyValidSearch()
	{
		String prodSearch = "Straight Line Kitchen Chimney Touch Sensor Baffle filters 60cm 1000 m3/h -Silver (6001 SS TS)";
		A1_HomePage home = new A1_HomePage(driver);
		ManualEntry_SearchResultsPage results =  home.getHeader().searchProduct_manualEntry(prodSearch);
		results.printSearchResult();
		Assert.assertTrue(results.getProductCount() > 0,  "Expected products but none found");
		           	
	}
	
	
	// TEST 2 --> INVALID SEARCH
	
	@Test(priority=1,enabled = false)
	void verifyInvalidSearch()
	{
		String prodSearch = "abcd";
		A1_HomePage home = new A1_HomePage(driver);
		ManualEntry_SearchResultsPage results =  home.getHeader().searchProduct_manualEntry(prodSearch);
		results.printSearchResult();
		String noProductsFoundMessage =results.getNoResultsMessage();
		Assert.assertTrue(noProductsFoundMessage.contains(prodSearch),  "Search keyword not present in no-results message");
		Assert.assertTrue(noProductsFoundMessage.contains("No results"),"Incorrect no-results message");           	
	}
	
	
	@Test(priority=4,enabled = true)
	void verifyValidProductSearch()
	{
		String prodSearch = "Chimney";
		A1_HomePage home = new A1_HomePage(driver);
		ManualEntry_SearchResultsPage results =  home.getHeader().searchProduct_manualEntry(prodSearch);
		//ProductDetailsPage productPage = new ProductDetailsPage(driver);
		A5_ProductDetailsPage  productDetailsPage = results.selectProduct1(prodSearch);
		String pageTitle =home.getCurrentPageTitle();
		//String pageURL =home.getCurrentPageURL();
		//System.out.println("Title of the Page is : "+pageTitle);
		//System.out.println("URL of the Page is : "+pageURL);
		//Assert.assertTrue(pageTitle.toLowerCase().contains("ductless straight line chimney"), "Incorrect product title displayed");
		//Assert.assertTrue(pageURL.contains("glen-60cm-1000-m3-h"), "Incorrect product URL loaded");

		
	}
	
	
	
	@Test(priority=2,enabled = false)
	void verifyInvalidProductSearch()
	{
		String prodSearch = "abcd";
		A1_HomePage home = new A1_HomePage(driver);
		ManualEntry_SearchResultsPage results =  home.getHeader().searchProduct_manualEntry(prodSearch);
		boolean b = results.isNoRsultDisplayed();
		Assert.assertTrue(b);
		
		// directly we can write like this.
		//Assert.assertTrue(results.isNoRsultDisplayed());
		
	}

}
