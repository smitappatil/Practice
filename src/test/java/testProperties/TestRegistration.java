package testProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestRegistration {

	/*
	 * For Log4j - 1) add log4j dependency in pom.xml 2)define a variable logger log
	 * = Logger.getLogger(TestRegistration.class); 3)add log4j.properties in
	 * properties folder 4)PropertyConfigurator.configure(
	 * "./src/test/resources/properties/log4j.properties"); 5) add logs wherever
	 * needed
	 */

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static Logger log = Logger.getLogger(TestRegistration.class);

	public static void send(String locator, String value) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_TAGNAME")) {
			driver.findElement(By.tagName(OR.getProperty(locator))).sendKeys(value);
		}

		log.info("Typing in element :" + locator + "   Value :" + value);

	}

	public static void click(String locator) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_TAGNAME")) {
			driver.findElement(By.tagName(OR.getProperty(locator))).click();
		}
		log.info("Clicking an element :" + locator);
	}

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("./screenshots/" + filename));
		log.info("Captured screen shot of the page");
	}

	public static void captureElementScreenshot(String locator) throws IOException {
		
		WebElement element = null;
		if (locator.endsWith("_XPATH")) {
			element = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			element = driver.findElement(By.id(OR.getProperty(locator)));
		} else if (locator.endsWith("_TAGNAME")) {
			element = driver.findElement(By.tagName(OR.getProperty(locator)));
		}
		
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenShot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("./screenshots/" + filename));
		
		log.info("Captured screen shot of the element:" + locator);
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("Test Exection started");

		FileInputStream fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);
		log.info("OR file Loaded");

		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);
		log.info("Config file Loaded");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit_wait"))));
		driver.get(config.getProperty("testSiteURL"));
		log.info("navigating to Test Site URL :" + config.getProperty("testSiteURL"));

//		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("angular");
//		driver.findElement(By.id(OR.getProperty("password_ID"))).sendKeys("password");
//		driver.findElement(By.xpath(OR.getProperty("usernameDesc_XPATH"))).sendKeys("smitapatil");
//		driver.findElement(By.tagName(OR.getProperty("loginBtn_TAG"))).click();
		send("username_ID", "angular");
		send("password_ID", "password");
		send("usernameDesc_XPATH", "smitapatil");
		click("loginBtn_TAGNAME");
		captureScreenshot();
		Thread.sleep(2000);
//		driver.findElement(By.xpath(OR.getProperty("logout_XPATH"))).click();
		captureElementScreenshot("logout_XPATH");
		click("logout_XPATH");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
