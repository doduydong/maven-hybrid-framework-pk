package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC_03_Login_DDT extends BaseTest {

	// *Pre-condition: register account by valid data in Excel file

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void Login(String emailAddress, String password, String result) {
		log.info("Login Testing");
		HomePage homePage = new HomePage(driver);

		log.info("Login - Step 01 - Click 'Login' link");
		homePage.clickLoginLink();

		LoginPage loginPage = new LoginPage(driver);

		log.info("Login - Step 02 - SendKeys to 'Email' textbox");
		loginPage.sendKeysToEmailTextbox(emailAddress);

		log.info("Login - Step 03 - SendKeys to 'Password' textbox");
		loginPage.sendKeysToPasswordTextbox(password);

		log.info("Login - Step 04 - Click 'Login' button");
		loginPage.clickLoginButton();

		if (result.equalsIgnoreCase("valid")) {
			homePage = new HomePage(driver);
			log.info("Login - Step 05 - Verify 'My account' link displayed");
			Assert.assertTrue(homePage.isMyAccountLink());

			log.info("Login - Step 06 - Click 'Logout' link");
			homePage.clickLogoutLink();
		} else {
			log.info("Login - Step 05 - Verify login error message");
			Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
			loginPage.clickLoginLink();
		}
	}

}
