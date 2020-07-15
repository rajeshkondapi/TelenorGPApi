package readExcelData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; // as we are using .xls file we need to import HSSFworkbook
//import org.apache.poi.xssf.usermodel.XSSFSheet; // if we are using .xlsx file we need to import XSSFworksheet
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {

	public static void main(String[] args) throws Exception {
		
		File src=new File("C:\\Rajesh\\excelsheets\\testdata.xls");
		
		FileInputStream fis=new FileInputStream(src); // loaded sheet 
		
		HSSFWorkbook wb=new HSSFWorkbook(fis);//total excel sheet is loaded by this workbook
		
		HSSFSheet sheet1= wb.getSheetAt(0); // for multiple sheets to load we need to specify with index number of sheets
		
		int rowcount =sheet1.getLastRowNum(); // to know how many rows are present
		
		System.out.println("Total Rows is "+rowcount);
		
		for(int i=0;i<rowcount;i++)
		{
			String data0=sheet1.getRow(0).getCell(i).getStringCellValue();
			//System.out.println("Test data from excel is "+data0);
			System.out.println("Data from coloum"+i+" is "+data0);
		}
		
		wb.close(); //memory leak

	}

}
