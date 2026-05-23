package b_e2e_sanity_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import actualTests.A1_BaseTest;
import components.A3_CartPopupComponent;
import webPages.A1_HomePage;
import webPages.A4_SearchResultsPage_TrendyItems;
import webPages.A5_ProductDetailsPage;
import webPages.A6_CartPage;
import webPages.A8_RazorpayPage;

public class Sanity_OrderFlow_Test extends A1_BaseTest
{

	@Test(groups = "sanity")
	public void verifyBasicOrderFlow()
	{	
		System.out.println("Driver in test BEFORE use: " + driver);
		// Home Page
		A1_HomePage homePage = new A1_HomePage(driver);
		
		System.out.println("Driver in test: " + driver);
		
		// Search
		String userInput = "Chimneys";
		A4_SearchResultsPage_TrendyItems srp = homePage.getHeader().clickOnSearchBox().selectItem(userInput);
		
		
		// Select Product.
		A5_ProductDetailsPage pdp = srp.clickProductByGlobalIndex_Actual(10);
		
		
		// Add To cart
		A3_CartPopupComponent cart = pdp.clickAddToCart();
		
		
		// Go To Cart
		A6_CartPage cartPage = cart.clickOnViewCart();
		
		
		// Checkout
		cartPage.clickOnCheckoutBtn_RightSide(); 
		
		
		//Razorpay Popup.
		A8_RazorpayPage razorpayPage = new A8_RazorpayPage(driver);
		Assert.assertTrue(razorpayPage.isRazorPopupDisplay(),"Razorpay popup not displayed");
		
		// This comment is for Poll SCM Testing.

	}
	
}
