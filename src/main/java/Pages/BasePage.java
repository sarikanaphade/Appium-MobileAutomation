package Pages;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


/**
 * Base page class which is extended by all the page classes used for webelement initialization
 */
public class BasePage {
	
	public AppiumDriver driver;

	/** BasePage constructor */
	public BasePage(AppiumDriver driver) {
        System.out.println("Init Elements");
        //logger.info("Init Elements");
        this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	
	

}
