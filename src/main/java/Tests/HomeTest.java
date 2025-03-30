package Tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.CategoryPage;
import Pages.HelpPage;
import Pages.HomePage;
import Pages.ImagePage;
import Pages.ProductPage;
import Utils.TouchUtils;
import Utils.WaitUtils;

public class HomeTest extends BaseTest {

	@BeforeMethod
	public void setUp() {
//		startAppiumServer();
		getDriver("android");
	}
	
	@Test
	public void test() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		//Thread.sleep(8000);
		//scrollToEndAction
		//TouchUtils.scrollToEndAction(driver);
		
//		//scroll till that element
//		String eletoscrolltext="Copper Light 3 Battery Warm White - Fairy Light Battery";
//		TouchUtils.scrollToElement(driver, eletoscrolltext);
//		
//		Thread.sleep(8000);
//
//		//swipe left
//		for(int i=0;i<3;i++) {
//			TouchUtils.swipeLeft(driver);
//			Thread.sleep(3000);
//		}
		//homePage.clickOnFirstTile();
//		CategoryPage cp = homePage.clickCategoryButton();
//		assertTrue(cp.getCategoryText().equals("Category"),"Category page not disaplyed.");
//		Thread.sleep(2000);
//		cp.getCategoryList();
		
		
		//zoom in and out
//		ProductPage productPage = homePage.clickOnFirstTile();
//		Thread.sleep(3000);
//		ImagePage imagePage = productPage.clickOnProductImage();
//		Thread.sleep(6000);
//		WebElement ele = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.solodroid.solomerce:id/image\"]"));
//		TouchUtils.ZoomIn(driver,ele);
//		TouchUtils.ZoomOut(driver,ele);

		WaitUtils.waitForElement(driver, homePage.firstTile);
		HelpPage hp = homePage.clickHelpButton();
		assertTrue(hp.getHelpText().equals("Help"),"Help page not disaplyed.");
		//Thread.sleep(2000);
		WaitUtils.waitForElement(driver, hp.searchResult);
		homePage.clickSearchButton();
		hp.helpSearch("payment");
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("teardown - Quitting driver");
		driver.quit();
		
		//service.stop();
	}
}
