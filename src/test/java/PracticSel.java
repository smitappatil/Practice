

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticSel {

	public static void main(String[] args) throws IOException, AWTException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		//driver.navigate().forward();
		//driver.navigate().back();
		//driver.manage().addCookie(null);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println(driver.manage().window().getSize());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Dimension d = new Dimension(400, 500);
		driver.manage().window().setSize(d);
		driver.manage().window().minimize();
		System.out.println(driver.manage().window().getPosition());
		Point p = new Point(200, 200);
		driver.manage().window().setPosition(p);
	
		System.out.println(driver.manage().window().getPosition());
		
		
		String win1 = driver.getWindowHandle();
		Set<String> win2 = driver.getWindowHandles();
		
		
		driver.switchTo().frame(0);
		driver.switchTo().window(win1);
		
		ChromeDriver d1 = new ChromeDriver();
		File f1 = d1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("Location"));
		
		File f2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f2, new File("location"));
		
		Select select = new Select(null);
		
		select.selectByIndex(0);
		WebElement ele = null ;
		ele.isEnabled();
		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.KEY_FIRST);
	}

}
