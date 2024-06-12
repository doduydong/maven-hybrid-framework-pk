package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
