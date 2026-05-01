package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePage.BasePage;
import webPages.A6_CartPage;
import webPages.A7_CheckOutPage;

public class A3_CartPopupComponent extends BasePage {

//--------------------------- Constructor---------------------------------	

	public A3_CartPopupComponent(WebDriver driver) {
		super(driver);
	}

//--------------------------- LOCATORS-----------------------------------	

	
	private By addedToYourCart_BannerProductTitle = By.xpath("//div[contains(@class,'atc-banner')]//h2[@class='atc-banner--product-title']");	
	private By productName = By.xpath("//h2[@class='atc--product-details--title']");
	private By productDetailsPrice = By.xpath("//span[@class='atc--product-details--price']");
	private By cartSubTotal = By.xpath("//div[@class='atc-banner--cart-subtotal']");
	private By viewCartBtn = By.xpath("//footer[@class='atc-banner--cart-footer']//a");
	// By checkoutBtn = By.xpath("//footer[@class='atc-banner--cart-footer']//form//button[@name='checkout']");
	private By checkoutBtn = By.name("checkout");
	private By closeBtn = By.xpath("//button[@class='atc-banner--close']");

	
	
//--------------------------- ReUsableMethods.---------------------------------
	
	
	private WebElement waitForPopUpElementVisible(By locator) 
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	
	public String getPriceTest(By locator1, By locator2) {
		String a = waitForPopUpElementVisible(locator1).getText().trim();
		String b = waitForPopUpElementVisible(locator2).getText().trim();
		String c = a + " " + b;
		return c;

	}

//--------------------------- GETTERS---------------------------------

	public String getAddedToYourCartText() {
		return waitForPopUpElementVisible(addedToYourCart_BannerProductTitle).getText().trim();
	}

	public String getProductName() {
		return waitForPopUpElementVisible(productName).getText().trim();
	}

	public String getProductDetailsPriceText() {
		return waitForPopUpElementVisible(productDetailsPrice).getText().trim();
	}

	public String getCartSubTotalText() {
		return waitForPopUpElementVisible(cartSubTotal).getText().trim();
	}

	public String getViewCartButtonText() {
		return waitForPopUpElementVisible(viewCartBtn).getText().trim();
	}

//--------------------------- CLICK---------------------------------

	public A6_CartPage clickOnViewCart() {
		waitForPopUpElementVisible(viewCartBtn).click();
		return new A6_CartPage(driver);
	}

	public A7_CheckOutPage clickOnCheckOutBtn() {
		waitForPopUpElementVisible(checkoutBtn).click();
		return new A7_CheckOutPage(driver);

	}

	public void clickOnCloseBtn() {
		waitForPopUpElementVisible(closeBtn).click();
		
	}

}
