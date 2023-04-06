package testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrokenLink {

	public static void main(String[] args) throws IOException  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		//driver.get("https://www.browserstack.com/guide/verify-and-assert-in-selenium");
		//driver.get("https://www.way2automation.com/");
		driver.manage().deleteAllCookies();
		
		List<WebElement> listOflinks = driver.findElements(By.tagName("a"));
		
		System.out.println("no of links : " +listOflinks.size());
		
		for (WebElement alink : listOflinks) {
			
			String url = alink.getAttribute("href");
			URL link= new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			
			if(httpConn.getResponseCode() >=400) {
				
				System.out.println(url + " is a broken link   Code :" +httpConn.getResponseCode());
				
			}else {
				System.out.println(url + " is a valid link  Code :" +httpConn.getResponseCode());
			}
			
			
		}

	}

}
