package actualTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import webPages.A7_CheckOutPage;
import webPages.A8_PaymentPage;

public class A7_CheckOutPage_Test extends A1_BaseTest 
{
	
	@Test(enabled = false)
	public void verifyCheckoutPageLoads() 
	{
		A7_CheckOutPage checkOutPage = new A7_CheckOutPage(driver);
		boolean checkOutPageIsdisplayed = checkOutPage.getPaymentComponents().isPaymentPageIsDisplayed();
		Assert.assertTrue(checkOutPageIsdisplayed,"Check Out Page is Not Displayed.");
		
	}

	@Test
	public void enterDetails()
	{
		A7_CheckOutPage checkOutPage = new A7_CheckOutPage(driver);
		
		
		// Verify Payment Page is displayed or not.
		boolean checkOutPageIsdisplayed = checkOutPage.getPaymentComponents().isPaymentPageIsDisplayed();
		Assert.assertTrue(checkOutPageIsdisplayed);
		
		// Counting the no.of Products in Cart.
		int noOfProductsInCart = checkOutPage.getNoOfProducts();
		System.out.println("The No.Of Products are : "+noOfProductsInCart);
		
		// Printing the Product Name.
		String productName = checkOutPage.getProductName();
		System.out.println("The Product Name is  : "+productName);
		
		
		// Printing the Total Amount
		String total = checkOutPage.getTotalAmount();
		System.out.println("Total Amount : "+total);
		
		
		// Priting the Sub Total Amount.
		String subTotal =checkOutPage.getSubTotal();
		System.out.println("Sub Total Amount : "+subTotal);
		
		// Filling the Personal Details.
		
		checkOutPage.getDeliveryComponents().enterEmail("abc@gmail.com"); 
		checkOutPage.getDeliveryComponents().enterDeliveryDetails("Hello", "Friend");
		checkOutPage.getDeliveryComponents().enterAddress("Chennai");
		
		checkOutPage.getDeliveryComponents().enterPhneNumber("9963258741");
		checkOutPage.getDeliveryComponents().enterPinCode("600005");
		
		// Clicking on PayNow Button_ Navigating to Payment Page.
		
		//checkOutPage.paymentComponents().selectPaymentOption();
		
		
		A8_PaymentPage paymentPage = checkOutPage.getPaymentComponents().clickOnPayNowBtn();
		
		// Getting URL of the Payment Page.
		String paymentPageURL = paymentPage.getCartPageURL();
		System.out.println("\nPayment Page URL --> "+paymentPageURL);
		Assert.assertTrue(paymentPageURL.contains("checkouts"));
		
		// Getting Page Title of the Payment Page.
		String paymentPageTitle = paymentPage.getPageTitle();
		System.out.println("Payment Pge Title ---> "+paymentPageTitle);
		Assert.assertEquals(paymentPageTitle, "Checkout - Glen Appliances Pvt. Ltd");
		
		System.out.println("\n");
		
	}
	
	
	
	
	
	
	
	
	
	
}
