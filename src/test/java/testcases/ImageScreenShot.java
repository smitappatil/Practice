package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageScreenShot {

	public static void main(String[] args) throws IOException {

		WebDriver driver =new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		WebElement pic = driver.findElement(By.id("imagetrgt"));
		
		 File f = pic.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(f, new File("C:\\Users\\Arihan\\Desktop\\pic.jpg"));
		 
		 File pagepic = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(pagepic, new File("C:\\Users\\Arihan\\Desktop\\pagepic.jpg"));
		 

	}

}
