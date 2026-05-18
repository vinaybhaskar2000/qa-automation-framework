package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basePage.BasePage;

public class A3_MyAccountPage extends BasePage {

	/*
	 * This page should contain: • locators • page actions (simple ones)
	 */

	public A3_MyAccountPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * we should not hard code this By userName =
	 * By.xpath("//h2[contains(text(),'VINAY BHASKAR')]"); 
	 * By email = By.linkText("vinaybhaskar2000@yahoo.com");
	 * 
	 */

	By MyAccountHeaderText = By.xpath("//h1[contains(text(),'My Account')]");
	By userName = By
			.xpath("//div[@class='account-page--column-small account-info']//div[@class='account-info-block'][1]");
	By email = By.xpath("//p[@class='account-info-item']//a");
	By viewAddress = By.linkText("View addresses (1)");
	By orderHistory = By.xpath("//h2[contains(text(),'Order history')]");
	By country = By.xpath("//li[contains(text(),'India')]");

	// Methods

	public boolean isMyAccountPageDisplayed() {
		return isElementDisplayed(MyAccountHeaderText); // return driver.findElement(MyAccountHeaderText).isDisplayed();

	}

	public boolean checkIsDisplayed() {
		return isElementDisplayed(MyAccountHeaderText);
	}

	public String getUserName() {
		return getTextFromElement(userName); // return driver.findElement(userName).getText();

	}

	public String getEmailId() {
		return getTextFromElement(email); // return driver.findElement(email).getText();

	}

	public boolean isEmailCorrect(String expectedEmail) {

		return getEmailId().equals(expectedEmail);
		// String email = getEmailId();
		// return email.equals(expectedEmail);

	}

	public void clickOnViewAddress() {
		clickOnElement(viewAddress); // driver.findElement(viewAddress).click();

		// return new MyAddressPage(driver);
	}

	public void clickOnOrderHistory() {
		clickOnElement(orderHistory); // driver.findElement(orderHistory).click();

	}

	public boolean isUserNameDisplayed() {
		return isElementDisplayed(userName); // return driver.findElement(userName).isDisplayed();

	}

	public boolean isUserNameCorrect(String expectedName) {
		return getUserName().equals(expectedName); // return driver.findElement(userName).isDisplayed();

	}

	public String getCurrentPageURL() {
		return getCurrentURL();

		// return driver.getCurrentUrl();
	}

	public String getCountryName() {
		return getTextFromElement(country); // return driver.findElement(country).getText();

	}

}
