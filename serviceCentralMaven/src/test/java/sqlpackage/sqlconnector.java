package sqlpackage;
	
import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		
import java.util.ArrayList;
import org.testng.annotations.Test;

import beanRelated.ServicecentralBean;
public class  sqlconnector  extends ServicecentralBean{	
		String query , query1;
	   @Test
    	public  ArrayList<ServicecentralBean> ss() throws ClassNotFoundException, SQLException
    	{ 			
    		
		   
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
    			int lport=8080;
                String dbUrl = "jdbc:mysql://localhost:3306/seleniumdb";					

				//Database Username		
				String username = "root";	
                
				//Database Password		
				String password = "";				

				//Query to Execute	
				
				//query1= "INSERT INTO dropdowns(Projectsdropdown,Categorydropdown,Taskdropdown,Subtaskdropdown) VALUES('Resource Pool', 'Learning', 'Learnings', 'Selenium-WebDriver')";
					
				 query = "select * from dropdowns";
				
         	    //Load mysql jdbc driver		
           	    Class.forName("com.mysql.jdbc.Driver");			
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);	
         		
         		
         
         		// While Loop to iterate through all data and print results	
         		
         		ArrayList<ServicecentralBean> sqldata = new ArrayList<ServicecentralBean>();
         		//bean b = new bean();
         		
				while (rs.next()){
					ServicecentralBean bb=new ServicecentralBean();
					
					bb.setId(rs.getInt("id"));
					bb.setProjectsdropdown(rs.getString("Projectsdropdown"));
					bb.setCategorydropdown(rs.getString("Categorydropdown"));
					bb.setTaskdropdown(rs.getString("Taskdropdown"));
					bb.setSubtaskdropdown(rs.getString("Subtaskdropdown"));				
					sqldata.add(bb);
					 }	
				return sqldata;
				
      					
		}
}