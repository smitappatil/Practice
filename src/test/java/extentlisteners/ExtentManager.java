package extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testNGExamples.TestDoLogin;
import testNGExamples.TestRegistrationPage;

//import base.BaseTest;



public class ExtentManager{

	private static ExtentReports extent;
	public static String fileName;

	public static ExtentReports createInstance(String fileName) {

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Smita");
		extent.setSystemInfo("Organization", "Way2Automation");
		extent.setSystemInfo("Build no", "W2A-1234");

		return extent;
	}

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		//File screeshot = ((TakesScreenshot) TestDoLogin.driver).getScreenshotAs(OutputType.FILE);
		
		File screeshot = ((TakesScreenshot) TestRegistrationPage.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screeshot, new File(".//reports//" + fileName));
	}

	public static void captureElementScreenshot(WebElement element) throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screeshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screeshot, new File(".//screenshot//" + "Element_" + fileName));
	}

}
