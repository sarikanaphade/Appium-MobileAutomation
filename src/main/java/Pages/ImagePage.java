package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ImagePage extends BasePage{

	public ImagePage(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(id="com.solodroid.solomerce:id/image")
	private WebElement imageContainer;
	
	@FindBy(id="com.solodroid.solomerce:id/close_image")
	private WebElement closeImage;
	
	@FindBy(id="com.solodroid.solomerce:id/save_image")
	private WebElement saveImage;
	


	public WebElement getCloseImage() {
		return closeImage;
	}

	public WebElement getimageContainer() {
		return imageContainer;
	}
	
	public WebElement getSaveImage() {
		return saveImage;
	}
	
	public void clickSaveImage() {
        if (driver instanceof AndroidDriver) {
            saveImage.click();
        }
    }
	
	public void clickCloseImage() {
        if (driver instanceof AndroidDriver) {
        	closeImage.click();
        }
    }
	
	
	


}
