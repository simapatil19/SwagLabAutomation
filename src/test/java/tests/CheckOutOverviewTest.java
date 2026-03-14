package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import POMTestNG.POMTestNG.BaseTest;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.FinishPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.checkoutOverviewPage;
import config.ConfigReader;

public class CheckOutOverviewTest extends BaseTest{

	@Test
	public void NavigateFinishButton() {
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
				//Assert on overview
				 checkoutOverviewPage overviewPage = new checkoutOverviewPage(driver);
			        Assert.assertEquals(overviewPage.getOverviewTitle(), "Checkout: Overview",
			                "User should be navigated to Checkout Overview page");

			        // Step 6: Click Finish
			        overviewPage.ClickonFinish();

			        // Step 7: Assert on FinishPage
			        FinishPage finishPage = new FinishPage(driver);
			        Assert.assertEquals(finishPage.getConfirmationMessage(), "Thank you for your order!",
			                "Finish page should display order confirmation message");
	
	}
				@Test
}
