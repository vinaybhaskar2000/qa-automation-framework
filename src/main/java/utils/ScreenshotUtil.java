package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	
	
	public static String captureScreensShot(WebDriver driver,String testName)
	{
		
		String fullPath = System.getProperty("user.dir") + "/reports/" + testName + ".png";

	    String relativePath = testName + ".png";

	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    try {
	        FileUtils.copyFile(src, new File(fullPath));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return relativePath;
		
	}
	
	

}
