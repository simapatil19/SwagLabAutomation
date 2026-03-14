package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	private WebDriver driver;
	private WebDriverWait wait;

	// Constructor
	public WaitUtil(WebDriver driver, int timeoutInSeconds) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	}

	// Wait until element is visible
	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait until element is clickable
	public WebElement waitForClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait until page title contains text
	public boolean waitForTitleContains(String titleFragment) {
		return wait.until(ExpectedConditions.titleContains(titleFragment));
	}

	// Wait until URL contains text
	public boolean waitForUrlContains(String urlFragment) {
		return wait.until(ExpectedConditions.urlContains(urlFragment));
	}
}
