package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basePage.BasePage;
import webPages.A1_HomePage;
import webPages.A2_LoginPage;
import webPages.ManualEntry_SearchResultsPage;



public class A1_HeaderComponent extends BasePage {


	
	
	//locators:
	
	By GLEMImage = By.xpath("//img[@class='site-logo-image']");
	//By searchBox = By.xpath("//input[@placeholder='What are you looking for?']");
	By searchBox = By.name("st");
	
	//By searchBtn = By.xpath("//button[@aria-label='Search']");
	By logOut =  By.xpath("//div[@class=\"site-header-right\"]//a[@class=\"site-header__account-link--logout\"][normalize-space()=\"Logout\"]");		
	By MyAccount =  By.xpath("//div[@class=\"site-header-right\"]//a[@class=\"site-header__account-link--account\"][normalize-space()=\"My Account\"]");	
	By cartCount = By.xpath("//span[@class=\"site-header-cart--count visible\"]");
	By loginBtn = By.xpath("//a[@class='site-header_account-link-anchor']//span[@class='site-header_account-link-text'][1]");
	By trendyItems = By.xpath("//div[@id='st-trending-searches']//li");
	
	
	
	
	// Constructor
	
	public A1_HeaderComponent(WebDriver driver) {
		super(driver);
	}
	
	
	
	//Methods.

	public A1_HomePage clickOnGLENImage() {
		clickOnElement(GLEMImage); // driver.findElement(GLEMImage).click();
		return new A1_HomePage(driver);
	}
	
	
	
	public A2_TrendingComponent clickOnSearchBox()
	{
		clickOnElement(searchBox); 
		return new A2_TrendingComponent(driver);
	}
	
	
	public void selectItem(String searchProductName)
	{
		
		
		
		
	}
	
	
	
	
	
	
	
	public A2_LoginPage clickOnLoginBtn() {
		clickOnElement(loginBtn); 
		return new A2_LoginPage(driver);
		// driver.findElement(loginBtn).click();
	}

	
	public void clickOnLogOut() {
		clickOnElement(logOut);
		 // driver.findElement(logOut).click();
		// return new LoginPage(driver);
	}
	
	
	// verify is logout link is present / exists or not.
	// So this method:
	//Checks if logout element exists
	// Returns true or false
	
	public boolean isLogoutPresent()
	{
		List<WebElement> logoutLinkchk = driver.findElements(logOut);
		return logoutLinkchk.size()>0;
	}
	
	
	
	
	public String getCartCount() {
		return getTextFromElement(cartCount);
	}

	
	public void clickOnMyAccount() {
		clickOnElement(MyAccount); // driver.findElement(MyAccount).click();

	}
	
	
	public String getEnteredProductName_manualEntry(String productName)
	{
		return productName;
	}
	
	
	
	
	public ManualEntry_SearchResultsPage searchProduct_manualEntry(String productName) {

		findElementAndEnterText(searchBox, productName);
		//clickOnElement(searchBtn);
		return new ManualEntry_SearchResultsPage(driver);

		/*
		 * driver.findElement(searchBox).sendKeys(productName);
		 * driver.findElement(searchBtn).click(); click(searchBtn); //
		 * driver.findElement(searchBtn).click();
		 */

	}


}
