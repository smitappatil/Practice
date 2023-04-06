package testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFRamesSet {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box/");
		
		String mainWindow = driver.getWindowHandle();

		System.out.println("main window : "+mainWindow);
		driver.findElement(By.xpath("//a[@href='#example-1-tab-3']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='frames-windows/defult3.html']")));
		driver.findElement(By.xpath("//a[text()='Open Frameset Window']")).click();
		
		Set<String> frameSetWindows = driver.getWindowHandles();
		System.out.println("Child window : "+frameSetWindows);
		Iterator<String> itr = frameSetWindows.iterator(); 
		String parentWindow = itr.next(); //1st window
		driver.switchTo().window(itr.next()); //2nd window
		System.out.println(driver.getCurrentUrl());
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		System.out.println(frames.size());
		System.out.println(frames);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(" Parent Window :" +driver.getCurrentUrl());
		Thread.sleep(2000);
	
		driver.quit();
	}
}
