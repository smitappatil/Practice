package TestNgPractic2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	@Test(groups = {"smoke"}, priority = 3)
	public void tc2m1() {
		System.out.println("tc2m1");
//		String expected = "abc";
//		String actual = "abc1";
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(expected, actual);
//		softAssert.assertAll();
		
		//Assert.assertFalse(true, "TEST CASE FAILED");
	}

}
