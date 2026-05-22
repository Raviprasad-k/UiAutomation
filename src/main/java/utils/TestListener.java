package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		ReportManager.startTest(result.getName());
		ReportManager.getTest().log(Status.INFO, "Test Execution Started");
		log.info("Test Started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		ReportManager.getTest().log(Status.PASS, "Test executed Sucessfully");
		log.info("Test Sucess: " + result.getName());
		String path = Screenshot.capture(driver, result.getName());
		ReportManager.getTest().addScreenCaptureFromPath(path);
	}

	public void onTestFailure(ITestResult result) {
		log.error("Test Failed: " + result.getName());
		log.error("Reason: " + result.getThrowable());
		ReportManager.getTest().log(Status.FAIL, "Test Failed.....");
		String path = Screenshot.capture(driver, result.getName());
		ReportManager.getTest().addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) {
		log.warn("Test Skipped: " + result.getName());
	}
	
	public void onStart(ITestContext context) {
		log.info("Starting Suite: " + context.getName());
	}
	public void onFinish(ITestContext context) {
		log.info("Test Finished: " + context.getName());
		ReportManager.flushReports();
	}

}
