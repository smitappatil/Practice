package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TestLocator {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		//driver.findElement(RelativeLocator.with(By.id(null)).above(By.id(null)));
		
		((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
		driver.get("https://@the-internet.herokuapp.com/digest_auth");
		
		driver.quit();
		driver.get("https://@the-internet.herokuapp.com/digest_auth");
	}

}
