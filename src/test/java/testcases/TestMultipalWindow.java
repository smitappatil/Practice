package testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMultipalWindow {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box/");
		driver.navigate().to("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box/");
		
	
		//driver.findElement(null).sendKeys(Keys.F5);
		String mainWindow = driver.getWindowHandle();

		System.out.println("main window : "+mainWindow);
		driver.findElement(By.xpath("//a[@href='#example-1-tab-4']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='frames-windows/defult4.html']")));
		driver.findElement(By.xpath("//a[text()='Open multiple pages']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);

		for (String win : windowHandles) {
			if (!win.equals(mainWindow)) {
				
				driver.switchTo().window(win);

				System.out.println(
						"Current Window : " + driver.findElement(By.xpath("//a[contains(text(),'Open')]")).getText());
				Thread.sleep(2000);
				driver.close();
			}
			
			
		}
		System.out.println("main window : "+mainWindow);
		//driver.switchTo().defaultContent();
		driver.switchTo().window(mainWindow);
		System.out.println("Current Window : " + driver.findElement(By.xpath("//a[contains(text(),'Open')]")).getText());
		
		driver.quit();
		Thread.sleep(2000);
	}

}
