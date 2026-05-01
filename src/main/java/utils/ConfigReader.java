package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	// Defining Constructor.

	public ConfigReader() {

		try {

			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fis);

		}

		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config file");
		}

	}
	
	// Methods.

	public String getURL() {
		return prop.getProperty("url");
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

}
