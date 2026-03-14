package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	@FindBy(css = ".title")
	private WebElement pageTitle;

	@FindBy(css = ".shopping_cart_link")
	private WebElement cartIcon;

	@FindBy(css = "#add-to-cart-sauce-labs-backpack")
	private WebElement addBagPackButton;

	@FindBy(css = ".shopping_cart_badge")
	private WebElement cartBadge; // shows number of items in cart

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// actions
	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void openCart() {
		cartIcon.click();
	}

	public void addBagPackCart() {
		addBagPackButton.click();
	}

	// Utility: check how many items shown are in the cart
	public int getCartBadgeCount() {
		try {
			return Integer.parseInt(cartBadge.getText());
		} catch (Exception e) {
			return 0; // if badge not visible, no items
		}

	}
}