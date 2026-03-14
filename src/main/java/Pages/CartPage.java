package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	private WebDriver driver;
//how many item in the cart
	@FindBy(css = ".cart_item")
	private List<WebElement> cartItem;

//for that particular item
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> itemNames;

	@FindBy(css = ".inventory_item_desc")
	private List<WebElement> itemDesc;

	@FindBy(css = ".inventory_item_price")
	private List<WebElement> itemPrice;

	@FindBy(css = "#checkout")
	private WebElement checkoutButton;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//actions
	public void printItemDetails() {
		System.out.println("items in cart :");
		for (int i = 0; i < cartItem.size(); i++) {
			String name = itemNames.get(i).getText();
			String price = itemPrice.get(i).getText();
			String Description = itemDesc.get(i).getText();

			System.out.println(name + " :=" + price + " :=" + Description);
		}
	}

	public int cartItemSize() {
		return cartItem.size();
	}

	public void ClickcheckoutButton() {
		checkoutButton.click();
	}

}
