package actualTests;

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

public class A2_LoginTest extends A1_BaseTest {


	A3_MyAccountPage myAccountPage;

	String expectedEmail = "vinaybhaskar2000@yahoo.com";
	String username = "vinaybhaskar2000@yahoo.com";
	String password = "Book@123";

//	LoginPage loginpage;

	public A3_MyAccountPage login() {
		A2_LoginPage loginPage = new A2_LoginPage(driver);
		return loginPage.loginWithCredentials(username, password);

	}

	@Test(enabled = false)
	void validLoginTest() {
		myAccountPage = login();
		Assert.assertTrue(myAccountPage.checkIsDisplayed());
		// Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		Assert.assertTrue(myAccountPage.isEmailCorrect(expectedEmail));

	}

	@Test
	void verifyLoginMyAccountDetails() {

		myAccountPage = login();

		Assert.assertTrue(myAccountPage.checkIsDisplayed());
		Assert.assertTrue(myAccountPage.isEmailCorrect(expectedEmail));
		Assert.assertTrue(myAccountPage.getCountryName().contains("India"));
		Assert.assertTrue(myAccountPage.getCurrentPageURL().contains("account"));

	
		System.out.println("User Name is : " + myAccountPage.getUserName());
		System.out.println("User EMail Id is : " + myAccountPage.getEmailId());
		System.out.println("URL After Login is:  : " + myAccountPage.getCurrentPageURL());
		System.out.println("Country of the User is  : " + myAccountPage.getCountryName());

		// Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		// Assert.assertTrue(myAccountPage.isEmailCorrect(expectedEmail));
		/*
		 * boolean displayingEmailId = myAccountPage.isEmailCorrect(expectedEmail);
		 * assertTrue(displayingEmailId);
		 */

		// Assert.assertTrue(myAccountPage.isCorrectEmailDisplaying(expectedEmail));
		//Assert.assertTrue(myAccountPage.isUserNameDisplayed());
		// Assert.assertTrue(myAccountPage.URLafterLogin().contains("account"));
		//Assert.assertTrue(urlAfterLogin.contains("account"));

	}

	

}
