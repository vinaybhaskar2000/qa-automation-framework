package webPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.BasePage;

public class A8_RazorpayPage extends BasePage {
	
	WebDriverWait wait;

	public A8_RazorpayPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	
//----------------------------- LOCATORS & METHODS. -------------------------------------------------------

	//private By razorPaypopup = By.xpath("//div[@id='razorpay-checkout-v2-container']");
	
	private By razorPaypopup = By.cssSelector("iframe.razorpay-checkout-frame");
	
	

//----------------------------- Method - 1   isRazorPopupDisplay() ----------------------------------------
	
	/**
	 * This method is just used to check razor Popup is display or not..thats all.!	
	 * @return
	 */
	
	public boolean isRazorPopupDisplay() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        boolean iframePresent = wait.until(driver ->
	            driver.findElements(By.cssSelector("iframe.razorpay-checkout-frame")).size() > 0
	        );

	        return iframePresent;

	    } catch (Exception e) {
	        return false;
	    }
	}

	
//----------------------------- Method - 2  switchToRazorPay() ----------------------------------------
	
	/**
	 * This Method is used to Switch to razorpay Popup
	 */
	
	public void switchToRazorPay() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement frame = wait.until(driver -> {
	        for (WebElement iframe : driver.findElements(By.tagName("iframe"))) {
	            if (iframe.getDomAttribute("src") != null &&
	                iframe.getDomAttribute("src").contains("razorpay")) {
	                return iframe;
	            }
	        }
	        return null;
	    });

	    driver.switchTo().frame(frame);
	}
	
	
	

	
//----------------------------- Method - 3  CONTACTS ----------------------------------------
	
	
	/**
	 * This Method is used to check the Contacts Section is displayed.
	 * @return
	 */
	/*
	//✅ Final Validation Methods
	//✔️ Contact Section
	public boolean isContactSectionDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement contact = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(),'Contact')]")
	        )
	    );

	    return contact.isDisplayed();
	}  */
	
	
	public boolean isContactSectionDisplayed() {

		WebElement contactDetails = driver.findElement(By.xpath("//h3[contains(text(),'Contact details')]"));
		wait.until(ExpectedConditions.visibilityOf(contactDetails));
		return contactDetails.isDisplayed();
	}
	
	
	
	public String getHeadingOfContactSection() 
	{
		WebElement contactDetails = driver.findElement(By.xpath("//h3[contains(text(),'Contact details')]"));
		wait.until(ExpectedConditions.visibilityOf(contactDetails));
		return contactDetails.getText();
	}
	
	
	
//----------------------------- Method - 4   PHONE ----------------------------------------
	
	
	/**
	 * This Method is used to check the Phone Field is displayed.
	 * @return
	 */
	
	/*
	public boolean isPhoneFieldDisplayed() {

		// WebElement phoneDetails =
		// driver.findElement(By.xpath("//input[@type='tel']"));
		WebElement phoneDetails1 = driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
		return phoneDetails1.isDisplayed();
	}
	
	*/

	
	//✔️ Mobile Field
	
	public boolean isMobileFieldDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement mobile = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//input[@type='tel']")
	        )
	    );

	    return mobile.isDisplayed();
	}
	
	
	
	public String getHeadingOfMobileField() 
	{
		WebElement phoneDetails1 = driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
		String phField = phoneDetails1.getDomAttribute("placeholder");
		return phField;
	}
	
	
	
	public void enterDataInMobileNumberField(String number)
	{
		WebElement phoneDetails1 = driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
		phoneDetails1.sendKeys(number,Keys.TAB);
	}
	
	
	

//----------------------------- Method - 5  EMAIL FIELD ----------------------------------------
	
	//✔️ Email Field
	
	public boolean isEmailFieldDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement email = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//input[@name='email']")
	        )
	    );

	    return email.isDisplayed();
	}
	
	
	
	
	public void enterDataInEmailField(String emailId)
	{
		WebElement eMail = driver.findElement(By.xpath("//input[@name='email']"));
		eMail.sendKeys(emailId,Keys.TAB);
	}
	
	
	public void clickOnSubmitBtn()
	{
		By submitBtn = By.xpath("//div[@id='contact-submit']");
		
		driver.findElement(submitBtn).click();
	}
	
	
	
	
	
	/*
	 Alternative (better locator)

	Use something stable:

	//input[@type='tel']

	OR

	//h3[contains(text(),'Contact')]
	
	*/
	  
	
// ------------------------------deleted---------------------------	
	/*
	public void switchToRazorPay()
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		/*
		//WebElement iframerazorPay = driver.findElement(By.xpath("//iframe[contains(@src,'razorpay')]"));
		// Since web element is not accpted , we used by locator.
		By iframerazorPay =  By.cssSelector("iframe[src*='razorpay']");
		WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(iframerazorPay));
		driver.switchTo().frame(frame);
		
		*/
	/*	 WebElement frame = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(
			            By.cssSelector("iframe.razorpay-checkout-frame")
			        )
			    );

			    driver.switchTo().frame(frame);
		
		
	}
	*/
	
	
	
	

}
