package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHiddenElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://courses.letskodeit.com/practice");
		
		driver.findElement(By.id("hide-textbox")).click(); 
		//driver.findElement(By.id("displayed-text")).sendKeys("smita");  // ElementNotInteractableException: element not interactable
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('displayed-text').value='smita'");
		
		driver.findElement(By.id("show-textbox")).click(); 
		//Thread.sleep(2000);
		//driver.quit();

	}

}
