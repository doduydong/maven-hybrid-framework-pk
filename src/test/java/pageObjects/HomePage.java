package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;

	public void clickRegisterLink() {
		registerLink.click();
	}

	public void clickLogoutLink() {
		logoutLink.click();
	}

	public void clickLoginLink() {
		loginLink.click();
	}

	public boolean isMyAccountLink() {
		return myAccountLink.isDisplayed();
	}

}
