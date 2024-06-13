package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC_01_Register extends BaseTest {

	@Test
	public void Register() {
		log.info("Register Testing");
		HomePage homePage = new HomePage(driver);

		log.info("Register - Step 01 - Click 'Register' link");
		homePage.clickRegisterLink();

		RegisterPage registerPage = new RegisterPage(driver);

		log.info("Register - Step 02 - SendKeys to 'FirstName' textbox");
		registerPage.sendKeysToFirstNameTextbox(getRandomString());

		log.info("Register - Step 03 - SendKeys to 'LastName' textbox");
		registerPage.sendKeysToLastNameTextbox(getRandomString());

		log.info("Register - Step 04 - SendKeys to 'Email' textbox");
		registerPage.sendKeysToEmailTextbox(getRandomAlphanumeric() + "@gmail.com");

		String password = getRandomAlphanumeric();

		log.info("Register - Step 05 - SendKeys to 'Password' textbox");
		registerPage.sendKeysToPasswordTextbox(password);

		log.info("Register - Step 06 - SendKeys to 'Confirm Password' textbox");
		registerPage.sendKeysToConfirmPasswordTextbox(password);

		log.info("Register - Step 07 - Click 'Register' button");
		registerPage.clickRegisterButton();

		log.info("Register - Step 08 - Verify register success message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 09 - Click 'Continue' button");
		registerPage.clickContinueButton();

		homePage = new HomePage(driver);

		log.info("Register - Step 10 - Click 'Logout' link");
		homePage.clickLogoutLink();
	}

}
