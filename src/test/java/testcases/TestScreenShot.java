package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestScreenShot {
	
	public static WebDriver driver = new ChromeDriver();
	
	public static void captureScreenshot() throws IOException {
		Date date = new Date();
		String filename = date.toString().replace(":", "_").replace(" ", "_") + "_Error.jpg";
		System.out.println(filename);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshots/"+ filename));
	}
	
	public static void captureElementScreenshot(WebElement element) throws IOException {
		Date date = new Date();
		String filename = "Element_"+ date.toString().replace(":", "_").replace(" ", "_") + "_Error.jpg";
		System.out.println(filename);
		File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshots/"+ filename));
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.findElement(By.id("identifierId")).sendKeys("smitaseleniumbussacc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		
		captureScreenshot();
		
		captureElementScreenshot(driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")));
		Thread.sleep(2000);
		

	}

}
