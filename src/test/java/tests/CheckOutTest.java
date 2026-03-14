package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import POMTestNG.POMTestNG.BaseTest;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.LoginPage;
import config.ConfigReader;

public class CheckOutTest extends BaseTest {
	@Test
	public void VerifyCheckOutPageTitle() {
		// login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// Step 2: Add Backpack from HomePage
		HomePage homePage = new HomePage(driver);
		homePage.addBagPackCart();
		// Step 3: Navigate to CartPage
		homePage.openCart();
		CartPage cartpage = new CartPage(driver);
		cartpage.ClickcheckoutButton();

		// CheckOutPage
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		Assert.assertEquals(checkoutpage.CheckTitle(), "Checkout: Your Information",
				"Checkout page should display 'Checkout: Your Information' title");

	}

	@Test
	public void VerifyCheckOutDetailsSubmission() {
		// login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// Step 2: Add Backpack from HomePage
		HomePage homePage = new HomePage(driver);
		homePage.addBagPackCart();
		// Step 3: Navigate to CartPage
		homePage.openCart();
		CartPage cartpage = new CartPage(driver);
		cartpage.ClickcheckoutButton();
		// checkoutpage
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.enterDetails(ConfigReader.getProperty("firstname"), ConfigReader.getProperty("lastname"),
				ConfigReader.getProperty("postalcode"));
		checkoutpage.clickButton();
	}
}
