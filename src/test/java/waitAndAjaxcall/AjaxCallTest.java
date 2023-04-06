package waitAndAjaxcall;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxCallTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://omayo.blogspot.com/2013/05/page-one.html");

		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();

		/*
		 * After Delayed-Button-Dropdown Dropdown button is clicked it taked few seconds
		 * to display options this is a AJAX call. Asynchronous call. driver should wait
		 * for the element to load by either implicitlyWait, ExplicitlyWait or
		 * FluentWait
		 */
		// driver.findElement(By.linkText("Facebook")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Facebook"))).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
