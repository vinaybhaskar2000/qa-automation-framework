package actualTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import webPages.A1_HomePage;
import webPages.A4_SearchResultsPage_TrendyItems;
import webPages.A5_ProductDetailsPage;

public class A4_SearchResultsPageTest extends A1_BaseTest
{
	
	String productKeyword = "Chimneys";
	
//  METHOD : 1

	
	@Test(enabled = false, priority = 1)
	public void validateSearchResults() {
		
		// Step 1: Home Page
		A1_HomePage home = new A1_HomePage(driver);
		// Step 2: Click on Search Box.
		A4_SearchResultsPage_TrendyItems results =     home.getHeader().clickOnSearchBox().selectItem(productKeyword);
		
		// Step 3:    // Grid validation
		boolean  d = results.isProductGridDisplayed();
		Assert.assertTrue(d, "Product grid is not displayed");
		
		//Assert.assertTrue(results.isProductGridDisplayed(),"Product grid is not displayed");
 
		
	    // Step 4:   Product count validation
		int  noOfProducts = results.getProductCount();
		System.out.println("The No. Of Products displaying are : "+noOfProducts);
		Assert.assertTrue(noOfProducts>0, "No products displayed in search results");
		

	}
	
	@Test(enabled = true, priority = 1)
	public void validatePaginationAndClickProduct()
	{
		// Step 1: Home Page
		A1_HomePage home = new A1_HomePage(driver);
		
		// Step 2: Get Home Page Title
		String homePageTitle =home.getHomePageTitle();
		System.out.println("Home Page Title : "+homePageTitle);
		
		// Step 3: Click on Search Box.
		A4_SearchResultsPage_TrendyItems searchResultsPage =     home.getHeader().clickOnSearchBox().selectItem(productKeyword);
		
			
		// Step 4:   //  Grid validation
		boolean  d = searchResultsPage.isProductGridDisplayed();
		Assert.assertTrue(d, "Product grid is not displayed");
			
		// Step 5: Get Search Results Page Title
		String searchResultsPageTitle = searchResultsPage.getSearchResultsPageTitle();
		System.out.println("Search Result Page Title : "+searchResultsPageTitle);
		
		
		 // Step 6:   Product count validation
		int  noOfProducts = searchResultsPage.getProductCount();
		System.out.println("The No. Of Products displaying in Search Result Page are : "+noOfProducts);
		Assert.assertTrue(noOfProducts>0, "No products displayed in search results");
		
		
		 //  Click product → returns Product Page	
		A5_ProductDetailsPage productDetailsPage = searchResultsPage.clickProductByGlobalIndex_Actual(100);
		
		
		 //  Get expected (from Search Page) // We are getting from getter method.
		String expectedProduct =	searchResultsPage.getSelectedProductName();
		System.out.println("\nThe Selected Product title in Search Page: --> "+expectedProduct);
		
		
		  //  Get actual (from Product Page)
		String actualProduct = productDetailsPage.getProductTitle();
		System.out.println("The Selected Product title displaying in Product Details Page: --> "+actualProduct);
		
		  //  Get URL of the selectedProduct.	
		String urlOfTheSelectedProduct =productDetailsPage.getCurrentPageURL();
		System.out.println("URL of the Selected Product in Product Details Page: --> "+urlOfTheSelectedProduct);
		
		
		String  productDescriptionPageTitle =productDetailsPage.getPageTitleFromPDP();
		System.out.println("Product Descirption Page Title : "+productDescriptionPageTitle);
		
		//  Changing the URL to Lower case
		String changedTheURLToLowercase = urlOfTheSelectedProduct.toLowerCase();
		
		// Chaning the Keyword to Lowser case
		String lowercaseProductKeyword = productKeyword.toLowerCase();	
		
		// Now check, the URL is contains the Product Keyword or not.
		boolean isKeywordPresentInURL  = changedTheURLToLowercase.contains(lowercaseProductKeyword);
		

		 //  Validate
		Assert.assertEquals(actualProduct.trim(), expectedProduct.trim(),"Product title mismatch!");
		
		
		// FINAL URL CHECK
		Assert.assertTrue(isKeywordPresentInURL ,"URL does not contain expected keyword");
		        
		
		// ------------------ Code from Chat GPT-----------------------------
		/*
		
		// Normalize values
		String urlLower = urlOfTheSelectedProduct.toLowerCase();
		String keywordLower = productKeyword.toLowerCase();

		// Check keyword presence in URL
		boolean isKeywordPresentInURL = urlLower.contains(keywordLower);

		// Title validation (primary)
		Assert.assertEquals(actualProduct.trim(), expectedProduct.trim(),
		        "Product title mismatch!");

		// URL validation (secondary)
		Assert.assertTrue(isKeywordPresentInURL,
		        "URL does not contain expected keyword");
		
		*/
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
