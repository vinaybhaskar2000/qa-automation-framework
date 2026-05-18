package actualTests;

import org.testng.annotations.Test;

public class EnvironmentTest {
	
	@Test
	public void printEnvironment()
	{
		String environment = System.getProperty("env");
		System.out.println("Current Environment is : "+environment);
	}

}
