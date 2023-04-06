package testcases;

import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicElementMakeMytrip {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.makemytrip.com/");
		// driver.get("https://www.yatra.com/flights");

		System.out.println(driver.getWindowHandles());
		driver.findElement(By.xpath("//label[@for='fromCity']/span[@class='lbl_input latoBold  appendBottom5']")).click();
		WebElement city =driver.findElement(By.xpath("//input[contains(@placeholder,'From')]"));
		city.sendKeys("ban");
		List<WebElement> cityList = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li"));
		WebElement cityDropdown = driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li"));
		System.out.println(cityList.size());

		cityDropdown.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys(Keys.ARROW_DOWN);
		cityDropdown.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys(Keys.ARROW_DOWN);
//		for (int i = 1; i <= cityList.size(); i++) {
//			cityDropdown.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys(Keys.ARROW_DOWN);
//			Thread.sleep(1000);
//		}
		driver.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys(Keys.ENTER);
	}

}
