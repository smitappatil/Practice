package testNGExamples;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class TestPracticAttributeOfTestNG {

	@Test(dependsOnGroups = "", dependsOnMethods = {""}, alwaysRun = true, priority = 1, enabled = true, description = "login test", invocationCount = 4, threadPoolSize = 2, singleThreaded = false, dataProvider = "dp")
	public void doLogin() {
		System.out.println("login test");
	}

}
