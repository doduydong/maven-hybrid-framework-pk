package common;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected WebDriver driver;
	protected Logger log;

	@BeforeClass
	protected void beforeClass() {
		log = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@AfterClass
	protected void afterClass() {
		driver.quit();
	}

	protected String getRandomString() {
		return RandomStringUtils.randomAlphabetic(6);
	}

	protected String getRandomNumber() {
		return RandomStringUtils.randomNumeric(3);
	}

	protected String getRandomAlphanumeric() {
		return getRandomString() + getRandomNumber();
	}

}
