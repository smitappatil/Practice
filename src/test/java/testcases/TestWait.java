package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(null)));
		
		Wait fluentWait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class)
				.withMessage("fluent wait example");
		
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(null)));
		
		
		driver.findElement(By.xpath(null)).sendKeys(args);
		driver.findElement(By.xpath(null)).sendKeys(Keys.SHIFT);
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(null, 0, 0).perform();
		action.click().perform();
		action.doubleClick(null);
		action.contextClick(null); // Right click
		
	
				
		action.clickAndHold(null).moveToElement(null).release().perform();
		//OR
		action.dragAndDrop(null, null).perform();
		
		JavascriptExecutor js = (JavascriptExecutor(driver));
		js.executeScript("java script code");
		
	}

	private static JavascriptExecutor JavascriptExecutor(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
}
