package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class TC_02_Login extends BaseTest {
	private String firstName = getRandomString();
	private String lastName = getRandomString();
	private String emailAddress = getRandomAlphanumeric() + "@gmail.com";
	private String password = getRandomAlphanumeric();

	@Test(groups = { "sanity", "master" })
	public void Login() {
		log.info("Login Testing");

		log.info("Pre-condition - Register new user account");
		HomePage homePage = new HomePage(driver);
		homePage.clickRegisterLink();
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.registerNewAccount(firstName, lastName, emailAddress, password);
		homePage = new HomePage(driver);
		homePage.clickLogoutLink();

		log.info("Login - Step 01 - Click 'Login' link");
		homePage.clickLoginLink();

		LoginPage loginPage = new LoginPage(driver);

		log.info("Login - Step 02 - SendKeys to 'Email' textbox");
		loginPage.sendKeysToEmailTextbox(emailAddress);

		log.info("Login - Step 03 - SendKeys to 'Password' textbox");
		loginPage.sendKeysToPasswordTextbox(password);

		log.info("Login - Step 04 - Click 'Login' button");
		loginPage.clickLoginButton();

		homePage = new HomePage(driver);

		log.info("Login - Step 05 - Verify 'My account' link displayed");
		Assert.assertTrue(homePage.isMyAccountLink());

		log.info("Login - Step 06 - Click 'Logout' link");
		homePage.clickLogoutLink();
	}

}
