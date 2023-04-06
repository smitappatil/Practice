//package ExcelPractic;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelWrite {
//
//	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("C:\\Users\\Arihan\\Desktop\\Selenium Java HomePractic Oct 2022 (7 Live project)\\project1DataDriverFrameWork\\src\\test\\resources\\excel\\testdata.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheet("sheet2");
//		XSSFRow row = null;
//		XSSFCell col = null;
//
//		int rowNum = sheet.getLastRowNum();
//		row = sheet.getRow(0);
//		int colNum = row.getLastCellNum();
//
//		System.out.println(rowNum);
//		System.out.println(colNum);
//
//		// sheet = workbook.getSheetAt(index);
////		row = sheet.getRow(rowNum - 1);
////		if (row == null)
////			System.out.println("row empty");
////		col = row.getCell(colNum);
////		if (col == null)
////			System.out.println("col empty");
//
//		for (int i = 0; i <= rowNum; i++) {
//			row = sheet.getRow(i);
//			for (int j = 0; j < colNum; j++) {
//
//				System.out.print(row.getCell(j).setCellValue() + "  ");
//			}
//			System.out.println();
//		}
//
//	}
//
//}
