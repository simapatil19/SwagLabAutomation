package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
	private WebDriver driver;

	@FindBy(css = ".complete-header")
	private WebElement Header;

	@FindBy(css = "#back-to-products")
	private WebElement BackHomeButton;

	@FindBy(css = ".title")
	private WebElement productPageTitle;

	public FinishPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getConfirmationMessage() {
		return Header.getText();
	}

	public void ClickonBackHome() {
		BackHomeButton.click();
	}

	public String getTitleAfterBackHome() {
		return productPageTitle.getText();
	}
}
