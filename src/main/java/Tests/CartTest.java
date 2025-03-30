package Tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import Utils.AppiumUtils;
import Utils.TouchUtils;
import Utils.WaitUtils;

public class CartTest extends BaseTest{
	
	@BeforeMethod
	public void setUp() {
//		startAppiumServer();
		getDriver("android");
	}
	
	@Test
	public void testCart() {
		
		HomePage homePage = new HomePage(driver);
		WaitUtils.waitForElement(driver, homePage.firstTile);
		
		TouchUtils.scrollToElement(driver, AppiumUtils.readPropertiesFile().getProperty("product.name"));
		ProductPage prodPage = homePage.clickOnProduct(AppiumUtils.readPropertiesFile().getProperty("product.name"));
		WaitUtils.waitForElement(driver, prodPage.productName);
		
		assertTrue(prodPage.verify_product(AppiumUtils.readPropertiesFile().getProperty("product.name"),AppiumUtils.readPropertiesFile().getProperty("product.price")), "Product page not displayed");
		
		// Add product to cart and Verify product is added to cart
		assertTrue(prodPage.verify_productAddToCart(AppiumUtils.readPropertiesFile().getProperty("product.quantity")), "Product not added to cart");
        
		// Open cart
		ShoppingCartPage shoppingCartPage = homePage.clickOnCart();
		
		// Verify product is added to cart
		assertTrue(shoppingCartPage.verify_ProductDetails(), "Product details not displayed in cart");
		
		// Verify order and confirmation
		shoppingCartPage.clickCheckoutButton();
		assertTrue(shoppingCartPage.verify_shippingOptions(), "Shipping details not displayed");
		assertTrue(shoppingCartPage.verify_confirmationDetails(), "Order not confirmed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		//service.stop();
	}
}
