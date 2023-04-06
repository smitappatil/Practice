package testNGExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testProperties.TestRegistration;

public class TestDoLogin {

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
	
	@BeforeTest
	public void createDBConnection() {
		log.info("DBConnection created");
		System.out.println("DBConnectio created");
	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("Test Eexecution started");

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
		driver.get(config.getProperty("testSiteURL1"));
		log.info("navigating to Test Site URL :" + config.getProperty("testSiteURL"));
	}
	
	public void validateTitle() {
		
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath(OR.getProperty("homePage_XPATH"))).getText());
		String actualPage = driver.findElement(By.xpath(OR.getProperty("homePage_XPATH"))).getText();
		String expectedPage= "Home";
		Assert.assertEquals(actualPage, expectedPage);
		
		
	}
	
	@Test
	public void testDoLogin() throws IOException, InterruptedException {

		send("username_ID", "angular");
		send("password_ID", "password");
		send("usernameDesc_XPATH", "smitapatil");
		click("loginBtn_TAGNAME");
		
		validateTitle();
		captureScreenshot();
		Thread.sleep(2000);

		captureElementScreenshot("logout_XPATH");
		click("logout_XPATH");
	
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.quit();
		log.info("Closing the Browser");
	}

	@AfterTest
	public void clodeDBConnection() {
		
		log.info("DBConnectio closed");
		System.out.println("DBConnectio closed");
	}
}
