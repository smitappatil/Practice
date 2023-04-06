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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class chatbot {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.digite.com/");
		
		
		//Thread.sleep(10000);
		
		
		WebElement chatbot = driver.findElement(By.xpath("//div[@id='kairon-client-container']/div[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(chatbot)).click();
				
		driver.findElement(By.xpath("//input[@placeholder='Type a message']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type a message']")).sendKeys("hello");
		driver.findElement(By.xpath("//button[@class='msgSend-0-2-58 msgSend-d0-0-2-64']")).click();
		
		
	}

}
