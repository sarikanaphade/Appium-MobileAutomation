package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AppiumUtils;
import Utils.TouchUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BasePage {
	
	public HomePage(AppiumDriver driver) {
		super(driver);
	}
	AppiumUtils au = new AppiumUtils();
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add']")
//	@AndroidFindBy(id = "com.example.android.contactmanager:id/addContactButton")
//	private WebElement addContactButton;
//	
//	@iOSXCUITFindBy(accessibility = "Recent")
//	@AndroidFindBy(accessibility = "Recent")
//	private WebElement recentButton;
//	
//	@iOSXCUITFindBy(accessibility = "Category")
//	@AndroidFindBy(accessibility = "Category")
//	private WebElement categoryButton;
//	
//	@iOSXCUITFindBy(accessibility = "Help")
//	@AndroidFindBy(accessibility = "Help")
//	private WebElement helpButton;
//	
//	@iOSXCUITFindBy(accessibility = "Profile")
//	@AndroidFindBy(accessibility = "Profile")
//	private WebElement profileButton;
	
	
	@FindBy(id = "Recent")
	private WebElement recentButton;
	
	@FindBy(xpath="(//android.widget.ImageView[@resource-id='com.solodroid.solomerce:id/icon'])[2]")
	private WebElement categoryButton;
	
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.solodroid.solomerce:id/icon'])[3]")
	public WebElement helpButton;
	
	@FindBy(id = "Profile")
	public WebElement profileButton;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.solodroid.solomerce:id/product_name' and @text='Samsung Galaxy S10 - Black']")
	public WebElement firstTile;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.solodroid.solomerce:id/product_name']")
	public List<WebElement> product;
	
	@FindBy(id="com.solodroid.solomerce:id/search")
	public WebElement search;
	
	@FindBy(id="com.solodroid.solomerce:id/cart")
	public WebElement cart;
		
	public void clickAddContactButton() {
		//addContactButton.click();
		System.out.println("App is launched");
	}
	
	public void clickRecentButton() {
		if (driver instanceof AndroidDriver) {
			recentButton.click();
		}
	}
	
	public void clickSearchButton() {
		if (driver instanceof AndroidDriver) {
			search.click();
		}
	}
	
	public CategoryPage clickCategoryButton() {
		if (driver instanceof AndroidDriver) {
			categoryButton.click();
		}
		return new CategoryPage(driver);
	}
	
	public HelpPage clickHelpButton() {
		try {
			if (driver instanceof AndroidDriver) {
				helpButton.click();
			}
		}catch(NoSuchElementException e) {
			au.captureScreenshot(driver);
		}
		return new HelpPage(driver);
	}
	
	public void clickProfileButton() {
		if (driver instanceof AndroidDriver) {
			profileButton.click();
		}
	}
	
	public ProductPage clickOnFirstTile() {
		System.out.println("clicking on first tile");
		if (driver instanceof AndroidDriver) {
		System.out.println("clicking on first tile");
		//firstTile.click();
		WebElement el = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.solodroid.solomerce:id/product_name' and @text='Samsung Galaxy S10 - Black']"));
		TouchUtils.LongPress(driver,el);
		System.out.println("clicking on first tile");
	}
		return new ProductPage(driver);
	
	}
	
	public ProductPage clickOnProduct(String productName) {
		if (driver instanceof AndroidDriver) {
			for (WebElement element : product) {
				if (element.getText().equalsIgnoreCase(productName)) {
					element.click();
					break;
				}
			}
		}
		return new ProductPage(driver);
	}
	
	public ShoppingCartPage clickOnCart() {
		if (driver instanceof AndroidDriver) {
			cart.click();
		}
		return new ShoppingCartPage(driver);
	}
}
