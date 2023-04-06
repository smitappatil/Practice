package TestNgPractic2;

import java.util.Date;

import org.testng.SkipException;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase1 {

	Date d = new Date();
	@Parameters({"username", "password"})
	@Test(priority =1,  alwaysRun = true, description = "Login test" , dependsOnMethods = {"userReg"} , groups = {"smoke" , "regression"})
	public void doLogin(String username, String password) {
		
		System.out.println("doLogin test executed" +d.toString());
		System.out.println(username);
		System.out.println(password);
		
		String actual = "abc";
		String excepted = "abc";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, excepted);
		
		softAssert.assertAll();
	}
	
	@Test(dataProvider = "dp", groups = {"regression"}, dependsOnGroups = {"smoke"})
	public void userReg(String name, String lastname) {
		
		System.out.println(name + "  " + lastname + " " +d.toString());
		//Assert.fail("failing ");
		
	}
	
	@DataProvider(name = "dp")
	public Object[][] dataProvider(){
		
		Object[][] data= new Object[2][2];
		
		data[0][0] = "smita";
		data[0][1] = "patil";
		data[1][0] = "smita1";
		data[1][1] = "patil1";
		
		return data;
	}
	
	@Test(priority =2, enabled = true, invocationCount = 1, groups= {"smoke"})
	public void testm1() {
		
		System.out.println("testm1"  +d.toString() );
		//throw new SkipException("skippng m1");
	}
	
	@Ignore(" ignoring as not yet ready")
	@Test(priority =2, groups ="smoke")
	public void testm2() {
		
		System.out.println("testm2");
		throw new SkipException("skippng m1");
	}
	
	@BeforeSuite(groups = {"smoke" , "regression"})
	public void beforesuit() {
		System.out.println("beforeSuit"  +d.toString());
	}
	
	@AfterSuite(groups = {"smoke" , "regression"})
	public void aftersuit() {
		System.out.println("afterSuit"  +d.toString());
	}
	
	@BeforeGroups(groups = {"smoke" , "regression"})
	public void beforegp() {
		System.out.println("beforeGroup" +d.toString());
	}
	
	@AfterGroups(groups = {"smoke" , "regression"})
	public void aftergp() {
		System.out.println("afterGroup" +d.toString());
	}
	
	@BeforeTest(groups = {"smoke" , "regression"})
	public void beforetest() {
		System.out.println("beforeTest" +d.toString());
	}
	
	@AfterTest(groups = {"smoke" , "regression"})
	public void aftertest() {
		System.out.println("afterTest" +d.toString());
	}
	
	@AfterMethod(groups = {"smoke" , "regression"})
	public void beforemethod() {
		System.out.println("BeforeMethod" +d.toString());
	}
	
	@AfterMethod(groups = {"smoke" , "regression"})
	public void aftermethod() {
		System.out.println("AfterMethod" +d.toString());
	}
}
