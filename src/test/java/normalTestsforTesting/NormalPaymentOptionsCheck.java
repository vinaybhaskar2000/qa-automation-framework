package normalTestsforTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NormalPaymentOptionsCheck {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://glenindia.com/checkouts/cn/hWNAdsYx6w08ARzFSglsIezk/en-in?_r=AQABKr6RYKlzW6UfPVjkSrrRn27qu6CqxluqV9G8QSvvwLc");
	
		List<WebElement> options = driver.findElements(By.xpath("(//div[contains(@class,'_1u2aa6m3')])[position() <= 5]"));
		System.out.println(options.size());
		
		
		for(int i=0; i<options.size(); i++)
		{
			String f = options.get(i).getText();
			System.out.println(f);
			
			if(f.contains("Razorpay Secure"))
			{
				options.get(i).click();
			}
		}
		
		
		
		/*

	    for(WebElement option : options)
	    {
	        if(option.getText().contains("Razorpay Secure"))
	        {
	            option.click();
	            break;
	        }
	    }
		
		*/
		
		
		
		By payNowBtn = By.id("checkout-pay-button");
		
		Thread.sleep(60000);
		
		driver.findElement(payNowBtn).click();
	
	
	
	}

}
