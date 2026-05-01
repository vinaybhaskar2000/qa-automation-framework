package webPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePage.BasePage;
import components.A4_DeliveryComponent;
import components.A5_PaymentComponent;

public class A7_CheckOutPage extends BasePage {

	public A7_CheckOutPage(WebDriver driver) {
		super(driver);

	}

	public String getCartPageURL() {
		return getCurrentURL();
	}
	
	public String getPageTitle() {
		return getPageTitle();
	}
	
// As we added Locators and Methods in Component Section, we are getting access from that component.	
	
// Delivery Details / Delivery Section -- 
	
	
	public A4_DeliveryComponent getDeliveryComponents()
	{
		return new A4_DeliveryComponent(driver);
	}
	
	
	
	public A5_PaymentComponent getPaymentComponents()
	{
		return new A5_PaymentComponent(driver);
	}
	
	
	
	
	
	
	
//---------------------------------------- Right Side Product Details----------------------------
	
	// No Of Products in Cart.
	
	private By noOfProducts = By.xpath("//div[contains(@class,'_1m6j2n3z')]");
	
	public int getNoOfProducts()
	{
		String s = driver.findElement(noOfProducts).getText();
		String number  = s.replaceAll("[^0-9]", "");
		return Integer.parseInt(number);
	}
		
	// Product Name.
	
	//private By productName = By.xpath("//div[contains(@class,'_1fragem32 _1fragemsm dDm6x')]//p[contains(@class,'_1tx8jg70 _1fragemsm _1tx8jg7i _1tx8jg7b _1fragemv6 _1tx8jg719 _1tx8jg71h _1tx8jg71j')]");
	private By productName = By.xpath("//div[contains(@class,'_1fragem32 ')]//p[contains(@class,'_1tx8jg70 _1fragemsm _1tx8jg7i')]");
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	// Total
	private By totalAmount = By.xpath("//div[contains(@class,'_17kya4u1q _1fragemuv _1fragemte _1fragem3c _1fragemsm Byb5s')]//span[contains(@class,'_19gi7yt0 _19gi7yt18 _19gi7yt1g _19gi7yt1n _1fragem3h notranslate')]");
	
	public String getTotalAmount()
	{
		return driver.findElement(totalAmount).getText();
	}
	
	// Get SubTotal
	
	private By subTotal = By.xpath("//div[contains(@class,'r0qqvk1 r0qqvk0 _1fragemsm _1fragem3c r0qqvk4 _1fragem4l _1fragem6e _1fragemtb _1fragem3c _1fragemuw _1fragemv2')]");
	
	public String getSubTotal()
	{
		return driver.findElement(subTotal).getText();
	}
	
	

//----------------------------------------Thread.sleep---------------------------	


	/**
	 * This Method is used in place of Thread.sleep wait
	 * @param time
	 */
	@SuppressWarnings("unused")
	private void waitForTime(int time) {

		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
// -------------THESE COMPONENTS ARE MOVIED TO SEPERATE COMPONENTS PAGE HENCE NOT USING------------------------------	
	
	
//----------------------------------------Delivery Section----------------------------
		
		/*
		
		private By firstName = By.name("firstName");
		private By lastName = By.name("lastName");
		private By address = By.name("address1");
		// private By city = By.name("city");
		private By pinCode = By.name("postalCode");
		private By phone = By.name("phone");

		public void enterDeliveryDetails(String fName, String lName) {
			driver.findElement(firstName).sendKeys(fName);
			driver.findElement(lastName).sendKeys(lName);

		}

		public void enterAddress(String city) {

			WebElement address1 = driver.findElement(address);

			address1.sendKeys(city, Keys.ENTER);
			waitForTime(1);
			address1.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			waitForTime(2);
			address1.sendKeys(city, Keys.TAB);

			// WebElement addCity = driver.findElement(address);
			// addCity.sendKeys(city);
			// addCity.sendKeys(Keys.TAB);
		}

		public void enterPinCode(String enterPINCode) {

			driver.findElement(pinCode).sendKeys(enterPINCode, Keys.ENTER);
		}

		public void enterPhneNumber(String mobilePhNumber) {

			driver.findElement(phone).sendKeys(mobilePhNumber, Keys.ENTER);
		}

		private By shippingInfoBox = By.id("save_shipping_information");

		public void clickOnshippingInfoBox() {
			clickOnElement(shippingInfoBox);
		}

		
		*/
		
//----------------------------------------Contact----------------------------	
		
	   /*	
	
		private By email = By.id("email");
		private By emailCheckBox = By.id("marketing_opt_in");

		// Methods.

		public void enterEmail(String emailId) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(emailId);
		}

		public void clickOnEmailCheckBox() {
			clickOnElement(emailCheckBox);
		}
		
		*/
	
	
	

	
//-----------------------------------Payment Section LOCATORS----------------------------
		
		/*
		
		
		private By payNowBtn = By.id("checkout-pay-button");
		private By paymentOptions = By.xpath("(//div[contains(@class,'_1u2aa6m3')])[position() <= 5]");
		
		
		
		// Method 1: --> How to do CheckOutPage_Load_Validation

		public boolean isPaymentPageIsDisplayed() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(payNowBtn)).isDisplayed();
		}		
		
		*/
		
		
		
		// Method 2: --> Select Paymenet option - Below we have payment options to select, pass the String Value
		
		/*
		public void selectPaymentOption(String paymentName)
		{
		    
			List<WebElement> options = driver.findElements(paymentOptions);
			System.out.println(options.size());
			
			for(WebElement option : options)
		    {
		        if(option.getText().contains(paymentName))
		        {
		            option.click();
		            break;
		        }
		    }
		}
		
		*/


		//Method 3: -->  Click on PayNow Buton.  CTRL+/ to uncomment
		
		
		
//			public A8_PaymentPage clickOnPayNowBtn() {
//				
//				/*Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_DOWN).perform(); */
//				
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//				
//				waitForTime(4);
//				WebElement ele = driver.findElement(payNowBtn);
//				wait.until(ExpectedConditions.visibilityOf(ele));
	//
//				// Scroll to webElement to center
//				
//				js.executeScript("arguments[0].scrollIntoView({block:'center'});", ele);
	//
//				// First Try Normal Click.
	//
//				try {
//					ele.click();
//				}
	//
//				catch (Exception e) {
//					// fallback to JS Click
	//
//					js.executeScript("arguments[0].click();", ele);
	//
//				}
	//
//				return new A8_PaymentPage(driver);
//			}

			
			
//--------------------------------------------------------------------------------------------------	
			/*   // Below are the Payment options to selct.
			 
			Total payment Options ---> 5
			
		1.	Cards, UPI, NB, Wallets, BNPL by PayU India
			
			
			+10
			Additional payment methods
			You'll be redirected to Cards, UPI, NB, Wallets, BNPL by PayU India to complete your purchase.
			
			
			
		2.	Paytm Payment Gateway
			+3
			Additional payment methods
			
			
		3.	Razorpay Secure (UPI, Cards, Int'l Cards, Wallets)
			+18
			Additional payment methods
			
			
		4.	Pay 25% now and rest later in 3/6/9 EMIs via Glen Pay Later ⦁ 0% EMI on UPI ⦁ by Snapmint
			
			
		5.	Cash on Delivery (COD)
			
			*/
			
	//--------------------------------------------------------------------------------------------------	
			
			
			
			



}
