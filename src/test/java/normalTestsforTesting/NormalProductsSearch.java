package normalTestsforTesting;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NormalProductsSearch {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://glenindia.com/");
		
		// defining hashset to add names 
		
		Set<String> allProductNames = new HashSet<String>();
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("chimney");
		Thread.sleep(1000);
		//  List<WebElement> prodIn1stPage = driver.findElements(By.xpath("//div[@class='st-products']/div[@class='st-col-md-4 st-product']"));
		//  System.out.println(prodIn1stPage.size());
		  
		  List<WebElement> prodNamesIn1stPage  =  driver.findElements(By.xpath("//div[@class='st-ProductItem-Info']/a"));
		  System.out.println("Items displaying in 1st Page : --> "+prodNamesIn1stPage.size());
		 
		  /*
		  for(int i=0; i<prodNamesIn1stPage.size();i++)
		  {
			  String abc = prodNamesIn1stPage.get(i).getText();
			//  System.out.println(abc);
			  allProductNames.add(abc);
			  
		  }   */
		  
		  for(WebElement d : prodNamesIn1stPage)
		  {
			  String abc = d.getText();
			  System.out.println(abc);
			  allProductNames.add(abc);
		  }
		  
		  System.out.println("Hashset Size after added 1st page Items ---> "+allProductNames.size()); // after adding 1st page names.
		  
		  System.out.println("*********************************");
		  
		  System.out.println("Now clicking on Page 2");
		  
		  Thread.sleep(1000);
		//  driver.findElement(By.xpath("//div[@class='u-popup-main']//div[@class='u-popup-header']//span[@class='icon-cross'][1]")).click();
		  
		 WebElement page2 =  driver.findElement(By.xpath("//ul[@class='pagination']//li[2]"));
		 
		// WebElement letter = driver.findElement(By.xpath("//div[@class='pxs-newsletter-content']//div[@class='pxs-newsletter-header']//h2"));
		
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollBy(0, 700000);");
		 
		 Thread.sleep(1000);
		 JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		 js1.executeScript("window.scrollBy(0, 1800);");
		 
		 Thread.sleep(1000); 
		 
		 page2.click();
		 
		  Thread.sleep(3000);
		  
		  List<WebElement> prodNamesIn2ndPage  =  driver.findElements(By.xpath("//div[@class='st-ProductItem-Info']/a"));
		  System.out.println("Items displaying in 2nd Page : --> "+prodNamesIn2ndPage.size());
		  
		  for(WebElement d : prodNamesIn2ndPage)
		  {
			  String abc = d.getText();
			  System.out.println(abc);
			  allProductNames.add(abc);
		  }
		  
		  System.out.println("Hashset Size after added 2nd page Items ---> "+allProductNames.size()); // after adding 1st page names.
		  
		  
		  
		  List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		  System.out.println("Total iframes on page: " + iframes.size());
		  
		  
		  
		  /*
		  System.out.println("*********************************");
		  
		  System.out.println("Now clicking on Page 3");
		  
		  Thread.sleep(2000);
		//  driver.findElement(By.xpath("//div[@class='u-popup-main']//div[@class='u-popup-header']//span[@class='icon-cross'][1]")).click();
		  
		 WebElement page3 =  driver.findElement(By.xpath("//ul[@class='pagination']//li[3]"));
		 
		// WebElement letter = driver.findElement(By.xpath("//div[@class='pxs-newsletter-content']//div[@class='pxs-newsletter-header']//h2"));
		
		 JavascriptExecutor js2 = (JavascriptExecutor) driver; 
		 js2.executeScript("window.scrollBy(0, 8000);");
		 
		 Thread.sleep(1000);
		 JavascriptExecutor js3 = (JavascriptExecutor) driver; 
		// js3.executeScript("window.scrollBy(0, 1800);");
		 
		 Thread.sleep(1000); 
		 
		 page3.click();
		 
		  Thread.sleep(3000);
		  
		  List<WebElement> prodNamesIn3rdPage  =  driver.findElements(By.xpath("//div[@class='st-ProductItem-Info']/a"));
		  System.out.println("Items displaying in 3rd Page : --> "+prodNamesIn3rdPage.size());
		  
		  for(WebElement d : prodNamesIn3rdPage)
		  {
			  String abc = d.getText();
			  System.out.println(abc);
			  allProductNames.add(abc);
		  }
		  
		  System.out.println("Hashset Size after added 3rd page Items ---> "+allProductNames.size()); // after adding 1st page names.
		  
		  
		  
		  */
		  
		  
		  
		  
		  
		  
		  
		  

	}

}
