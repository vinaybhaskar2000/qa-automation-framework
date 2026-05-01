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


/*   This Page is having following Methods:
 * 
 * 		1. public int getProductCount();
 * 		2. public String clickOnProduct(int index);
 * 		3. public void clickProductByGlobalIndex(int targetIndex);
 * 		4. public boolean isProductGridDisplayed();
 * 		5. public boolean clickOnNextBtn();
 * 		6. public void waitFor2Seconds();
 * 
 * 
 */

public class A4_SearchResultsPage_TrendyItems extends BasePage

{
	
	WebDriverWait wait;
	WebDriver driver;
	private String selectedProductName;   // ✅ HERE
	
	By productGrid = By.xpath("//div[@class='productgrid--wrapper']");	
	By products_ProductContainer  = By.xpath("//div[@class='productitem__container']");
	
	By searchBox = By.name("st");
	By trendyItems = By.xpath("//div[@id='st-trending-searches']//ul[@class='st-trending-search-list']//li");
	By noOfProdcuts = By.xpath("//div[@data-html='productgrid-items']//div[contains(@class,'productgrid--item') and contains(@class,'imagestyle--natural')]//h2[@class='productitem--title']");
	By noofProducts1 = By.xpath("//div[contains(@class,'productgrid--item')]//div[contains(@class,'productitem--info')]//h2//a");
	
	By nextBtn = By.xpath("//li[@class='pagination--next']//a");		
//	String productNameSelected = "Chimneys";

	
	
	// Constructor
	public A4_SearchResultsPage_TrendyItems(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getSearchResultsPageTitle()
	{
		return getPageTitle();	
	}
	
	
	// Getter to get the String name
	 
	public String getSelectedProductName()
	{
		return selectedProductName;
	}
	
	
	/**
	 * This Method is used to: 
	 * Grid validation -  Check Grid is Displayed or Not, to check Products are there are not.
	 * If Grid is empty, then Products are not there.
	 * @return
	 */
	
	public boolean isProductGridDisplayed()
	{
		//return driver.findElement(productGrid).isDisplayed();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productGrid)).isDisplayed();
		
	}
	

	/** 
	 *  This Method is used to:  Get Product Count
	 * @return
	 */
	
	 public int getProductCount()
	 {
		 return driver.findElements(products_ProductContainer).size();
	 }
	
	
  //--------------------------------------------------------------------------------------------------------------
	 
	 
	 /**
	  * GOBAL INDEX CHECK
	  * This Method is used to:  Give Index  and Click the Product.
	  * @param targetIndex
	 * @return 
	 * @return 
	  */
	
	 public A5_ProductDetailsPage clickProductByGlobalIndex_Actual(int targetIndex)
	 {
		 
	//	 List<String> addItems = new ArrayList<String>();
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		int noOfProductsCounted=0; 
		
		
		while(true)
		{	
			List<WebElement> products = driver.findElements(noofProducts1);
			int noOfProductsPerPage = products.size();
			System.out.println("\nTotal Products in current Page : "+noOfProductsPerPage);
			System.out.println("Total Products counted so far: " + noOfProductsCounted);
			/*
			 * 👉 Helps you see:
					How many items in current page
					How many already counted
			 */
			
			int totalProductsCountedTillNow = noOfProductsCounted+noOfProductsPerPage;
			System.out.println("Total Products Counted Till Now: ---> "+totalProductsCountedTillNow);
			
			// ✅ Check if target product is in this page
			
			// ✅ Check if target product is in this page
	        if (targetIndex >= noOfProductsCounted &&
	        		targetIndex < noOfProductsCounted + noOfProductsPerPage) 
	        {

	            int indexInCurrentPage = targetIndex - noOfProductsCounted;

	            WebElement element = products.get(indexInCurrentPage);

	            // Scroll to element
	         //   ((JavascriptExecutor) driver)
	            //    .executeScript("arguments[0].scrollIntoView(true);", element);
	            
	            
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	  		  
	            waitFor2Seconds();
	            
	            // ✅ CAPTURE NAME BEFORE CLICK
	            selectedProductName  = element.getText();
	 		  
	         //   System.out.println("\nProduct Name Clicked: -->"+element.getText());
	            js.executeScript("arguments[0].click();", element);
	 		  

	         //   element.click();

	            System.out.println("✅ Product clicked at index: " + targetIndex);
	            
	         // ✅ return next page
	            return new A5_ProductDetailsPage(driver);
	            
	        }

			
			
			
	        // ❌ Not in this page → move to next
		      //  noOfProductsCounted += noOfProductsPerPage;
		        noOfProductsCounted = noOfProductsCounted+noOfProductsPerPage;
		        
		     // 3B Check for Next button
		     // Try to go next page
		        boolean nextBtnIsDisplay = clickOnNextBtn();
		        
		        
		        
		        /*  --- DELETE THIS LATER
		        
		        if (!nextBtnIsDisplay) {
		            // Friendly message if index is out of range
		            System.out.println("❌ Product index " + targetIndex +
		                " not found. Only " + noOfProductsCounted + " products available.");
		            return;  // exit gracefully
		            
		           */ 
		            
		            if (!nextBtnIsDisplay) {
		            	
		            	throw new RuntimeException(
		    				    "❌ Product index " + targetIndex +
		    				    " not found. Total products available: " + noOfProductsCounted
		    				);
		            	
		            	
		            }
		            
		            
		        }
				
			
			}
			
			/*
			throw new RuntimeException(
				    "❌ Product index " + targetProductIndex +
				    " not found. Total products available: " + noOfProductsCounted
				);
			*/
			
			/*
			throw new RuntimeException(
				    "❌ Invalid Index: " + targetProductIndex +
				    ". Only " + noOfProductsCounted + " products available."
				);
			*/	
		
		

	 
 //-----------------------------------------------------------------------------------------------------------	 
	 
	 /**
	  * GOBAL INDEX CHECK
	  * This Method is used to:  Give Index  and Click the Product.
	  * @param targetIndex
	 * @return 
	  */
	
	 public String clickProductByGlobalIndex_1_JustReturnString(int targetIndex)
	 {
		 
	//	 List<String> addItems = new ArrayList<String>();
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		int noOfProductsCounted=0; 
		
		while(true)
		{	
			List<WebElement> products = driver.findElements(noofProducts1);
			int noOfProductsPerPage = products.size();
			System.out.println("\nTotal Products in current Page : "+noOfProductsPerPage);
			System.out.println("Total Products counted so far: " + noOfProductsCounted);
			/*
			 * 👉 Helps you see:
					How many items in current page
					How many already counted
			 */
			
			int totalProductsCountedTillNow = noOfProductsCounted+noOfProductsPerPage;
			System.out.println("Total Products Counted Till Now: ---> "+totalProductsCountedTillNow);
			
			// ✅ Check if target product is in this page
			
			// ✅ Check if target product is in this page
	        if (targetIndex >= noOfProductsCounted &&
	        		targetIndex < noOfProductsCounted + noOfProductsPerPage) 
	        {

	            int indexInCurrentPage = targetIndex - noOfProductsCounted;

	            WebElement element = products.get(indexInCurrentPage);

	            // Scroll to element
	         //   ((JavascriptExecutor) driver)
	            //    .executeScript("arguments[0].scrollIntoView(true);", element);
	            
	            
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	  		  
	            waitFor2Seconds();
	            
	            // ✅ CAPTURE NAME BEFORE CLICK
	            String productName = element.getText();
	 		  
	         //   System.out.println("\nProduct Name Clicked: -->"+element.getText());
	            js.executeScript("arguments[0].click();", element);
	 		  

	         //   element.click();

	            System.out.println("✅ Product clicked at index: " + targetIndex);
	            return productName;
	        }

			
			
			
	        // ❌ Not in this page → move to next
		      //  noOfProductsCounted += noOfProductsPerPage;
		        noOfProductsCounted = noOfProductsCounted+noOfProductsPerPage;
		        
		     // 3B Check for Next button
		     // Try to go next page
		        boolean nextBtnIsDisplay = clickOnNextBtn();

		        if (!nextBtnIsDisplay) {
		            // Friendly message if index is out of range
		            System.out.println("❌ Product index " + targetIndex +
		                " not found. Only " + noOfProductsCounted + " products available.");
		            return null;  // exit gracefully
		        }
				
			
			}
			
			/*
			throw new RuntimeException(
				    "❌ Product index " + targetProductIndex +
				    " not found. Total products available: " + noOfProductsCounted
				);
			*/
			
			/*
			throw new RuntimeException(
				    "❌ Invalid Index: " + targetProductIndex +
				    ". Only " + noOfProductsCounted + " products available."
				);
			*/	
		}
		
		 

	 /**
	  * This Method is used to: Click on the Index given in the Page and 
	  * which is returns the Name of that Product.
	  * @param index
	  * @return
	  */
	
		public String clickOnProduct_InSinglePage(int index)  {
			
			// hard coded xpath
			//	WebElement ele1 = driver.findElement(By.xpath("//div[@class='st-products']/div[10]//a"));
			

			
		//	WebElement ele = driver.findElement(By.xpath("//div[@class='st-products']/div[" + index + "]//a"));
			 WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'productgrid--item')]["+index+"]//div[contains(@class,'productitem--info')]//h2//a"));
			 String nameOfTheProduct =  ele.getText();

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scroll to element (center of screen)
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);

			// Small wait for UI adjustment
			wait.until(ExpectedConditions.visibilityOf(ele));
			
			
			// Wait until visible
	//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
			wait.until(ExpectedConditions.visibilityOf(ele));
			// Use JS click (bypasses interception)
			js.executeScript("arguments[0].click();", ele);
			
			System.out.println("Clicked on "+index+" Product");

			return nameOfTheProduct;
			
			
		}
		
		
		//  -------------------------PRIVATE METHODS--------------------------//
	 
		private boolean clickOnNextBtn()
		{
			
			  List<WebElement> nextBtnList  = driver.findElements(By.xpath("//li[@class='pagination--next']//a"));
			//  System.out.println("\nIf the The size of Next button is --> 1 --> then ---> Next button is displaying"
			  	//	+ "\nIf the The size of Next button is --> 0 --> then ---> Next button is not displaying, The current status of the Next button is : "+nextBtnList.size());  //1
			   
			//  boolean nextBtnSize = nextBtnList.size() == 0;
			 // System.out.println("Here we are checking the size of Next Btn, if it equal to 0 --> return true, otherwise false.  The current status of the Next button is :"+nextBtnSize);
			  
			//  boolean isNxtBtnDisplayed =  nextBtnList.get(0).isDisplayed();
			//  System.out.println("Because Next button is displying hence displaying true: -->"+isNxtBtnDisplayed);
			  
			  if (nextBtnList.isEmpty() || ! nextBtnList.get(0).isDisplayed() ) 
			  {
				System.out.println("\nReached Last Page");
				 return false;
				//break;
			  }
			  
			  //3C SCROLL AND CLICK NEXT
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			//  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			  
			  WebElement nextBtn = nextBtnList.get(0);
			  wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
			  js.executeScript("arguments[0].scrollIntoView({block:'center'});", nextBtn);
			  
			 
			  waitFor2Seconds();
			  
			  js.executeScript("arguments[0].click();", nextBtn);
			  
			  return true; // ✅ next page exists
		}
		
	 
		 
		 private void waitFor2Seconds()
			{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		 
	// -------------- WITH THE HELP OF CHAT GPT WE UPDATED THE METHODS -----------------------// 
		 
		 
		 
		 /*
		 private boolean clickOnNextBtn()
		 {
		     List<WebElement> nextBtnList = driver.findElements(nextBtn);

		     if (nextBtnList.isEmpty() || !nextBtnList.get(0).isDisplayed()) {
		         System.out.println("\nReached Last Page");
		         return false;
		     }

		     WebElement next = nextBtnList.get(0);

		     wait.until(ExpectedConditions.elementToBeClickable(next));

		     ((JavascriptExecutor) driver)
		         .executeScript("arguments[0].scrollIntoView({block:'center'});", next);

		     next.click();

		     return true;
		 }
		 
		 */
		 
		 
		 
		 
		 /* 	By using ChatGPT, we are reWritten the Logic for the Method:
		 		public String clickOnProduct_InSinglePage(int index)
		  */
		 
		
		 /*
		 public String clickProductByIndexInPage(int index)
		 {
		     List<WebElement> products = driver.findElements(noofProducts1);

		     WebElement ele = products.get(index);

		     String name = ele.getText();

		     wait.until(ExpectedConditions.visibilityOf(ele));

		     ((JavascriptExecutor) driver)
		         .executeScript("arguments[0].scrollIntoView({block:'center'});", ele);

		     ele.click();

		     return name;
		 }
		 
		 */
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
}
