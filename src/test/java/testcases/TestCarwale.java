package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCarwale {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		
		Actions action = new Actions(driver);
		WebElement newcarsMenu = driver.findElement(By.xpath("//div[contains(text(),'NEW CARS')]"));
		action.moveToElement(newcarsMenu).perform();
		WebElement popularBrandsMenu = driver.findElement(By.xpath("//div[contains(text(),'Popular Brands')]"));
		action.moveToElement(popularBrandsMenu).click().perform();
		action.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Toyota']"))).click().perform();
		
		driver.findElement(By.xpath("//span[normalize-space()='More Filter']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Budget']")).click();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[1]/div[1]/p")).click();
																//*[@id="root"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/div[1]/div/div/button[2]/div
		//														  *[@id="root"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/div[1]/div/div/button[1]/div
		WebElement budgetSlider1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/div[1]/div/div/button[1]/div"));

		WebElement budgetSlider2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/div[1]/div/div/button[2]/div"));
		WebElement sliderLength = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/div[1]/div/div/div[1]"));
		int len = sliderLength.getSize().getWidth();
		//System.out.println(sliderLength.getSize().getWidth());
		action.dragAndDropBy(budgetSlider1, 50, 0).perform();
		action.dragAndDropBy(budgetSlider2, -150, 0).perform();
		
		String range1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/div[2]/form/div[1]/div/div/input")).getAttribute("value");
		String range2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/div[2]/form/div[2]/div/div/input")).getAttribute("value");
		System.out.println("Car Price Range is " +range1 + " Lakh TO "+ range2 + " Lakh ");
		
//		driver.findElement(By.xpath("//p[contains(text(),'Body Type')]")).click();
//		driver.findElement(By.xpath("//img[@title='Compact Sedan']")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'Seating Capacity')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'5 Seater')]")).click();
	
		driver.findElement(By.xpath("//p[contains(text(),'Mileage')]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div[2]/div[2]/div/ul/li[6]/div/div[2]/div/div/ul/li[3]/div/label/span[1]/input")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'Additional features')]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox'][@value='113']")).click();
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Apply Filters')]")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
