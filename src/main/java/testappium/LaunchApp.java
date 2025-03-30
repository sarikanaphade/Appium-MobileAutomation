package testappium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriver driver;
		UiAutomator2Options uio = new UiAutomator2Options();
		uio.setApp("/Users/shree/eclipse-workspace-2024-12AppiumAutomation/Applicatiion/Solodroid_E-CommerceApp Demo_3.2.0.apk");
		
		uio.setDeviceName("adb-RZ8T91LPQNK-Nkxw0N._adb-tls-connect._tcp");
		uio.setPlatformName("Android");
		uio.setPlatformVersion("14");
		uio.setAutomationName("UiAutomator2");
		
		URL url = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(url, uio);
		System.out.println("App is launched");
		
		Thread.sleep(8000);
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.solodroid.solomerce:id/product_name\" and @text=\"Samsung Galaxy S10 - Black\"]")).click();
		
		WebElement el = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.solodroid.solomerce:id/product_name' and @text='Samsung Galaxy S10 - Black']"));
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", ((RemoteWebElement)el).getId(),"duration", 20000));
		
	}
	
	

}
