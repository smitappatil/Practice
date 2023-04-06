package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		//OR
		//options.addArguments("headless");
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://staging.dx0oqxblmo7a7.amplifyapp.com/login");
		driver.findElement(By.id("login_username_input")).sendKeys("superadmin@myorganization");
		driver.findElement(By.id("loging_password_input")).sendKeys("Admin@123");
		driver.findElement(By.id("login_submit_button")).click();
		
		System.out.println(driver.getTitle());
		
		
		driver.quit();

	}

}
