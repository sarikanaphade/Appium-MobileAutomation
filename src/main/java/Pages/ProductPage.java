package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends BasePage{

	public ProductPage(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(id="com.solodroid.solomerce:id/product_image")
	private WebElement productImage;
	
	@FindBy(id="com.solodroid.solomerce:id/btn_add_cart")
	private WebElement addCartButton;
	
	@FindBy(id="com.solodroid.solomerce:id/product_price")
	private WebElement productPrice;
	
	@FindBy(id="com.solodroid.solomerce:id/product_name")
	public WebElement productName;
	
	@FindBy(id="com.solodroid.solomerce:id/product_description")
	private WebElement productDescription;
	
	@FindBy(id="com.solodroid.solomerce:id/product_quantity")
	private WebElement productQuantity;
	
	@FindBy(id="com.solodroid.solomerce:id/share")
	private WebElement shareButton;
	
	@FindBy(id="com.solodroid.solomerce:id/userInputDialog")
	private WebElement noOfOrderInputDialog;
	
	@FindBy(id="android:id/button1")
	private WebElement addButton;
	
	@FindBy(id="android:id/button2")
	private WebElement cancelButton;
	
	
	public ImagePage clickOnProductImage() {
		if(driver instanceof AndroidDriver) {
			productImage.click();
		}
		return new ImagePage(driver);
	}

	public void clickOnAddCartButton() {
		if (driver instanceof AndroidDriver) {
			addCartButton.click();
		}
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public String getProductName() {
		return productName.getText();
	}
	
	public String getProductDescription() {
		return productDescription.getText();
	}
	
	public String getProductQuantity() {
		return productQuantity.getText();
	}
	
	public void clickOnShareButton() {
		if (driver instanceof AndroidDriver) {
			shareButton.click();
		}
	}
	
	public boolean verify_product(String product_name, String product_price) {
		if (driver instanceof AndroidDriver) {
			System.out.println("Product name: " + getProductName());
			System.out.println("Product price: " + getProductPrice());
			if (getProductName().equalsIgnoreCase(product_name) && getProductPrice().equalsIgnoreCase(product_price)) {
				return true;
            }else{
            	System.out.println("Product name is not matching");
            }
        }
        return false;
    }
	
	public boolean verify_productAddToCart(String quantity) {
		if (driver instanceof AndroidDriver) {
			clickOnAddCartButton();
			WaitUtils.waitForElement(driver, noOfOrderInputDialog);
			if (noOfOrderInputDialog.isDisplayed()) {
				noOfOrderInputDialog.sendKeys(quantity);
				addButton.click();
				return true;
			}
		}
		return false;
	}
}
