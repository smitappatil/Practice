package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJavascriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.way2automation.com/angularjs-protractor/registeration/#/login");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("document.getElementById('username').value='angular'");
		js.executeScript("document.getElementById('password').value='password'");
		
		js.executeScript("document.getElementById('formly_1_input_username_0').value='username'");
		//js.executeScript("document.getElementById('displayed-text').value='smita'");
		//WebElement submitBtn = driver.findElement(By.xpath(null))
		//js.executeScript("Auth.login()");
	}

}
