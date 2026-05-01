package deleteTests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import components.A1_HeaderComponent;

import webPages.A2_LoginPage;
import webPages.A3_MyAccountPage;

public class LoginTest {

	WebDriver driver;
	A3_MyAccountPage myAccountPage;

	String expectedEmail = "vinaybhaskar2000@yahoo.com";
	String username = "vinaybhaskar2000@yahoo.com";
	String password = "Book@123";



	@BeforeMethod
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://glenindia.com/");

	}

	public A3_MyAccountPage login() {
		A2_LoginPage loginPage = new A2_LoginPage(driver);
		loginPage = new A2_LoginPage(driver);
		return loginPage.loginWithCredentials(username, password);

	}

	@Test(enabled = true)
	void validLoginTest() {
		myAccountPage = login();
		Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		// Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		Assert.assertTrue(myAccountPage.isEmailCorrect(expectedEmail));

	}

	@Test(enabled = true)
	void verifyLoginMyAccountDetails() {

		A2_LoginPage loginpage = new A2_LoginPage(driver);

		myAccountPage = loginpage.loginWithCredentials(username, password);

		Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		Assert.assertTrue(myAccountPage.isEmailCorrect(expectedEmail));
		Assert.assertTrue(myAccountPage.getCountryName().contains("India"));
		Assert.assertTrue(myAccountPage.getCurrentPageURL().contains("account"));

		String userName = myAccountPage.getUserName();
		System.out.println("User Name is : " + userName);

		String emailId = myAccountPage.getEmailId();
		System.out.println("User EMail Id is : " + emailId);

		String urlAfterLogin = myAccountPage.getCurrentPageURL();
		System.out.println("URL After Login is:  : " + urlAfterLogin);

		String countryName = myAccountPage.getCountryName();
		System.out.println("Country of the User is  : " + countryName);

	}

	@AfterMethod(enabled = true)
	void tearDown() {
		if (driver != null) {
			try {
				A1_HeaderComponent header = new A1_HeaderComponent(driver);
				header.clickOnLogOut();
			} catch (Exception e) {
				// logout not available
			}

			driver.quit();
		}
	}

}
