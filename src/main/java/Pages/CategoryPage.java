package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Category page class which is used to initialize the webelements of category and methods to perform actions on category
 * page
 */
public class CategoryPage extends BasePage{

	public CategoryPage(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//android.widget.TextView)[1]")
	private WebElement categoryText;
	
	@FindBy(id="com.solodroid.solomerce:id/category_name")
	private List<WebElement> catogoriesList;
	
	@FindBy(id="com.solodroid.solomerce:id/product_name")
	private List<WebElement> productNames;
	
	@FindBy(id="com.solodroid.solomerce:id/product_price")
	private List<WebElement> productPrices;
	
	/**
	 * Method to get the category text
	 * 
	 * @return categorytext
	 */
	public String getCategoryText() {
		String categorytext = null;
		if(driver instanceof AndroidDriver) {
			categorytext = categoryText.getText();
		}
		return categorytext;
	}
	
	/**
	 * Method to get the product names
	 */
	public void getCategoryList() {
		if(driver instanceof AndroidDriver) {
			for(WebElement element:  catogoriesList) {
				System.out.println(element.getText());
			}
		}
	}
	

}
