package com.selenium.UtilityFiles;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.Test;

import com.selenium.TestBase.TestBaseClass;

public class AddCustomerGroups extends TestBaseClass{
	
		@Test
		public void customersAdd() throws Exception {
			driver.get(config.getProperty("TestSiteName"));

			getObject("Login_userID").sendKeys("Kadmin");
			getObject("Login_password").sendKeys("K@admin");
			getObject("Login_button").click();
			
			String displaysuccess=getObject("Login_success").getText();

			if(displaysuccess.equals("Dashboard"))
			{
			
				System.out.println("Dashboard successfully verified");
			}else
			{
				System.out.println("Dashboard  not verified successfully");
			}
	    		
	    		// Read data from excel sheet
	    		FileInputStream fi = new FileInputStream("F:\\SeleniumMavenProject\\src\\test\\java\\com\\selenium\\ExcelPack\\Req sheet.xls");
	    		Workbook w = Workbook.getWorkbook(fi);
	    		Sheet s = w.getSheet("addCustomerGroup");
	     
	//count total rows from excel
			System.out.println("s.getRows() = " + s.getRows());
	//count total columns from excel
			System.out.println("s.getColumns = " + s.getColumns());
			
				
		
		for (int i = 1; i < s.getRows(); i++) 
		{
			
			
			String CustomerGroupName=s.getCell(0, i).getContents();
			String Description=s.getCell(0, i).getContents();
			String ApproveNewCustomers=s.getCell(0, i).getContents();
			
			
			
			getObject("Customer_module").click();
			getObject("Customergroup").click();
	        getObject("AddNew_Customergroup").click();
			Thread.sleep(3000);
			
			getObject("CustomerGroupName").sendKeys(CustomerGroupName);
			getObject("Description").sendKeys(Description);
			getObject("ApproveNewCustomers").sendKeys(ApproveNewCustomers);
			
			getObject("Save_button").click();
			//String text=getObject("modifiedcustomergroups").getText();
			
			//To verify whether the text exists on webpage or not
			boolean customerGroupModified=driver.getPageSource().contains("modified customer groups!");
			
			if(customerGroupModified==true)
			{
				System.out.println("customer group  :"+CustomerGroupName);
				System.out.println("created customer group successfully");
			}else
			{
				System.out.println("customer group not created successfully");
			}
			Thread.sleep(5000);
				  
		
	    }
		// getObject("Logout_link").click();
		//w.close();
			
	}
		
}
		
		 
		 


		  
		


