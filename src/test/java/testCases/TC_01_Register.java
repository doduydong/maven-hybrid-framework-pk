package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC_01_Register extends BaseTest {

	@Test
	public void Register() {
		HomePage homePage = new HomePage(driver);

		homePage.clickRegisterLink();

		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.sendKeysToFirstNameTextbox(getRandomString());

		registerPage.sendKeysToLastNameTextbox(getRandomString());

		registerPage.sendKeysToEmailTextbox(getRandomAlphanumeric() + "@gmail.com");

		String password = getRandomAlphanumeric();

		registerPage.sendKeysToPasswordTextbox(password);

		registerPage.sendKeysToConfirmPasswordTextbox(password);

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.clickContinueButton();

		homePage = new HomePage(driver);

		homePage.clickLogoutLink();
	}

}
