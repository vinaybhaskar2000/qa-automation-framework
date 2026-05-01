package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePage.BasePage;
import webPages.A8_PaymentPage;

public class A5_PaymentComponent extends BasePage{

	public A5_PaymentComponent(WebDriver driver) {
		super(driver);
		
	}

//-----------------------------------Payment Section LOCATORS----------------------------

		private By payNowBtn = By.id("checkout-pay-button");
		private By paymentOptions = By.xpath("(//div[contains(@class,'_1u2aa6m3')])[position() <= 5]");
		
		
		
// Method 1: --> How to do CheckOutPage_Load_Validation

		public boolean isPaymentPageIsDisplayed() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(payNowBtn)).isDisplayed();
		}		
		
		
		
// Method 2: --> Select Paymenet option - Below we have payment options to select, pass the String Value
		// Later for Regression Testing.
		
		public void selectPaymentOption()
		{
		    
			List<WebElement> options = driver.findElements(paymentOptions);
			System.out.println(options.size());
			
	
			
			waitForTime(4);
			
			
			WebElement ele = driver.findElement(By.xpath("//input[contains(@aria-label,'Razorpay')]"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			
			waitForTime(4);
			
		//	wait.until(ExpectedConditions.visibilityOf(ele));

			// Scroll to webElement to center
			
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", ele);

			// First Try Normal Click.

			try {
				ele.click();
			}

			catch (Exception e) {
				// fallback to JS Click

				js.executeScript("arguments[0].click();", ele);

			}
			
			
			
			/*
			for(int i=0; i<options.size(); i++)
			{
				String f = options.get(i).getText();
				System.out.println(f);
				
				if(f.contains(paymentName))
				{
					waitForTime(1);
					options.get(i).click();
				}
			}
			
			
			*/
			/*
			
			for(WebElement option : options)
		    {
		        if(option.getText().contains(paymentName))
		        {
		            option.click();
		            break;
		        }
		    }
			
			*/
			
		}
		


//Method 3: -->  Click on PayNow Buton.

			public A8_PaymentPage clickOnPayNowBtn() {
				
				/*Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).perform(); */
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				
				waitForTime(4);
				WebElement ele = driver.findElement(payNowBtn);
				wait.until(ExpectedConditions.visibilityOf(ele));

				// Scroll to webElement to center
				
				js.executeScript("arguments[0].scrollIntoView({block:'center'});", ele);

				// First Try Normal Click.

				try {
					ele.click();
				}

				catch (Exception e) {
					// fallback to JS Click

					js.executeScript("arguments[0].click();", ele);

				}

				return new A8_PaymentPage(driver);
			}

			
			
		
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
			
			
			
			
//----------------------------------------Thread.sleep---------------------------	

			
			
			/**
			 * This Method is used in place of Thread.sleep wait
			 * @param time
			 */
			//@SuppressWarnings("unused")
			private void waitForTime(int time) {

				try {
					Thread.sleep(time * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				

	
}
