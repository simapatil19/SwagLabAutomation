package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
	private WebDriver driver;

	public FinishPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
