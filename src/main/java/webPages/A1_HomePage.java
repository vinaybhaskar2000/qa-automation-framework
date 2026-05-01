package webPages;

import org.openqa.selenium.WebDriver;

import basePage.BasePage;
import components.A1_HeaderComponent;

public class A1_HomePage extends BasePage
{
	
	//WebDriver driver;
	A1_HeaderComponent header;
	
	
	public A1_HomePage(WebDriver driver)
	{
		super(driver);
		header = new A1_HeaderComponent(driver);
	}
	
	
	// getting home page title.
	
	public String getHomePageTitle()
	{
		return getPageTitle();	
	}
	
	
	
	public String getCurrentPageTitle()
	{
		return driver.getTitle();	
	}
	
	
	public String getCurrentPageURL()
	{
		return driver.getCurrentUrl();	
	}
	
	
	
	
	/*  delete this later
	public HeaderComponent getHeader()
	{
		return header;  // returning object reference.
	}
	*/
	
	public A1_HeaderComponent getHeader()
	{
		//return header;
		return new A1_HeaderComponent(driver);
	}
	
	
	public boolean isHomePageLoaded()
	{
		return driver.getTitle().contains("Home");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
