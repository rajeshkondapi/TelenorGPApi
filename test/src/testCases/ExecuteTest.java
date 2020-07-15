package testCases;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import operations.ReadObject;
import operations.UIElements;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import excelFile.ExcelFile;

	public class ExecuteTest {
	@Test
	public void testLogin() throws Exception {		
	System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	ExcelFile f = new ExcelFile();
	ReadObject object = new ReadObject();
	Properties allObjects = object.getObjectRepository();
	UIElements operation = new UIElements(driver);
	//System.out.println("");
	//Read keyword sheet
	HSSFSheet filesheet =  f.readExcel(System.getProperty("user.dir")+"\\","loginusers.xls" , "KeywordFramework");
	//Find number of rows in excel file
	    int rowCount = filesheet.getLastRowNum();
	    filesheet.getTopRow();
	    
	    System.out.println(rowCount);
	  //Create a loop over all the rows of excel file to read it
	    for (int i = 2; i <=rowCount; i++) {
	        //Loop over all the rows
	        HSSFRow row = filesheet.getRow(i);
	       // System.out.println(row);
	        if(rowCount!=0){
	       operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
	    }
	        else{
	            //Print the new testcase name when it started
	                System.out.println("Data is Empty or No rows inserted");
	                }
		}
	}
	
	} 