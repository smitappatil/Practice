package TestColor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class TestColoreg {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		Color color = Color.fromString(driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).getCssValue("color"));
		System.out.println(color.getColor());
		color = Color.fromString(driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).getCssValue("background-color"));
		System.out.println(color.getColor());
	
		
		
		 //WebElement t = driver.findElement(By.tagName("h1"));
	      //obtain color in rgba
	  //    String s = t.getCssValue("color");
//		 String c = Color.fromString(s).asHex();
//	      System.out.println("Color is :" + s);
//	      System.out.println("Hex code for color:" + c);
		
		
	}

}
