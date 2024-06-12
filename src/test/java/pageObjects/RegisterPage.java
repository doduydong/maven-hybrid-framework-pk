package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	@FindBy(xpath = "//a[contains(@class,'register-continue-button')]")
	private WebElement continueButton;

	public void sendKeysToFirstNameTextbox(String firstName) {
		firstNameTextbox.sendKeys(firstName);
	}

	public void sendKeysToLastNameTextbox(String lastName) {
		lastNameTextbox.sendKeys(lastName);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		emailTextbox.sendKeys(emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void sendKeysToConfirmPasswordTextbox(String password) {
		confirmPasswordTextbox.sendKeys(password);
	}

	public void clickRegisterButton() {
		registerButton.click();
	}

	public String getRegisterSuccessMessage() {
		return registerSuccessMessage.getText();
	}

	public void clickContinueButton() {
		continueButton.click();
	}

}
