package webPages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import basePage.BasePage;
import components.A3_CartPopupComponent;

public class A5_ProductDetailsPage extends BasePage {
	
	

//--------------------------- Constructor---------------------------------	

		public A5_ProductDetailsPage(WebDriver driver) 
		{
			super(driver);
		}

	
//--------------------------- LOCATORS---------------------------------	

	private By productTitle = By.xpath("//h1[@class='product-title']");
	private By productPrice = By.xpath("//div[@class='product-pricing']//div[@class='price product__price ']//div[@class='price__current  price__current--on-sale']//span[@class='money']");			
	private By addToCartBtn = By.xpath("//div[@class='product-form__action-wrapper']//button[@type='submit']");
	//private By variantOptions = By.xpath("//div[@class='options-selection__input-select-wrapper']//select[@class='options-selection__input-select']");
	private By variantOptions = By.xpath("//select[contains(@class,'options-selection__input-select')]");
	
	



//--------------------------- GETTERS---------------------------------	

	/**
	 * This Method is used to get the Product Description PageTitle
	 * 
	 * @return
	 */
	public String getPageTitleFromPDP() {
		return getPageTitle();
	}

	/**
	 * This Method is used to get the CurrentPage URL
	 * 
	 * @return
	 */

	public String getCurrentPageURL() {
		String url = getCurrentURL();
		return url;
	}

	/**
	 * This Method is used to get the Product Title
	 * 
	 * @return
	 */
	public String getProductTitle() {

		return getTextFromElement(productTitle);
	}

	/**
	 * This Method is used to get the Product Price
	 * 
	 * @return
	 */
	public String getProductPrice() {
		return getTextFromElement(productPrice);
	}

	
	/*
	 * This Method is used to click on AddToCart Button.
	 */
	public A3_CartPopupComponent clickAddToCart() {
		clickOnElement(addToCartBtn);
		return new A3_CartPopupComponent(driver);
	}
	
	

//--------------------------- VALIDATIONS---------------------------------	

	
	public boolean isProductTitleDisplayed() {
	    return isElementDisplayed(productTitle);
	}

	
	public boolean isProductPriceDisplayed() {
	    return isElementDisplayed(productPrice);
	}

	
	public boolean isAddToCartButtonEnabled() {
	    return isElementEnabled(addToCartBtn);
	}
	

	
//--------------------------- VARIANT METHODS---------------------------------	
	
	
	/**
	 * This Method is used in : Check UI presence,  Purpose: Check UI presence
	 * @return
	 */
	
	public boolean isVariantAvailable()
	{
		return isElementDisplayed(variantOptions);
	}
	
	
	
	
	// Get All Variants
	
	/**
	 * 
	 *  Purpose:Get all dropdown values, Advanced validation, Data-driven testing, Useful for future scenarios
	 * @return
	 */
	
	public List<String> getAllOptions()
	{
		WebElement varientOptions1 = driver.findElement(variantOptions);
		Select select = new Select(varientOptions1);
		List<WebElement> allOptions =  select.getOptions();
		
		List<String> values = new ArrayList<String>();
		
		for(WebElement option :allOptions)
		{
			values.add(option.getText());
		}
		return values;
	}
	
	
	
	
	//  Correct Method for Dropdown Variant
	
	/**
	 * Purpose: Perform user action, Core functionality, Mandatory method
	 * @param variant
	 */
	public void selectVariant(String variant)
	{	
		WebElement varientOptions1 = driver.findElement(variantOptions);
		Select select = new Select(varientOptions1);
		select.selectByVisibleText(variant);
	}
	
		
	
	
	// Get Selected Variant
	
	/**  Purpose:Verify what is currently selected, Validation after action, Very important in real projects
	 * 
	 * @return
	 */
	public String getSelectedVariant()
	{
		WebElement varientOptions1 = driver.findElement(variantOptions);
		Select select = new Select(varientOptions1);
		String option = select.getFirstSelectedOption().getText();
		return option;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
