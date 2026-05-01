package normalTestsforTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NormalLogin {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://glenindia.com/");

		
		/*
		WebElement LoginBtn = driver.findElement(By.xpath(
				"//a[@class='site-header_account-link-anchor']//span[@class='site-header_account-link-text'][1]"));
		Thread.sleep(5000);
		LoginBtn.click();

		WebElement userName = driver.findElement(By.id("customer_email"));
		WebElement password = driver.findElement(By.id("customer_password"));

		userName.sendKeys("vinaybhaskar2000@yahoo.com");
		password.sendKeys("Book@123");

		WebElement signInBtn = driver
				.findElement(By.xpath("//div[@class='form-action-row']//button[@type='submit'][1]"));
		signInBtn.click();
		
		*/
		
		WebElement searchBox = driver.findElement(By.name("st"));
		
		searchBox.sendKeys("chimney");
		Thread.sleep(2000);
		WebElement g = driver.findElement(By.xpath("//a[contains(normalize-space(),'Straight Line Kitchen Chimney Touch Sensor Baffle filters 60cm 1000 m3/h -Silver (6001 SS TS)')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", g);
		Thread.sleep(2000);
		g.click();
		
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		/*
		List<WebElement> findProd = driver.findElements(By.xpath("//div[@class='st-products']/div[@class='st-col-md-4 st-product']"));
		
		System.out.println(findProd.size());
		
		Thread.sleep(1000);
		
		searchBox.clear();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("q")).sendKeys("abcd");
		Thread.sleep(2000);
		
		WebElement g = driver.findElement(By.xpath("//h3[@class='page-heading']"));
		System.out.println(g.getText());
		
		*/
		
		
		

	}

}
