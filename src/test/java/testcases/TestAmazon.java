package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAmazon {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();


		driver.get("https://www.amazon.in//");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
		
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Fire TV')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Fire TV Stick 4K')]")).click();

		
		
		System.out.println(driver.findElement(By.id("productTitle")).getText());
	
		driver.findElement(By.id("add-to-cart-button")).click();
//		driver.findElement(By.xpath("//input[@title='Add to Wish List']")).click();
//		driver.findElement(By.id("atwl-list-name-3KR8JD9DZ2D0Q")).click();
		
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshots/" + "Error_Amazon.jpg"));
		
		driver.quit();

	}

}
