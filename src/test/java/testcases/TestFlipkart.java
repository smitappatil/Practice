package testcases;

import java.io.File;
import java.io.IOException;
import java.nio.file.spi.FileTypeDetector;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestFlipkart {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshots/"+"Error_Flipkart.jpg"));
		
		Actions action = new Actions(driver);
		WebElement menuFashion = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[3]/a/div[2]/div[1]/div/svg"));
		WebElement womenEthnic = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[3]/a/div[2]/div[2]/div[2]/div/div/div[1]/a[3]"));
		WebElement sareeMenu= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[3]/a/div[2]/div[2]/div[2]/div/div/div[2]/a[2]"));
		action.moveToElement(menuFashion).perform();
		action.moveToElement(womenEthnic).perform();
		action.moveToElement(sareeMenu).click().perform();
		
	
		
	}
}
