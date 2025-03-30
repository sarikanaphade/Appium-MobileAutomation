package Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HelpPage extends BasePage{

	public HelpPage(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(id="com.solodroid.solomerce:id/search_src_text")
	public WebElement searchTextBox;
	
	@FindBy(id="com.solodroid.solomerce:id/title")
	public WebElement searchResult;

	@FindBy(className="android.widget.TextView")
	public WebElement helpPaymentPage;
	
	@FindBy(xpath="(//android.widget.TextView)[1]")
	private WebElement helpText;
	
	public void helpSearch(String searchStr) throws InterruptedException {
		searchTextBox.sendKeys(searchStr);
		assertTrue(searchResult.getText().equalsIgnoreCase("Payment"),"searched page not diaplyed");
		searchResult.click();
		Thread.sleep(2000);
		assertTrue(helpPaymentPage.getText().equalsIgnoreCase("Payment"),"searched page not diaplyed");
	}
	
	public String getHelpText() {
		String helptext = null;
		if(driver instanceof AndroidDriver) {
			helptext = helpText.getText();
		}
		return helptext;
	}
	

}
