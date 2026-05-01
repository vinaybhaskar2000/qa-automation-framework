package actualTests;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.A3_CartPopupComponent;
import webPages.A5_ProductDetailsPage;
import webPages.A6_CartPage;
import webPages.A7_CheckOutPage;
import webPages.A8_RazorpayPage;

public class A6_CartPage_Test extends A1_BaseTest {
	
	
	@Test
	public void verifyCartPage()
	{
		A5_ProductDetailsPage pdp = new A5_ProductDetailsPage(driver);
		


		// Step 1: Validate PDP is loaded
		
		Assert.assertTrue(pdp.isProductTitleDisplayed(),"Title is not visible");
		/*
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	//	Assert.assertTrue(pdp.isProductPriceDisplayed(),"Price is not visible");
		
		// Step 2: Validate Variant Drop Down
	//	Assert.assertTrue(pdp.isVariantAvailable(),"Variant dropdown not available");
		
		
		// Printing of all Variants
		List<String> ele =   pdp.getAllOptions();
		for(String f : ele)
		{
			System.out.println(f);
		}
		
		// Step 3: Select Variant
		String variantToSelect = "90cm";
		pdp.selectVariant(variantToSelect);
		
		
	    // Step 4: Validate selected variant
		 String selectedVariant = pdp.getSelectedVariant();
		 Assert.assertEquals(selectedVariant,variantToSelect,"Variant not selected properly");
		
		 // Step 5: Capture price before adding
		 String price = pdp.getProductPrice();
		 System.out.println("Price: " + price);
		
		 
		// Step 6: Add to cart
		boolean cart =  pdp.isAddToCartButtonEnabled();
		Assert.assertTrue(cart, "Add to Cart disabled");
		
// ------------------------ Step 7: Cart Popup Component validations.------------------------------
		
		// Verify popupComponent is displaying or not, with a Text.
		A3_CartPopupComponent popUp = pdp.clickAddToCart();
		String text = popUp.getAddedToYourCartText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Added to your cart"));
		
		// Verifying: Product Name.
		String productNameText = popUp.getProductName();
		System.out.println("\n"+productNameText);
	//	Assert.assertTrue(productNameText.contains("Chimney"));
		Assert.assertTrue(productNameText.contains(pdp.getProductTitle()));
		
		
		// Verifying Product Details Price Text
		String productDetailsPriceText = popUp.getProductDetailsPriceText();
		System.out.println(productDetailsPriceText);
		Assert.assertTrue(productDetailsPriceText.contains(price),"Price mismatch between PDP and popup");
		
		
		// Verifying: View Cart and Product Count in it.
		String viewCartButtonVCount = popUp.getViewCartButtonText();
		System.out.println(viewCartButtonVCount);
		
		
		// Verifying Cart Sub Total
		String cartSubTotalText = popUp.getCartSubTotalText();
		System.out.println(cartSubTotalText);
		
// ------------------------ Click on View Cart Button -- Navigating to CART Page..------------------------------
		
		A6_CartPage cartPage = popUp.clickOnViewCart();
		
		System.out.println("\nNavigating to Cart Page.");

		
		// Printing Cart Page URL
		String cartPageURL = cartPage.getCartPageURL();
		System.out.println(cartPageURL);
		
//-----------------------------  YOUR CART SECTION  ---------------------------------------------	
		System.out.println("\n*****************************************************");
		System.out.println("Before Change the Value, default 1 product will be selected ");
		System.out.println("\n*****************************************************");
		
		
		// Printing YOUR CART Heading.
		String yourCartHeading = cartPage.getYourCartHeadingText();
		System.out.println("\n- YOUR CART Section - Heading--->"+yourCartHeading);
		
		
		//Printing the Sub Total Amount in Your Cart Section
		String subTotalAmount_rightSideSectionBlock = cartPage.getCartSubtotal_Rightsie();
		System.out.println("- YOUR CART Section - Sub Total Amount: --> "+subTotalAmount_rightSideSectionBlock);
		
		
//-----------------------------  PRODUCT DETAILS  SECTION  ---------------------------------------------	
		
		// Printing Product Name.
		String productName = cartPage.getProductName();
		System.out.println("\nProduct Name : --> "+productName);
		
		
		//Printing ItemVendor
		String vendorName = cartPage.getCartItemVendor();
		System.out.println("Vendor Name : --> "+vendorName);	
		
		
		//Prinitng selected Variant Option of Product.
		String variantOption = cartPage.getSelectedProductVariantOption();
		System.out.println("Selected Variant Option for the Product : --> "+variantOption);
		
		
		//Printing Unit Price  of Product.
		String totalPriceInfo = cartPage.totalPriceText();
		System.out.println("\nUnit Price of the Selcted Product : --> "+totalPriceInfo);
		
//-------------- PRICE VALIDATIONS-----------------------------------
		
		String originalPriceText = cartPage.getOriginalPriceText();
		System.out.println("\nExtracting Striked Original Price in Text : --> "+originalPriceText);
		
		
		String currentPriceText = cartPage.getCurrentPriceText();
		System.out.println("Extracting Current Price in Text : --> "+currentPriceText);
		
		// Removing, INR Price Symbil, Commas, and Spaces and just printing  numbers.
		
		
		//Step 4: Extract Only Numbers.
		   
		int strikedOriginalPrice_Numbers = cartPage.getOriginalPriceValue_Numbers();
		System.out.println("\nExtracting Striked Original Price in Numbers : --> "+strikedOriginalPrice_Numbers); 

		
		int actualCurrentPrice_Numbers = cartPage.getCurrentPriceValue_Numbers();
		System.out.println("Extracting Actual Current Price in Numbers: --> "+actualCurrentPrice_Numbers);
		
		
//--------------------------------------------------------------------		
		/*
		String text1 = unitPrice;
		Pattern p = Pattern.compile("₹\\s*([\\d,]+)$");
		Matcher m = p.matcher(text);

		if (m.find()) {
		    String pricea = m.group(1);
		    System.out.println("******************"+pricea);  // Output: 11,495
		};
		
		*/
		
		
//-----------------------------  QUANTITY BLOCK  BEFORE UPDATE ---------------------------------------------		
		
		// veify Negative / Minus button is disables.
		boolean minusBtndisabled = cartPage.isMinusButtonDisplabled();
		System.out.println("\n-Minus Button is disabled ? --> "+minusBtndisabled);
		Assert.assertTrue(minusBtndisabled);
		
		
		
		// Printing the No.Of Items / Qauntity of Product
		int productQuantity = cartPage.getQuantity();
		System.out.println("\n- QUANTITY BLOCK - No.Of Items / Qauntity of Product : --> "+productQuantity);	
		
		
		//Printing Total Price of Product at Quantity Block.
		String totalPrice_QuantityBlock = cartPage.getItemTotalPrice_QuantityBlock();
		System.out.println("- QUANTITY BLOCK - Total Price: --> "+totalPrice_QuantityBlock);
		
		
		//Printing the Sub Total Amount in Footer Section.
		String subTotalAmount_FooterBlock = cartPage.getFooterSubTotal();
		System.out.println("\n- FOOTER SECTION - Sub Total Amount :--> "+subTotalAmount_FooterBlock);

		
		//Printing the No.of Items in Cart.
		int NoOfItemsDisplayingIncart = cartPage.getHeaderCartCount_upd();
		System.out.println("\n- CART SECTION - The No.Of Items Displaying In cart are : --> "+NoOfItemsDisplayingIncart);
		
		/*
		// Is stock message displaying? displaying check.
		
		try
		{
		boolean stockMsgDisplayed =     cartPage.isStockMessageDisplayed_before();
		if(!stockMsgDisplayed)
		{
			System.out.println("Stock Message is not displaying...!");
		}
		}
		catch(Exception e)
		{
			System.out.println("Stock Message is not displaying...!");
		}
		
		*/
		
		String subTotalValidations = cartPage.validateSubTotals();
		System.out.println(subTotalValidations);
		
		
		System.out.println("\n-------------------------------------------");
		System.out.println("AFTER UPDATING ");
		System.out.println("-------------------------------------------");
		
		
		//cartPage.updateQuantity(20);
		
		
		
		
		int expctedQtyToEnter = 33;
		//cartPage.closePopup();
		System.out.println("\nChanging the No.Of Items Value in Quantity Block to: -->  "+expctedQtyToEnter);
		
		cartPage.enterQty(expctedQtyToEnter);
		//cartPage.clickIncreaseQty_ClickPlus();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
// Stock Message validations---------
		
		boolean yesDisplayed = cartPage.isStockMessageDisplayed_upd();
		System.out.println("\nThe Stock Message is displayed ---> "+yesDisplayed);
		Assert.assertTrue(yesDisplayed);
		
		// Gettong the Stock Message
		String getCartMsg = cartPage.getstockMessage();
		System.out.println("The Stock Message is : ---> "+getCartMsg);
		
		
		// Getting the No.Of Items in Stock. Extracting the Number from the Text.
		int theAvailablestockNumber = cartPage.getAvailableStockNumber();
		System.out.println("The Availabe Stock is only ---> "+theAvailablestockNumber+" Items");
		
		
// Now verifying the no.of items available must be the value in DOM...so verify.		
		
		
		
		String valueInDOM = cartPage.getQtyUpdatedInputValue();
		System.out.println("\nThe Updated value in DOM input class, value attribute : --> "+valueInDOM);
		//cartPage.waitForQtyUpdate(expctedQtyToEnter);
		
		int stockNum_valueInDOM = Integer.parseInt(valueInDOM);
		if (theAvailablestockNumber == stockNum_valueInDOM) 
		{
			System.out.println(" Yes, the Stock Number in Msg, and the value of Value attribute is same.");
		}
		
		
		
// Price Validation for Updated Count of Products: -------------------------------------
		
		
		/*
		double unitPrice_actualUnitPrice = Double.parseDouble(unitPrice);
		
		int productQuantity_upd = cartPage.getQuantity();
		System.out.println("\n- QUANTITY BLOCK - No.Of Items / Qauntity of Product after updated : --> "+productQuantity_upd);
		
		double totalPriceOfAllProducts =  unitPrice_actualUnitPrice*productQuantity_upd;
		System.out.println("The Total Price of All Products -->> "+totalPriceOfAllProducts);
		
		*/
		
	//	Assert.assertEquals(theAvailablestockNumber, stockNum);
		
// Closing  /Clicing on the Stock Message.	
		
			cartPage.closeStockMessage();
		System.out.println("Closing the Stock Message...!");
		
//--------------------------------------------------------------------------		
		
		int productQuantity_UPD = cartPage.getQuantity();
		System.out.println("\n- QUANTITY BLOCK - No.Of Items / Qauntity of Product After Update : --> "+productQuantity_UPD);	
		
		
		//Printing Total Price of Product at Quantity Block.
		String totalPrice_QuantityBlock_UPD = cartPage.getItemTotalPrice_QuantityBlock();
		System.out.println("- QUANTITY BLOCK - Total Price: After Update --> "+totalPrice_QuantityBlock_UPD);
	
		
//-------------- PRICE VALIDATIONS AFTER UPDATE THE PRODUCT----------------------------------		
		
		
		String originalPriceText_afterUpd = cartPage.getOriginalPriceText();
		System.out.println("\nExtracting Striked Original Price Text _ After Update: --> "+originalPriceText_afterUpd);
		
		
		String currentPriceText_afterUpd = cartPage.getCurrentPriceText();
		System.out.println("Extracting Current Price Text _ After Update : --> "+currentPriceText_afterUpd);
		
		// Removing, INR Price Symbil, Commas, and Spaces and just printing  numbers.
		
		int strikedOriginalPrice_Numbers_AfterUpdate = cartPage.getOriginalPriceValue_Numbers();
		int actualCurrentPrice_AfterUpdate = cartPage.getCurrentPriceValue_Numbers();
		
		System.out.println("\nExtracting Striked Original Price in Numbers : --> "+strikedOriginalPrice_Numbers_AfterUpdate); 
		System.out.println("Extracting Actual Current Price in Numbers: --> "+actualCurrentPrice_AfterUpdate);

		
		
// Quantity  and Price Check:
		
		
		
		
		
		
		
		
		
		/*
		// Comparaing the Total Price
		// Converting the price to Double.
		
		Double totalAmountInQualityBlock = Double.parseDouble(totalPrice_QuantityBlock_UPD);
		System.out.println("Total Amount of all Products_1 = "+totalAmountInQualityBlock);
		System.out.println("Total Amount of all Products_2 = "+totalPriceOfAllProducts);
		
		*/
		
// Comparing -------------------------------
		
	//	Assert.assertEquals(totalPriceOfAllProducts, totalAmountInQualityBlock);
		
		
		//Printing the Sub Total Amount in Your Cart Section
		String subTotalAmount_rightSideSectionBlock_upd = cartPage.getCartSubtotal_Rightsie();
		System.out.println("\n- YOUR CART Section - Sub Total Amount After Updated: --> "+subTotalAmount_rightSideSectionBlock_upd);
		
		
		
		// Total Amount Calculations: QTY*PRICE.
		String calculateSubTotalAmountValidations = cartPage.validateTotalPrice(productQuantity_UPD);
		System.out.println("\n"+calculateSubTotalAmountValidations);
		
		
		
		// veify Negative / Minus button is disables.
		boolean minusBtndisabled_upd = cartPage.isMinusButtonDisplabled();
		System.out.println("\n- Minus Button is disabled ? --> "+minusBtndisabled_upd);
		Assert.assertFalse(minusBtndisabled_upd);
		
		
//----------------------------- FOOTER - SECTION ----------------------------------------------
		
		
		//Printing the Sub Total Amount in Footer Section.
		String subTotalAmount_FooterBlock_After_UPD = cartPage.getFooterSubTotal();
		System.out.println("\n- FOOTER SECTION - Sub Total Amount After Updated :--> "+ subTotalAmount_FooterBlock_After_UPD);
		
		
		// Total Amount Calculations: QTY*PRICE.
		String calculateSubTotalAmountValidations_FooterSection = cartPage.validateTotalPrice(productQuantity_UPD);
		System.out.println("\n"+calculateSubTotalAmountValidations_FooterSection);

		
		String subTotalValidations_upd = cartPage.validateSubTotals();
		System.out.println("Updated Qauntity Price -->"+subTotalValidations_upd);
		
//----------------------------- CART - SECTION ----------------------------------------------	
		
		//Printing the No.of Items in Cart.
		int NoOfItemsDisplayingIncart_upd = cartPage.getHeaderCartCount_upd();
		System.out.println("\n- CART SECTION - The No.Of Items Displaying In cart are : --> "+NoOfItemsDisplayingIncart_upd);
		
		// Comparing the values of: DOM Value and Items in Cart.
		if (NoOfItemsDisplayingIncart_upd == stockNum_valueInDOM) 
		{
			System.out.println(" Yes, the Products Count in Cart, and the value of Value attribute in DOM is same.");
		}
		
		Assert.assertEquals(stockNum_valueInDOM, NoOfItemsDisplayingIncart_upd,"Not equals");
		
//----------------------------- CLICK ON X REMOVE BUTTON. ----------------------------------------------	
		
	/*	
		
		String msg = cartPage.clickOnXButton_At_QuantityBlock();
		System.out.println("\nClicked on X button, to remove all Products from Cart. "+msg);
		
		//Printing the No.of Items in Cart After delete the Products--it should not have any products in Cart.
		int NoOfItemsDisplayingIncart_AfterDeletedProducts = cartPage.getHeaderCartCount_upd();
		System.out.println("The No.Of Items Displaying In cart / After Deleting : --> "+NoOfItemsDisplayingIncart_AfterDeletedProducts);
	
		System.out.println("\n");
		
		*/
		
//----------------------------- CLICK ON CHECK OUT BUTTON. ----------------------------------------------		
		
	/*
		
		// THIS METHOD IS NO MRE VALID AS CHECKOUT PAGE CHANGED TO RAZORPAY UI
			
		//A7_CheckOutPage chkOutPage =  cartPage.clickOnCheckoutBtn_RightSide();
	
		A8_RazorpayPage chkOutPage =  cartPage.clickOnCheckoutBtn_RightSide();
		System.out.println("\n-Checkout page URL --> :  "+chkOutPage.getCartPageURL());
		
		boolean checkOut = chkOutPage.getCartPageURL().contains("checkout");	
		Assert.assertTrue(checkOut);
		
		System.out.println("\n");
		
	*/
		

		
		
// ------------------------- QUANTITY BLOCK -------------------------------------------------		
		
		
		
		/*
		// Click on Checkout Button at Rightside.
		
	     A7_CheckOutPage checkOutPage	=  cartPage.clickOnCheckoutBtn_RightSide();
	     String checkOutPageURL =  checkOutPage.getCartPageURL();
	     System.out.println("\nCheckOut Page URL : --> "+checkOutPageURL);
	     
	     */
	     
	      
	}

}


