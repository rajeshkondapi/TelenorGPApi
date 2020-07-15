package readExcelData;

import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) {
		
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Rajesh\\excelsheets\\testdata.xls");
		System.out.println(excel.getData(1,0,2)); //(sheet,row,column)

	}

}
