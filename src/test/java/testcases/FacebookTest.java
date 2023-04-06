package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookTest {

	// @Test
	public void facebookTest() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		/*
		 * driver.findElement(By.id("email")).sendKeys("smitappatil@gmail.com");
		 * driver.findElement(By.id("pass")).sendKeys("Aradhya18");
		 * driver.findElement(By.name("login")).click();
		 */
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//*[@id=\"u_0_0_RH\"]")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Smita");
		driver.findElement(By.name("lastname")).sendKeys("Selenium");
		
		driver.findElement(By.name("reg_email__")).sendKeys("smitaselenium2022@gmail.com");
		
		driver.findElement(By.name("reg_email__")).sendKeys(Keys.CLEAR);
		
				
				
				
		Thread.sleep(3000);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("smitaselenium2022@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Selenium2023");
		
		Select dayDropdown = new Select(driver.findElement(By.id("day")));
		dayDropdown.selectByVisibleText("15");
		Select monthDropdown = new Select(driver.findElement(By.id("month")));
		monthDropdown.selectByVisibleText("Jan");
		Select yearDropdown = new Select(driver.findElement(By.id("year")));
		yearDropdown.selectByVisibleText("1983");
		
		driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).click();
		driver.findElement(By.name("websubmit")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"reg_error_inner\"]")).getText());
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}
