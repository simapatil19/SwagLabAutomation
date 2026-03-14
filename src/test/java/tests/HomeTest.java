package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import POMTestNG.POMTestNG.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import config.ConfigReader;

public class HomeTest extends BaseTest {

	@Test
	public void VerifyHomePageTitleAfterLoggin() {
		System.out.println("Running Home page Title Test");

		// Login First
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// verify HomePageTitle
		HomePage homepage = new HomePage(driver);
		Assert.assertEquals(homepage.getPageTitle(), "Products", "HomePage shoud display Products title after login");
	}

	@Test
	public void verifyaddBagPackCart() {
		System.out.println("Running Add Bagpack Test");
		// Login First
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// Add backpack from Homepage
		HomePage homepage = new HomePage(driver);
		homepage.addBagPackCart();

		// verify how many item shown in cart
		Assert.assertEquals(homepage.getCartBadgeCount(), 1, "Cart badge should show 1 item after adding backpack");
	}

	@Test
	public void VerifyOpenCartNavigation() {
		System.out.println("Navigate to cart");

		// Login First
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		// navigate to cart
		HomePage homepage = new HomePage(driver);
		homepage.openCart();
	}

}
