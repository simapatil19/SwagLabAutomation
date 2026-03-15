package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtil;

public class CheckOutPage {
	private WebDriver driver;
	private WaitUtil waitutil;

	@FindBy(css = ".title")
	private WebElement CheckoutPagetitle;

	@FindBy(css = "#first-name")
	private WebElement addFirstName;

	@FindBy(css = "#last-name")
	private WebElement addLatName;

	@FindBy(css = "#postal-code")
	private WebElement addPostalCode;

	@FindBy(css = "#continue")
	private WebElement continueButton;

	// actions
	public String CheckTitle() {
		return CheckoutPagetitle.getText();
	}

	public void enterFirstName(String Ftname) {
		addFirstName.sendKeys(Ftname);
	}

	public void enterLastName(String lname) {
		addLatName.sendKeys(lname);
	}

	public void enterpCode(String pcode) {
		addPostalCode.sendKeys(pcode);
	}

	public void clickButton() {
		waitutil.waitForClickable(continueButton).click();
	}

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		this.waitutil = new WaitUtil(driver, 10);
		PageFactory.initElements(driver, this); // <-- critical
	}

	public void enterDetails(String fname, String lName, String PCode) {
		enterFirstName(fname);
		enterLastName(lName);
		enterpCode(PCode);
		clickButton();
	}

}
