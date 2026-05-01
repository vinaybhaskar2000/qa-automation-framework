package components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePage.BasePage;

public class A4_DeliveryComponent extends BasePage {

	public A4_DeliveryComponent(WebDriver driver) {
		super(driver);
		
	}
	
	

	

//------------------------------------ Contact Details ----------------------------	
	
	
		private By email = By.id("email");
		private By emailCheckBox = By.id("marketing_opt_in");

		// Methods.

		public void enterEmail(String emailId) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(emailId);
		}

		public void clickOnEmailCheckBox() {
			clickOnElement(emailCheckBox);
		}
		

	
//----------------------------------------Delivery Section----------------------------

		private By firstName = By.name("firstName");
		private By lastName = By.name("lastName");
		private By address = By.name("address1");
		// private By city = By.name("city");
		private By pinCode = By.name("postalCode");
		private By phone = By.name("phone");

		
	// Method.	
		
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
