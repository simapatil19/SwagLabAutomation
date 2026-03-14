package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutOverviewPage {
	private WebDriver driver;

	@FindBy(css = "#finish")
	private WebElement finishButton;

	@FindBy(css = ".complete-header")
	private WebElement successMsg;

	public checkoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	// actions
	public void ClickonFinish() {
		finishButton.click();
	}

	public String Successmsg() {
		return successMsg.getText();
	}
}
