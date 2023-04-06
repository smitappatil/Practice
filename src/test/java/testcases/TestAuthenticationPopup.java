package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAuthenticationPopup {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		//driver.get("https://damin:damin@the-internet.herokuapp.com/digest_auth");
		driver.manage().window().maximize();
//		
//		driver.findElement(By.xpath("href=\"/basic_auth\"")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		((Object) alert).authenticateUsing(new UsernameAndPassword("admin", "admin"));
	}

}
