package basePage;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	//protected HeaderComponent header;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//this.header = new HeaderComponent(driver); // important

	}

	// ================================
	// BASIC ACTIONS
	// ================================
		
	/*
	
	public HeaderComponent getHeader()
	{
		//return header;
		return new HeaderComponent(driver);
	}
	
	*/
	
	
	/**
	 * 
	 * @return
	 */
	public String getPageTitle() {
        return driver.getTitle();
    }
	
	
	// defiing wait.
	
	public WebElement waitForVisibilityOfElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	
	/**
	 * 
	 * @param locator
	 */
	protected void clickOnElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	/**
	 * 
	 * @param locator
	 * @param text
	 */
	protected void findElementAndEnterText(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	
	/**
	 * 
	 * @param locator
	 * @return
	 */
	protected String getTextFromElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}
	
	
	
	/**
	 * 
	 * @param locator
	 * @return
	 */
	protected boolean isElementDisplayed(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}

	
	/**
	 * 
	 * @param locator
	 * @return
	 */
	
	protected boolean isElementEnabled(By locator) {
	    return driver.findElement(locator).isEnabled();
	}
	
	
	
	
	// ================================
	// Utility Methods.
	// ================================
	
	
	/**
	 * 
	 * @return
	 */
	protected @Nullable String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	
	
	/**
	 * 
	 * @param locator
	 */
	protected void scrollIntoView(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

}
