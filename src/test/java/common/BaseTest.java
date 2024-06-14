package common;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	protected Logger log;
	protected Properties property;

	@Parameters("browser")
	@BeforeClass
	protected void beforeClass(String browserName) {
		log = LogManager.getLogger(this.getClass());

		property = new Properties();
		try (InputStream file = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
			property.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("'" + browserName.toUpperCase() + "' Browser is invalid");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(property.getProperty("pageUrl"));
		log.info(property.getProperty("pageUrl"));
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
