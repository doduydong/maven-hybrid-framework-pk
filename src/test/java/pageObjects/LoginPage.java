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

	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement loginErrorMessage;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	public void sendKeysToEmailTextbox(String emailAddress) {
		emailTextbox.sendKeys(emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getLoginErrorMessage() {
		return loginErrorMessage.getText();
	}

	public void clickLoginLink() {
		loginLink.click();
	}

}
