package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement usernamefiled;

	@FindBy(id = "password")
	private WebElement passwordFiled;

	@FindBy(id = "login-button")
	private WebElement logginButton;

	@FindBy(xpath = "//h3[@data-test=\'error\']")
	private WebElement errorMessage;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// actions(methods)
	public void enterUsername(String username) {
		usernamefiled.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordFiled.sendKeys(password);
	}

	public void clickLogginButton() {
		logginButton.click();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public void login(String Username, String Password) {
		enterUsername(Username);
		enterPassword(Password);
		clickLogginButton();
	}

}
