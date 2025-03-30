package Utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

//import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TouchUtils {
	
	 private static void executeGesture(AppiumDriver driver, String gesture, Map<String, Object> params) {
	        if (driver instanceof AndroidDriver) {
	            ((JavascriptExecutor) driver).executeScript("mobile: " + gesture, params);
	        }
	    }
	
	public static void swipeLeft(AppiumDriver driver) {
		Map<String, Object> swipeObject = new HashMap<>();
        swipeObject.put("direction", "left");  
        swipeObject.put("left", 100);        
        swipeObject.put("top", 500);         
        swipeObject.put("width", 800);           
        swipeObject.put("height", 500);      
        swipeObject.put("percent", 0.75);
        executeGesture(driver,"swipeGesture",swipeObject);
	}
	
	public static void swipeRight(AppiumDriver driver) {
		if(driver instanceof AndroidDriver) {
		Map<String, Object> swipeObject = new HashMap<>();
        swipeObject.put("direction", "right");  // Swipe direction: "left", "right", "up", or "down"
        swipeObject.put("left", 800);         // Start X coordinate
        swipeObject.put("top", 500);         // Start Y coordinate
        swipeObject.put("width", 100);           // End X coordinate
        swipeObject.put("height", 500);           // End Y coordinate
        swipeObject.put("percent", 0.75);
        
        // Execute swipe command
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", swipeObject);
		}
	}
	
	//scroll up and down - //scrollIntoView
	public static void scrollToElement(AppiumDriver driver,String elementText) {
		if(driver instanceof AndroidDriver) {
			String container = "new UiSelector().resourceId(\"com.solodroid.solomerce:id/recycler_view\")";
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable("+container+").scrollForward().scrollIntoView(new UiSelector().textContains(\""+elementText+"\"));"));
		}
	}
	
	//scrollIntoView
	public static void scrollToView(AppiumDriver driver,String text) {
		if(driver instanceof AndroidDriver) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""+text+"\"));"));
		}
	}
	
	public static void scrollToEndAction(AppiumDriver driver) {
		if(driver instanceof AndroidDriver) {
			Map<String, Object> scrollObject = new HashMap<>();
			scrollObject.put("direction", "down");  // Swipe direction: "left", "right", "up", or "down"
			scrollObject.put("left", 100);         // Start X coordinate
			scrollObject.put("top", 100);         // Start Y coordinate
			scrollObject.put("width", 200);           // End X coordinate
			scrollObject.put("height", 200);           // End Y coordinate
			scrollObject.put("percent", 3.0);
	        
	        Boolean canScrollMore;
	        do {
	        	canScrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", scrollObject);
	        }while(canScrollMore);
		}
	}
	
	//Longpress
	public static void LongPress(AppiumDriver driver,WebElement element) {
		
		//((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", ((RemoteWebElement)el).getId(),"duration", 20000));
		
		if(driver instanceof AndroidDriver) {
			Map<String, Object> longPressObject = new HashMap<>();
			longPressObject.put("duration", 2000);
			longPressObject.put("elementId", ((RemoteWebElement)element).getId());
			
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", longPressObject);
		}	
	}
		
	//Tap - click event
	
	//pinch zoom 
	public static void ZoomOut(AppiumDriver driver, WebElement element) {
	    if (driver instanceof AndroidDriver) {
	    	if (driver instanceof AndroidDriver) {
		        Map<String, Object> zoomInObject = new HashMap<>();
		        zoomInObject.put("elementId", ((RemoteWebElement)element).getId());
		        zoomInObject.put("percent", 0.5);
		        zoomInObject.put("speed", 10);

		        ((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", zoomInObject);
		    }
	    }
	}
	
	public static void ZoomIn(AppiumDriver driver, WebElement element) {
	    if (driver instanceof AndroidDriver) {
	        Map<String, Object> zoomInObject = new HashMap<>();
	        zoomInObject.put("elementId", ((RemoteWebElement)element).getId());
	        zoomInObject.put("percent", 0.75);
	        zoomInObject.put("speed", 10);

	        ((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", zoomInObject);
	        
	        }
	}
	
	//drag and drop
	public static void DragAndDrop(AppiumDriver driver, WebElement sourceElement, int dragLocX, int dragLocY) {
		if(driver instanceof AndroidDriver) {
			Map<String, Object> dragDropObject = new HashMap<>();
			dragDropObject.put("elementId", ((RemoteWebElement)sourceElement).getId());
			dragDropObject.put("endX", dragLocX);
			dragDropObject.put("endY",dragLocY);
			
			((JavascriptExecutor)driver).executeScript("mobile:dragGesture", dragDropObject);
		}
	}
	
	//change orientation
	public static void changeOrientation(AppiumDriver driver, String orientation) {
		if (driver instanceof AndroidDriver) {
			Map<String, Object> orientationObject = new HashMap<>();
			orientationObject.put("orientation", orientation);

			((JavascriptExecutor) driver).executeScript("mobile: setDeviceOrientation", orientationObject);
		}
	}
	
	
	//zoom - using pointer input
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
	Sequence s1 = new Sequence(finger1,1);
	
	

}

