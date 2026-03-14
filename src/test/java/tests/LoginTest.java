package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import POMTestNG.POMTestNG.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import config.ConfigReader;

public class LoginTest extends BaseTest {

	@Test
	public void verifyValidLogin() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		HomePage homepage = new HomePage(driver);
		Assert.assertEquals(homepage.getPageTitle(), "Products", "User should logged in and see the Products Page");
	}

	@Test
	public void VerifyinvalidLogin() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("wrong username", "Wrong password");
		Assert.assertTrue(loginpage.getErrorMessage().contains("Username and password do not match"),
				"Error message should be displayed");
	}

}
