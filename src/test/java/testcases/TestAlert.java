package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
	
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		driver.switchTo().alert().accept();

		WebElement result = driver.findElement(By.id("result"));
		
		System.out.println("Result of JSAlert = " + result.getText());

		Thread.sleep(2000);

		// I am a JS Confirm

		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		System.out.println("Result of JSConfirm = " + driver.findElement(By.id("result")).getText());
		Thread.sleep(1000);

		// Input alert

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys("Smita");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		System.out.println("Result of jsPrompt = " + driver.findElement(By.id("result")).getText());
		Thread.sleep(2000);

		driver.quit();
	}

}
