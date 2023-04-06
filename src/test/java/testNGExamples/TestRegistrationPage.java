package testNGExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.hc.core5.http.ExceptionListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extentlisteners.ExtentListeners;
import utilities.DataUtil;
import utilities.ExcelReader;

// Listeners can be added in runner.xml or usign @Listeners Annotation
//@Listeners(extentlisteners.ExtentListeners.class)
public class TestRegistrationPage {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestRegistrationPage.class);
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/TestData.xlsx");

	public static void click(String locator) {

		if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_NAME")) {

			driver.findElement(By.name(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_TAGNAME")) {

			driver.findElement(By.tagName(OR.getProperty(locator))).click();
		}

		
		log.info("Clicking on Element : " + locator);
		
		ExtentListeners.test.info("Clicking on Element : " + locator);

	}

	public static void clickBtn(String locator, String value) {

		String locatorfinal ="("+ OR.getProperty(locator) + ")[" + value +"]";
		System.out.println(locatorfinal);
		
		if (locator.endsWith("_XPATH")) {
			
			driver.findElement(By.xpath(locatorfinal)).click();

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(locatorfinal)).click();

		} else if (locator.endsWith("_NAME")) {

			driver.findElement(By.name(locatorfinal)).click();

		} else if (locator.endsWith("_TAGNAME")) {

			driver.findElement(By.tagName(locatorfinal)).click();
		}

		log.info("Clicking on Element : " + locatorfinal);
		
		ExtentListeners.test.info("Clicking on Element : " + locatorfinal);

	}
	
	public static void send(String locator, String value) {

		if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			
		} else if (locator.endsWith("_NAME")) {

			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_TAGNAME")) {

			driver.findElement(By.tagName(OR.getProperty(locator))).sendKeys(value);
		}

		log.info("Entering value in Element : " + locator + "   Value = "+value);
		
		ExtentListeners.test.info("Entering value in Element : " + locator + "   Value = "+value);
		
	}
	
	public static void select(String locator, String value) {

		
		WebElement selectElement= null;
		if (locator.endsWith("_XPATH")) {
			
			selectElement = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_ID")) {

			selectElement = driver.findElement(By.id(OR.getProperty(locator)));
			
		} else if (locator.endsWith("_NAME")) {

			selectElement = driver.findElement(By.name(OR.getProperty(locator)));

		} else if (locator.endsWith("_TAGNAME")) {

			selectElement = driver.findElement(By.tagName(OR.getProperty(locator)));
		}
		
		Select select = new Select(selectElement);
		select.selectByVisibleText(value);
		
		log.info(locator + " selected : "+value);
		ExtentListeners.test.info(locator + " selected : "+value);

	}

	@BeforeMethod
	public void launchBrowser() {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (config.getProperty("browser").equals("chrome")) {

			driver = new ChromeDriver();
			log.info("ChromeDriver Launched");
		} else if (config.getProperty("browser").equals("firefox")) {

			driver = new FirefoxDriver();
			log.info("FirefoxDriver Launched");
		}

		driver.get(config.getProperty("testSiteURL2"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit_wait"))));

		
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
		log.info("Browser Closed");
	}

	
	@Test (dataProviderClass =  DataUtil.class , dataProvider = "dp" , groups = {"regressionTest"})
	public void registrationForm(String fisrtName, String lastName,String mStatus, String hobby, String country, String month, String day, String year, String phone, String username, String email,String filepath ,String aboutYourSelf, String password, String cPassword ) {
		
		//String filepath = "C:\\Users\\Arihan\\Pictures\\Saved Pictures\\wallpaper.jpg";
		send("fisrtName_XPATH",fisrtName);
		send("lastName_XPATH",lastName);
		clickBtn("maritalStatus_XPATH", mStatus);
		clickBtn("hobby_XPATH", hobby);
		select("country_XPATH",country);
		select("month_XPATH",month);
		select("day_XPATH",day);
		select("year_XPATH",year);
		send("phone_NAME",phone);
		send("username_NAME", username);
		send("email_NAME",email);
		
		send("file_XPATH",filepath);
		send("aboutYourself_TAGNAME",aboutYourSelf);
		send("password_NAME", password);
		send("cPassword_NAME", cPassword);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		click("submit_XPATH");
		
	}

}
