package Tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Utils.ReportManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * This class is the base class for all the test classes
 * 
 */
public class BaseTest {
	
	//public static AppiumDriver driver;
	public static AppiumDriver driver;
	public AppiumDriverLocalService service;
	public static ExtentReports report=null;
    public static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<ExtentTest>();
	public static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	@BeforeSuite
    public static void setUpBS() {
    	report = ReportManager.getInstance();
//		startAppiumServer();
    }
	
	 @AfterSuite
	    public void flushReport() {
	        if (report != null) {
	            report.flush();
	        }
			//service.stop();
	    }
	
	
	/**
	 * This method is used to get the driver based on the platform (Android or iOS)
	 * 
	 * @param platformName
	 */
	@SuppressWarnings("deprecation")
	public void getDriver(String platformName) {
		UiAutomator2Options capabilities = new UiAutomator2Options();
		XCUITestOptions ioscapabilities = new XCUITestOptions();
		
		if (platformName.equalsIgnoreCase("android")) {
			capabilities.setApp(System.getProperty("user.dir") + "/Applicatiion/Solodroid_E-CommerceApp Demo_3.2.0.apk");
			capabilities.setDeviceName("adb-RZ8T91LPQNK-Nkxw0N._adb-tls-connect._tcp");
			capabilities.setPlatformName("Android");
			capabilities.setPlatformVersion("14");
			capabilities.setAutomationName("UiAutomator2");
			capabilities.setUnlockType("pin");
			capabilities.setUnlockKey("1208");
		} else if (platformName.equalsIgnoreCase("ios")) {
			capabilities.setApp(System.getProperty("user.dir") + "/apps/UICatalog.app");
			capabilities.setDeviceName("iPhone 15 Pro");
			capabilities.setPlatformName("iOS");
			capabilities.setPlatformVersion("15.0");
			capabilities.setAutomationName("XCUITest");
		}
		
		if (platformName.equalsIgnoreCase("android")) {
			logger.info("Creating Android driver");
			URL url = null;
			try {
				url = new URL("http://127.0.0.1:4723");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			 driver = new AndroidDriver(url, capabilities);
		}else if (platformName.equalsIgnoreCase("ios")) {
			logger.info("Creating iOS driver");
			driver = new IOSDriver(ioscapabilities);
		}
		
		
		
		//return driver;
	}

	/**
	 * This method is used to start the Appium server
	 */
	public void startAppiumServer() {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		logger.info("Starting Appium server");
		service.start();
	}
	
	/**
	 * This method is used to stop the Appium server
	 */
	public void stopAppiumServer() {
		logger.info("Stopping Appium server");
        service.stop();
	}

}
