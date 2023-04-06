package capabilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCertiticate {

	public static void main(String[] args) {

		//EdgeOptions opt = new EdgeOptions();
				//new SSLCertiticate()
//		FirefoxOptions opt = new FirefoxOptions();
//		opt.setAcceptInsecureCerts(true);
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		opt.setHeadless(true);
		
		System.out.println(opt.getBrowserName());
		System.out.println(opt.getBrowserVersion());
		//opt.setBrowserVersion(null);
		WebDriver driver = new ChromeDriver(opt);
		

		driver.get("https://www.google.com");
		
		driver.quit();
	}

}
