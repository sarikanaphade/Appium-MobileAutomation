package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AppiumUtils;
import Utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(id="com.solodroid.solomerce:id/clear")
	private WebElement clearButton;
	
	@FindBy(id="com.solodroid.solomerce:id/btn_checkout")
	private WebElement checkoutButton;
	
	@FindBy(id="android:id/message")
	private WebElement confirmationMessage;
	
	@FindBy(id="android:id/button1")
	private WebElement yesButton;
	
	@FindBy(id="android:id/button2")
	private WebElement noButton;
	
	@FindBy(id="com.solodroid.solomerce:id/product_name")
	private WebElement productName;
	
	@FindBy(id="com.solodroid.solomerce:id/product_price")
	private WebElement productPrice;
	
    @FindBy(id="com.solodroid.solomerce:id/txt_total_price")
	private WebElement totalPrice;
	
    @FindBy(id="com.solodroid.solomerce:id/edt_name")
    private WebElement name;
    
    @FindBy(id="com.solodroid.solomerce:id/edt_email")
    private WebElement email;
    
    @FindBy(id="com.solodroid.solomerce:id/edt_phone")
    private WebElement phone;
    
    @FindBy(id="com.solodroid.solomerce:id/edt_address")
    private WebElement address;
    
    @FindBy(id="com.solodroid.solomerce:id/edt_order_list")
    private WebElement orderList;
    
    @FindBy(id="com.solodroid.solomerce:id/edt_comment")
    private WebElement comment;
    
    @FindBy(id="com.solodroid.solomerce:id/btn_submit_order")
    private WebElement processCheckout;
    
    @FindBy(id="com.solodroid.solomerce:id/spinner")
    private WebElement shippingDropdown;
    
    @FindBy(className="android.widget.CheckedTextView")
    private List<WebElement> shippingOptions;
    
    @FindBy(id="android:id/alertTitle")
    private WebElement alertTitle;
    
    public void clickClearButton() {
    	if(driver instanceof AndroidDriver) {
    	    clearButton.click();
    	}
    }
    
	public void clickCheckoutButton() {
		if (driver instanceof AndroidDriver) {
			checkoutButton.click();
		}
	}
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}
	
	public void clickYesButton() {
		yesButton.click();
	}
	
	public void clickNoButton() {
		noButton.click();
	}
	
	public String getProductName() {
		return productName.getText();
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public String getTotalPrice() {
		return totalPrice.getText();
	}
	
	public void enterName(String nameStr) {
		name.sendKeys(nameStr);
	}
	
	public void enterEmail(String emailStr) {
		email.sendKeys(emailStr);
	}
	
	public void enterPhone(String phoneStr) {
		phone.sendKeys(phoneStr);
	}
	
	public void enterAddress(String addressStr) {
		address.sendKeys(addressStr);
	}
	
	public void enterOrderList(String orderListStr) {
		orderList.sendKeys(orderListStr);
	}
	
	public void enterComment(String commentStr) {
		comment.sendKeys(commentStr);
	}
	
	public void clickProcessCheckout() {
		processCheckout.click();
	}
	
	public void selectShippingOption(String option) {
		shippingDropdown.click();
		WaitUtils.waitForElement(driver, shippingOptions.get(0));
		for (WebElement element : shippingOptions) {
			if (element.getText().equalsIgnoreCase(option)) {
				element.click();
				break;
			}
		}
	}
	
	public String getAlertTitle() {
		return alertTitle.getText();
	}
	
	public void clickAlertButton(String button) {
		if (button.equalsIgnoreCase("ok")) {
			yesButton.click();
		} else {
			noButton.click();
		}
	}
	
	public void clickAlertButton() {
		yesButton.click();
	}
		
	public boolean verify_ProductDetails() {
		boolean flag=false;
		if (driver instanceof AndroidDriver) {
			WaitUtils.waitForElement(driver, productName);
			System.out.println("Product name: " + getProductName());
			System.out.println("Product price: " + getProductPrice());
			System.out.println("Total price: " + getTotalPrice());
			System.out.println("Product name: " + AppiumUtils.readPropertiesFile().getProperty("product.name"));
			System.out.println("Product price: " + AppiumUtils.readPropertiesFile().getProperty("product.price"));
			System.out.println("Total price: " + AppiumUtils.readPropertiesFile().getProperty("product.total"));
			
			//String productPrice = getProductPrice();
			//remove USD from pricecont convert to int
//	        String[] price = AppiumUtils.readPropertiesFile().getProperty("product.quantity").split(" ");
//	        int p = Integer.parseInt(price[0]) * Integer.parseInt(AppiumUtils.readPropertiesFile().getProperty("product.quantity"));
//	        String  pp = String.valueOf(p) + " "+ price[1];
//	        System.out.println("Product new Price: "+pp);
			
            if (getProductName().equalsIgnoreCase(AppiumUtils.readPropertiesFile().getProperty("product.name")) && getProductPrice().equalsIgnoreCase(AppiumUtils.readPropertiesFile().getProperty("product.calc.price"))) {
                System.out.println("Product details are displayed in cart");
            	flag = true;
            }
			if (getTotalPrice().equalsIgnoreCase(AppiumUtils.readPropertiesFile().getProperty("product.total"))) {
				System.out.println("Total price is correct");
				flag = true;
			}
        }
        return flag;
    }
	
	public boolean verify_confirmationDetails() {
		boolean flag=false;
        if (driver instanceof AndroidDriver) {
        	WaitUtils.waitForElement(driver, yesButton);
            if (getAlertTitle().equalsIgnoreCase(AppiumUtils.readPropertiesFile().getProperty("shipping.alertTitle"))) {
            	clickYesButton();
                flag = true;
            }
        }
        return flag;
    }
	
	public boolean verify_shippingOptions() {
		boolean flag=false;
        if (driver instanceof AndroidDriver) {
        	WaitUtils.waitForElement(driver, name);
        	enterName(AppiumUtils.readPropertiesFile().getProperty("shipping.name"));
        	enterEmail(AppiumUtils.readPropertiesFile().getProperty("shipping.email"));
        	enterPhone(AppiumUtils.readPropertiesFile().getProperty("shipping.phone"));
        	enterAddress(AppiumUtils.readPropertiesFile().getProperty("shipping.address"));
        	
            selectShippingOption(AppiumUtils.readPropertiesFile().getProperty("shipping.shippingOption"));
            clickProcessCheckout();
            WaitUtils.waitForElement(driver, yesButton);
            if (getConfirmationMessage().equalsIgnoreCase(AppiumUtils.readPropertiesFile().getProperty("shipping.process.checkout"))) {
            	clickAlertButton();
                flag = true;
            }
        }
        return flag;
    }
	
}
