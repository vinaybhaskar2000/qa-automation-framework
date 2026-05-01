package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basePage.BasePage;
import components.A1_HeaderComponent;

public class A2_LoginPage extends BasePage {

	

	public A2_LoginPage(WebDriver driver) {
		super(driver);
	}

	A1_HeaderComponent headerComponent;

	By userName = By.id("customer_email");
	By password = By.id("customer_password");
	By signInBtn = By.xpath("//div[@class='form-action-row']//button[@type='submit'][1]");
	
	
	

	public A3_MyAccountPage loginWithCredentials(String username1, String pwd)  {

		headerComponent = new A1_HeaderComponent(driver);
		headerComponent.clickOnLoginBtn();

		findElementAndEnterText(userName, username1); // driver.findElement(userName).sendKeys(username);
		findElementAndEnterText(password, pwd); // driver.findElement(password).sendKeys(pwd);
		clickOnElement(signInBtn); // driver.findElement(signInBtn).click();
		return new A3_MyAccountPage(driver);

		/*
		 * MyAccountPage myaccountpage = new MyAccountPage(driver); return
		 * myaccountpage;
		 */
	}

	/*
	 * DELETE THIS LATER public MyAccountPage MyAccountPageLogin(String username,
	 * String pwd) { driver.findElement(userName).sendKeys(username);
	 * driver.findElement(password).sendKeys(pwd);
	 * driver.findElement(signInBtn).click(); return new MyAccountPage(driver); }
	 * 
	 */
}
