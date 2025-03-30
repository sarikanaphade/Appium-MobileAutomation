package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import Constants.FileConstants;
import io.appium.java_client.AppiumDriver;
import java.io.FileInputStream;

/**
 * Utility class for Appium related operations
 */
public class AppiumUtils {

	/**
	 * Method to capture screenshot
	 * 
	 * @param driver
	 * @return saveFile
     */
	public String captureScreenshot(AppiumDriver driver) {
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		String saveFile = FileConstants.SCREENSHOT_PATH;
		try {
			FileUtils.copyFile(screenshot, new File(saveFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveFile;
	}
	
	/**
	 * Method to get the timestamp
	 * 
	 * @return timestamp
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}
	
	/**
	 * Method to read the properties file
	 * 
	 * @return prop
	 */
	public static Properties readPropertiesFile() {
		String fileName = FileConstants.TESTDATA_PATH;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
