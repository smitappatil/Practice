package Grid;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TestGrid {

	public static void main(String[] args) throws InterruptedException, IOException {

		Capabilities cap;
		//EdgeOptions opt = new EdgeOptions();
		FirefoxOptions opt = new FirefoxOptions();
		opt.setAcceptInsecureCerts(true);
		opt.getBrowserVersion();
		opt.setHeadless(true);
		//ChromeOptions ops  =new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444"), opt);
	//	Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(""));
		
		WebElement ele = null;
		File elepic = ele.getScreenshotAs(OutputType.FILE);
		
		driver.quit();
	}

}
