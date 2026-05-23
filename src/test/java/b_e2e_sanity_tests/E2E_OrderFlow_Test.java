package b_e2e_sanity_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import actualTests.A1_BaseTest;
import components.A1_HeaderComponent;
import components.A2_TrendingComponent;
import components.A3_CartPopupComponent;
import webPages.A1_HomePage;
import webPages.A4_SearchResultsPage_TrendyItems;
import webPages.A5_ProductDetailsPage;
import webPages.A6_CartPage;
import webPages.A7_CheckOutPage;
import webPages.A8_RazorpayPage;

public class E2E_OrderFlow_Test extends A1_BaseTest {

	@Test(groups = "e2e")
	public void verifyUsercanPlaceOrderSuccessfully() {
		
test.info("Opening application");
		// Step 1: Home Page
		A1_HomePage homePage = new A1_HomePage(driver);
		System.out.println(homePage.getHomePageTitle());

		
		// Step 2: Search Product - Select product Name
test.info("Searching for product");
		String userInput = "Chimneys";

		
		/*
		 * // These steps will give details explanation. Step wise. But we are using
		 * Page Chaining. A1_HeaderComponent d = homePage.getHeader();
		 * A2_TrendingComponent e = d.clickOnSearchBox();
		 * A4_SearchResultsPage_TrendyItems f = e.selectItem(userInput); String g =
		 * f.getSearchResultsPageTitle(); System.out.println(g);
		 */

		A4_SearchResultsPage_TrendyItems srp = homePage.getHeader().clickOnSearchBox().selectItem(userInput);
		String searchResultsPageTitle = srp.getSearchResultsPageTitle();
		System.out.println("Search Result Page Title : " + searchResultsPageTitle);
		Assert.assertTrue(searchResultsPageTitle.toLowerCase().contains(userInput.toLowerCase()),
				"Search results page title does not contain expected text");

		// Step 3: Select the Product.
		A5_ProductDetailsPage pdp = srp.clickProductByGlobalIndex_Actual(10);
		String productTitle = pdp.getProductTitle();
		System.out.println("\n" + productTitle);

		// Step 4: click on Add To cart button.
		A3_CartPopupComponent cart = pdp.clickAddToCart();
test.info("Adding product to cart");
		

		// Step 5: click on View Cart button.
		A6_CartPage cartPage = cart.clickOnViewCart();
		cartPage.enterQty(33);

		// Getting the No.Of Items in Stock. Extracting the Number from the Text.
		int theAvailablestockNumber = cartPage.getAvailableStockNumber();
		System.out.println("The Availabe Stock is only ---> " + theAvailablestockNumber + " Items");

		int productQuantity_UPD = cartPage.getQuantity();
		System.out.println(
				"\n- QUANTITY BLOCK - No.Of Items / Qauntity of Product After Update : --> " + productQuantity_UPD);

		// Printing Total Price of Product at Quantity Block.
		String totalPrice_QuantityBlock_UPD = cartPage.getItemTotalPrice_QuantityBlock();
		System.out.println("- QUANTITY BLOCK - Total Price: After Update --> " + totalPrice_QuantityBlock_UPD);

//--------------------------------Step 6: Click on CheckOut btn ----------------------------------
		
		/*

		1.  A7_CheckOutPage ed = cartPage.clickOnCheckoutBtn_RightSide(); No MORE VALID.
		2.  Since Checkout Page is changed to razorPage UI. 06 04 2026/THU
		3.  Since the Popup is displaying, we are not returning the page. we just create an Object.
		4.  A8_RazorpayPage razorPayPopup = cartPage.clickOnCheckoutBtn_RightSide(); // OLD CODE
		
		*/
		
		cartPage.clickOnCheckoutBtn_RightSide(); // This method does not return any thing. / void
test.info("Proceeding to checkout");
//------------------------------- Step 7: RAZORPAY POPUP VALIDATIONS ---------------------------------
		
		A8_RazorpayPage razorpayPage = new A8_RazorpayPage(driver);
		System.out.println("\n"+razorpayPage.isRazorPopupDisplay()+"Razor Pop Up is displaying...!" );
		Assert.assertTrue(razorpayPage.isRazorPopupDisplay(),"Razorpay popup not displayed");
		        
		
		// Switching to Razor Pay popup.
		razorpayPage.switchToRazorPay();
		
		
		// CONTACT SECTION.
		
		boolean contactSection = razorpayPage.isContactSectionDisplayed();
		Assert.assertTrue(razorpayPage.isContactSectionDisplayed(), "Contact section not visible");
		
	//	Assert.assertTrue(false);  // --> intentionally making fail to test the screenshot. it is working.
		
		System.out.println("\n"+contactSection+" --->Yes..Contact Section is displaying.");
		System.out.println("The Heading of Contact Section is : -->"+razorpayPage.getHeadingOfContactSection() );
		
		System.out.println("\n");
		
		//PHONE SECTION.
		
		boolean phField = razorpayPage.isMobileFieldDisplayed();
		Assert.assertTrue(razorpayPage.isMobileFieldDisplayed(), "Mobile field not visible");
		
		System.out.println(phField+"---> Yes..Phone Field is displaying.");

		String phFieldText = razorpayPage.getHeadingOfMobileField();
		System.out.println("Phone Field Text  is : -->"+phFieldText);

		
		// EMAIL
		
		boolean emailField = razorpayPage.isEmailFieldDisplayed();
		Assert.assertTrue(emailField, "Email field not visible");
		
		System.out.println("\n"+emailField+"---> Yes..Email Field is displaying.");
		
		System.out.println("\n");
		
		// enter data
		
		razorpayPage.enterDataInMobileNumberField("9000654333");
		razorpayPage.enterDataInEmailField("helloVijay@gmail.com");
		
		razorpayPage.clickOnSubmitBtn();
		test.pass("Order placed successfully");
		
		// This Comment is for Poll SCM Testing.
	}

}
