package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static void initReports() {

		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter(ConfigReader.get("reportPath"));
			spark.config().setDocumentTitle("UI Automation Results");
			spark.config().setReportName("Automation Test Results");

			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Tester", "Ravi Prasad");

			extent.setSystemInfo("Browser", ConfigReader.get("browser"));
			extent.setSystemInfo("Base URL", ConfigReader.get("baseUrl"));
			extent.setSystemInfo("OS", System.getProperty("os.name"));

		}
	}

	// start a new test
	public static ExtentTest startTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static void flushReports() {
		if (extent != null) {
			extent.flush();
		}
	}
}
