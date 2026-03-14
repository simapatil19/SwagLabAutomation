package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import POMTestNG.POMTestNG.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import config.ConfigReader;

public class CartTest extends BaseTest {

	@Test
	public void VerifyItemInCart() {
		// login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// add item in cart
		HomePage homepage = new HomePage(driver);
		homepage.addBagPackCart();

		// navigate to cart page
		homepage.openCart();
		// print item details
		CartPage cartpage = new CartPage(driver);
		cartpage.printItemDetails();
		// assert cart size

		Assert.assertEquals(cartpage.cartItemSize(), 1, "Cart should contain exactly 1 item after adding backpack");
	}

	@Test
	public void VerifyCheckButtonNavigation() {
		// login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// add item in cart
		HomePage homepage = new HomePage(driver);
		homepage.addBagPackCart();

		// navigate to cart page
		homepage.openCart();
		// print item details
		CartPage cartpage = new CartPage(driver);
		cartpage.ClickcheckoutButton();
	}
}
