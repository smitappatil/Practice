package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWindowScrollSize {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.way2automation.com/");

//		Dimension d = new Dimension(400,600);
//		driver.manage().window().setSize(d);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,2500)");
//		for (int i = 0; i < 5; i++) {
//			Thread.sleep(2000);
//			js.executeScript("window.scrollBy(0,1500)");
//		}
		
		
		
		WebElement scrollElement = driver.findElement(By.xpath("//*[@id=\"post-17\"]/div/div/section[12]/div/div/div/div[1]/div/h3"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollElement);
	}

}
