package vInputAndOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

public class VgetInputsAndOutputs {
	
	
	public void vGetInputs(String xslname,String sheetName) throws IOException{
		
		String path = System.getProperty("user.dir")+"\\General\\avkr.xls";
		FileInputStream file = new FileInputStream(new File(path)); 
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		HSSFSheet sheet = workbook.getSheet(sheetName);
		
		String name = sheet.getRow(2).getCell(0).getStringCellValue();
		
		    
	}

}
