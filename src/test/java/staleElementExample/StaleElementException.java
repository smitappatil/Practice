package staleElementExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.pavantestingtools.com/");
		
		WebElement trainingElement = driver.findElement(By.xpath("//*[@id=\"menu-primary-items\"]/li[5]/a"));
		trainingElement.click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(5000);
		trainingElement.click();   //org.openqa.selenium.StaleElementReferenceException
		
		//TO handle it we can use try catch block
		

	}

}
