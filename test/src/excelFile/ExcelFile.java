package excelFile;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;




public class ExcelFile {
@Test
	public HSSFSheet readExcel(String filePath,String fileName,String sheetName) throws Exception{
		File file = new File(filePath+"\\"+fileName);
		FileInputStream fi=new FileInputStream(file);
		HSSFWorkbook wb=new HSSFWorkbook(fi);
	    HSSFSheet sheet = wb.getSheet(sheetName);
	     return sheet;    
	    }

	}
