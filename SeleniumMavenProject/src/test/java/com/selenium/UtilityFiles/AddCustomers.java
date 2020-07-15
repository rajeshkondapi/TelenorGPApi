package com.selenium.UtilityFiles;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.selenium.TestBase.TestBaseClass;

public class AddCustomers extends TestBaseClass{
	
		@Test
		public void customersAdd() throws Exception {
			
	    		
	    		// Read data from excel sheet
	    		FileInputStream fi = new FileInputStream("F:\\SeleniumMavenProject\\src\\test\\java\\com\\selenium\\ExcelPack\\Req sheet.xls");
	    		Workbook w = Workbook.getWorkbook(fi);
	    		Sheet s = w.getSheet("addCustomer");
	     
	//count total rows from excel
			System.out.println("s.getRows() = " + s.getRows());
	//count total columns from excel
			System.out.println("s.getColumns = " + s.getColumns());
			
				
		
		for (int i = 1; i < s.getRows(); i++) 
		{
			
			
			String FirstName=s.getCell(0, i).getContents();
			String LastName=s.getCell(1, i).getContents();
			String EMail=s.getCell(2, i).getContents();
			String Telephone=s.getCell(3, i).getContents();
			String Password=s.getCell(4, i).getContents();
			String Confirm=s.getCell(5, i).getContents();
			
			
			getObject("Customer_module").click();
			getObject("Customers").click();
			getObject("AddNew_Customer").click();
			Thread.sleep(5000);
			

			
			Select dropdown_ = new Select(getObject("Customer_Group"));
			 
				 dropdown_.selectByIndex(1);
			 
			 
			 
			 
			 getObject("FirstName").sendKeys(FirstName);
			getObject("LastName").sendKeys(LastName);
			getObject("EMail").sendKeys(EMail);
			getObject("Telephone").sendKeys(Telephone);
			getObject("Password").sendKeys(Password);
			getObject("Confirm").sendKeys(Confirm);
			
			getObject("Save_button").click();
		
   Thread.sleep(5000);
			
			
	//To verify whether the text exists on webpage or not
			boolean customerCreated=driver.getPageSource().contains("modified customer");
			
			if(customerCreated==true)
			{
				
				System.out.println("created customer  successfully");
			}else
			{
				System.out.println("customer not created successfully");
			}
			Thread.sleep(5000);
			
				  
		
	    }
		 getObject("Logout_link").click();
			Thread.sleep(5000);
		w.close();
			
	}
		
}
		
		 
		 


		  
		


