package lib;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig {
	
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	
	public ExcelDataConfig(String excelPath)
	{
		
		try 
		{
			File src=new File(excelPath);
			
			FileInputStream fis=new FileInputStream(src); // loaded sheet 
			
			wb=new HSSFWorkbook(fis);//total excel sheet is loaded by this workbook
			
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		} 
	
	}
	public String getData(int sheetNumber, int row ,int column){
		sheet1= wb.getSheetAt(sheetNumber);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
}
