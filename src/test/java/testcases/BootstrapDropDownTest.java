package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDownTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		List<WebElement> dropdownList = driver.findElements(By.xpath("//div[@aria-labelledby='dropdownMenuButton']/a"));
		
		System.out.println(dropdownList.size());
		
//		for (WebElement element : dropdownList) {
//			if (element.getText().equals("Another action")) {
//				element.click();
//				break;
//			}
//		}

		
//		for (int i=0; i<dropdownList.size();i++) {
//			if (dropdownList.get(i).getText().equals("Another action")) {
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				dropdownList.get(i).click();
//				break;
//			}
//
//		}
		
		
		WebElement dropdown = driver.findElement(By.xpath("//div[@aria-labelledby='dropdownMenuButton']"));
		//instead of driver use dropdown element for findelement
		WebElement dropdownTobeSelected = dropdown.findElement(By.xpath("//a[contains(text(),'Action')]"));
		System.out.println(dropdownTobeSelected.getText());
		dropdownTobeSelected.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
