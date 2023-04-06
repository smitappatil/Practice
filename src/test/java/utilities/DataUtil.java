package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import testNGExamples.TestRegistrationPage;

public class DataUtil extends TestRegistrationPage{

	
	@DataProvider(name = "dp")
	public Object[][] getData(Method result) {

		
		String steetName = result.getName();
		System.out.println("steetName:"+steetName);

		int rows = excel.getRowCount(steetName);
		int cols = excel.getColumnCount(steetName);
		
		System.out.println("rows" + rows + "   Cols" +cols);

		//Object[][] data = new Object[rows - 1][cols];
		Object[][] data = new Object[rows -1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(steetName, colNum, rowNum);

			}
		}

		return data;

	}
	
}
