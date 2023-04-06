package TestColor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class TestColor2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/");
		
		WebElement ele = driver.findElement(By.xpath("//section[@class='row td-box td-box--gradient -bg-selenium-green p-2']//div[@class='row']"));
		
		String s = ele.getCssValue("color");
		String c = Color.fromString(s).asHex();
		
		System.out.println("color is " +s);
		System.out.println("hex code for color" +c);
		System.out.println(Color.fromString(s));
		
	}
}
