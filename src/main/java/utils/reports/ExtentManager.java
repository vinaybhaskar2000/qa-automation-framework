package utils.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			String path = System.getProperty("user.dir") + "/reports/index.html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Results");
			reporter.config().setDocumentTitle("Test Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "BVBhaskar");

		}

		return extent;

	}

}
