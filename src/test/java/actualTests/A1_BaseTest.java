package actualTests;

import java.lang.reflect.Method;
//import java.time.Duration;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import components.A1_HeaderComponent;
import utils.ConfigReader;
import utils.DriverManager;
import utils.ScreenshotUtil;
import utils.reports.ExtentManager;

public class A1_BaseTest {

	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	
	

	@BeforeSuite(alwaysRun = true)
	public void setUpReport() {
		extent = ExtentManager.getInstance();
	}
	
	

	@BeforeMethod(alwaysRun = true)
	public void startTest(Method method) {

		// 🔹 Start report test

		test = extent.createTest(method.getName());

		System.out.println("BEFORE METHOD EXECUTED");
		System.out.println("====== BEFORE METHOD EXECUTED ======");
		System.out.println("Setup is running...");
		// System.out.println("Driver from DriverManager: " + driver);

		ConfigReader config = new ConfigReader();

		//driver = DriverManager.getDriver(config.getBrowser());
		
		
		
		//-----------------Jenkins Reading Properties------------
		
		// 1. BROWSER READING.
		
		
		String browser = System.getProperty("browser");
		
		if(browser == null || browser.isEmpty())
		{	
			browser = config.getBrowser();
		}
		
		System.out.println("Browser from Jenkins: "+browser);
		
		
		// 2. ENVIRONMENT READING.
		
		String env = System.getProperty("env");
		
		if(env == null || env.isEmpty())
		{
			env="qa";
		}
		
		System.out.println("Environment: "+env);
		
		
		
		// 3. LAUNCH BROWSER
		
		driver = DriverManager.getDriver(browser);
		driver.manage().window().maximize();
		
		
		// 4. OPEN URL BASED ON ENVIRONMENT.
		
		
		if(env.equalsIgnoreCase("qa"))
		{
			driver.get(config.getURL());
			System.out.println("Opened QA");
		}
		
		else if(env.equalsIgnoreCase("uat"))
		{
			driver.get(config.getURL());
			System.out.println("Opened UAT");
		}
		
		else if(env.equalsIgnoreCase("prod"))
		{
			driver.get(config.getURL());
			System.out.println("Opened Prod");
		}
		
		else
			
		{
			System.out.println("Invalid ENV. Opening default QA URL");
			driver.get(config.getURL());
		}

	}

	@AfterSuite(alwaysRun = true)
	public void tearDownReport() {
		extent.flush();

	}


	//@AfterMethod(enabled = false)
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		
		// 🔹 Report handling
		
				if (result.getStatus() == ITestResult.FAILURE) {
					
					String path =   ScreenshotUtil.captureScreensShot(driver, result.getName());

					System.out.println("Test failed: " + result.getName());
					test.fail(result.getThrowable());
					test.addScreenCaptureFromPath(path);
				}

				else if (result.getStatus() == ITestResult.SUCCESS) {

					test.pass(result.getName()+" Passed ");
					test.pass("Test Passed");
				} else {
					test.skip("Test Skipped");
				}

		
		// 🔹 Driver cleanup
		try {
			if (driver != null) {

				A1_HeaderComponent header = new A1_HeaderComponent(driver);

				if (header.isLogoutPresent()) {
					System.out.println("Logout found. Clicking logout...");
					Thread.sleep(1000);
					header.clickOnLogOut();
				} else {
					System.out.println("\n Logout not found, no problem but Quitting the Browser..");
					Thread.sleep(1000);
				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
	
}

//----------------------------- Add later -----------------------------

/*
 * driver = new ChromeDriver(); //driver= new FirefoxDriver();
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * 
 */
// driver.get("https://glenindia.com/");
// driver.get("https://glenindia.com/collections/chimneys/products/auto-clean-curved-glass-filter-less-kitchen-chimney-with-motion-sensor-60-76-90cm-1200-m3-h-6058-bl-auto-clean?variant=42993411621040");
// driver.get("https://glenindia.com/collections/chimneys/products/glen-auto-clean-chimney-6060-bl-ac-60-90cm-with-motion-sensor-airflow-1200-m3-hr");
// driver.get("https://glenindia.com/checkouts/cn/hWNAvVmPzBDWlQRbXBry6DAq/en-in?_r=AQABsjBKOjK1oeBxiGEquWNBJSoHjC76TCnVLc8cE8mJ");
