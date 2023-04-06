package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestLoginGmail {

	public static void main(String[] args) throws IOException {
		String browser = "chrome"; 
		WebDriver driver = null;
		
		if (browser.equals("chrome")){
			
			driver = new ChromeDriver();
			
		}else if (browser.equals("firefox")) {
			
			driver = new FirefoxDriver();
			
		}
		
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement elementUserName = driver.findElement(By.id("identifierId"));
		if (elementUserName.isEnabled()) {
			elementUserName.sendKeys("smitaseleniumbussacc@gmail.com");
		}
		
		
		File elementShot = ((TakesScreenshot) elementUserName).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementShot, new File("./screenshots/"+"gmail_element_screenshot.jpg"));
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		
	
	}

}
