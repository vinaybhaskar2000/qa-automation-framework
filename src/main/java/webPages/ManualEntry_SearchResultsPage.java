package webPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePage.BasePage;

public class ManualEntry_SearchResultsPage extends BasePage {


	public ManualEntry_SearchResultsPage(WebDriver driver) {
		super(driver);
	}



	private By noOfProductItems = By.xpath("//div[@class='st-products']/div[@class='st-col-md-4 st-product']");
	private By noResultsMessage = By.xpath("//h3[@class='page-heading']");
	//private By productTitles  = By.xpath("//a[contains(text(),\"Auto Clean Curved Glass Filterless Kitchen Chimney\")]");
	//private By productTitle  = By.linkText("https://glenindia.com/products/glen-90cm-1250-m3-h-curved-glass-wall-mount-designer-chimney-6071-ss-push-button-control-silver");
	//WebElement g = driver.findElement(By.xpath("//a[contains(normalize-space(),'Straight Line Kitchen Chimney Touch Sensor Baffle filters 60cm 1000 m3/h -Silver (6001 SS TS)')]"));
	private By prodNameToClick = By.xpath("//a[contains(normalize-space(),'Straight Line Kitchen Chimney Touch Sensor Baffle filters 60cm 1000 m3/h -Silver (6001 SS TS)')]");
	
	/*
	public boolean isNoRsultDisplayed()
	{
		return driver.findElements(noResultsMessage).size()>0;
	}
	
	*/
	
	public boolean isNoRsultDisplayed()
	{
		List<WebElement> elements =  driver.findElements(noResultsMessage);
		
		if (elements.size()>0) 
		{
			return elements.get(0).isDisplayed();
		}
		return false;
		
	}
	
	
	
	
	// METHOD  1 : 
	
	public A5_ProductDetailsPage selectProduct1(String productName)
	{
		boolean a = isNoRsultDisplayed();
		
		if (a) 
		{
			throw new RuntimeException(" No Results available for : "+productName);
		}
		
		List<WebElement> products =  driver.findElements(prodNameToClick);
		
		for(WebElement product: products)
		{
			boolean b =product.getText().contains(productName);
			
			if (b) 
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(prodNameToClick));
				
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(prodNameToClick));
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				product.click();
				return new A5_ProductDetailsPage(driver);
			}
		}
		throw new RuntimeException("Product not found in search results: " + productName);
		
	}
	
	
	
	/*
	// METHOD : 
	
	 public ProductDetailsPage selectProduct(String productName)
	 {
		    List<WebElement> products =  driver.findElements(productTitles);
		    
		    for(WebElement product : products)
		    {
		    	boolean b = product.getText().equalsIgnoreCase(productName);
		    	
		    	if (b) 
		    	{
		    		product.click();
		    		break;
				}
		    	
		    	
		    }
		    
		    return new ProductDetailsPage(driver);
	 }
	
	
	*/
	
	
	
	// METHOD : 1 return no of products

	public int getProductCount() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> noOfProd = driver.findElements(noOfProductItems);
		return noOfProd.size();
	}

	
	
	//  METHOD : 2  return no results message
	
	public String getNoResultsMessage()
	{
		return driver.findElement(noResultsMessage).getText();
	}
	
	
	
	//  METHOD : 3 print result
	
	public void printSearchResult()
	{
		int count = getProductCount();
		
		if (count>0) 
		{
			System.out.println(count+" Products Found...!");
		}
		
		else
		{
			System.out.println(getNoResultsMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
		

	}


