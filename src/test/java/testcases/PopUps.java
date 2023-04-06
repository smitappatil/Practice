package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUps {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Arihan/Desktop/popup.html");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("PopUp")).click();
		
		Set<String> win = driver.getWindowHandles();
		
		Iterator itr = win.iterator();
		System.out.println(win);
		
		String win1 = itr.next().toString();
		String win2 = itr.next().toString();
		
		System.out.println(win1 + "   " +win2);
		
		driver.switchTo().window(win2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.manage().window().getPosition());
		System.out.println(driver.manage().window().getSize());
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.KEY_FIRST);
		robot.mouseMove(0, 0);
//		robot.mouseMove(0, 0); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		Thread.sleep(2000);
//		robot.mouseRelease(InputE);
//		Rvent.BUTTON1_DOWN_MASK);
//		
//		
//		driver.close();
//		driver.switchTo().window(win1);
//		driver.quit();
		
		

	}

}
