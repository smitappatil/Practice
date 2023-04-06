package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestRobotClass {

	public static void main(String[] args) throws AWTException {

		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");
		driver.manage().window().maximize();
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@src='draggable/default.html']"));
		
		driver.switchTo().frame(frameEle);
		
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.id("draggable")), 30, 60).perform();
//		driver.findElement(By.id("draggable"));
//		Robot robot = new Robot();
//		
//		robot.keyPress(KeyEvent.KEY_PRESSED);
//		robot.mouseMove(30, 60);
//		robot.keyRelease(KeyEvent.KEY_RELEASED);
		
		
		
	}

}
