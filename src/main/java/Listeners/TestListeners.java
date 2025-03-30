package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import Tests.BaseTest;
import Utils.AppiumUtils;
import io.appium.java_client.AppiumDriver;

/**
 * This class is used to implement the ITestListener interface for the test
 * listeners
 * 
 */
public class TestListeners extends AppiumUtils implements ITestListener{
	AppiumDriver driver;
	
	// This method is used to log the test pass status
	public void onTestSuccess(ITestResult result) {
		BaseTest.threadLocalTest.get().pass("Test : "+ result.getName()+" passed!");
	}
	
	// This method is used to log the test start status
	public void onTestStart(ITestResult result) {
        ExtentTest test = BaseTest.report.createTest(result.getName());
        BaseTest.threadLocalTest.set(test);
    }
	
	// This method is used to log the test failure status and capture the screenshot
	public void onTestFailure(ITestResult result) {
		BaseTest.threadLocalTest.get().fail("Test : "+ result.getName()+" failed!");
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		BaseTest.threadLocalTest.get().addScreenCaptureFromPath(captureScreenshot(driver),result.getName());
	}
	
    // This method is used to log the test skipped status
	public void onTestSkipped(ITestResult result) {
		BaseTest.threadLocalTest.get().skip("Test skipped: " + result.getName());
    }

}
