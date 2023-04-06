package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSeleniumDev {

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		
		driver.findElement(By.xpath("//a[text()='4.8.0']")).click();
		Thread.sleep(2000);
		//driver.switchTo().alert().dismiss();
		
		

	}

}
