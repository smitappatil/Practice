package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class BootstrapDemo2Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=accountsettings&continue=https%3A%2F%2Fmyaccount.google.com%2F%3Fpli%3D1&hl=en&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement dropdown = driver.findElement(By.xpath("//div[@jsname='d9BH4c']"));
//		
//		wait.until(ExpectedConditions.elementToBeClickable(dropdown.findElement(By.xpath("//div[@data-value='af']")))).click();
//		
		List<WebElement> dropdown = driver.findElements(By.xpath("//div[@jsname='d9BH4c']/div/span/"));
		for (int i=0;i<dropdown.size();i++) {
			
			System.out.println(dropdown.get(i).getText());
			
		}
		Thread.sleep(3000);
	}

}
