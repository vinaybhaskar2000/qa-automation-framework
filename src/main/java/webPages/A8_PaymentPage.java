package webPages;

import org.openqa.selenium.WebDriver;

import basePage.BasePage;

public class A8_PaymentPage  extends BasePage {

	public A8_PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getCartPageURL()
	{
		return  getCurrentURL();
	}
	 

}
