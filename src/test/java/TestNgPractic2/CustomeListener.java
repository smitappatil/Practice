package TestNgPractic2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomeListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	public void onTestSuccess(ITestResult result) {

		Reporter.log(result.getMethod().getMethodName()+ " : TEST CASE PASSED ..");
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log(
				"<a href=\"C:\\Users\\Arihan\\Documents\\aradhya\\computer.png\" target=\"_blank\">ScreenShot</a>");
		Reporter.log("<br>");
		Reporter.log(
				"<a href=\"C:\\Users\\Arihan\\Documents\\aradhya\\computer.png\" target=\"_blank\"><img src=\"C:\\Users\\Arihan\\Documents\\aradhya\\computer.png\" height=200 width=200>t</a>");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
