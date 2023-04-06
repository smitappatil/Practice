package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropdown {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement countryDropdown = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		Select select = new Select(countryDropdown);
		select.selectByValue("AGO");
		System.out.println(countryDropdown.getText());
		Thread.sleep(2000);
		select.selectByVisibleText("Bonaire, Sint Eustatius and Saba");
		
		Thread.sleep(2000);
		select.selectByIndex(2);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//option[@value='BES']")).isSelected());
		
		File elementPic = countryDropdown.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementPic, new File("./screenshots/" + "select.jpg"));
	}

}
