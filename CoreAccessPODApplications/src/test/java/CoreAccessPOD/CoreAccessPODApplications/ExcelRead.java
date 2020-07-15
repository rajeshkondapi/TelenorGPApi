package CoreAccessPOD.CoreAccessPODApplications;

import java.io.FileInputStream;


import jxl.Sheet;
import jxl.Workbook;

public class ExcelRead {
	
	public Sheet sheet1() throws Exception {
		FileInputStream fs = new FileInputStream("C:\\Users\\rajesh.kondapi\\Desktop\\login_up.xls");
		Workbook w = Workbook.getWorkbook(fs);
		Sheet s = w.getSheet(0);
		return s;
	}

	

}
