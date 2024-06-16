package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	public void sendKeysToEmailTextbox(String emailAddress) {
		emailTextbox.sendKeys(emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

}
