package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractic {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/");
		
		driver.findElement(By.linkText("Lifetime Membership")).click();
		driver.findElement(By.partialLinkText("Login")).click();

	}

}
