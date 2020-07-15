package test_automation_webdriver;

/*public class test11db {*/

/*public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, InterruptedException{
System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
WebDriver driver=new FirefoxDriver();

//driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

String dbUrl = "jdbc:mysql://localhost:8080/jobs4u";

String username = "root";	

//Database Password		
String password = "";				

//Query to Execute		
String query = "select * from apply;";

Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection(dbUrl,username,password); 
System.out.println("db connected" +con);
Statement stmt = con.createStatement();
ResultSet rs= stmt.executeQuery(query);

while (rs.next()){
	String myName = rs.getString(1);								        
    String myAge = rs.getString(2);					                               
    System. out.println(myName+"  "+myAge);	
}		
	 // closing DB Connection		
	con.close();			
}
*/

import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		
public class  test11db {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
                String dbUrl = "jdbc:mysql://localhost:8080/jobs4u";					

				//Database Username		
				String Username = "root";	
                
				//Database Password		
				String Password = "";				

				//Query to Execute		
				String query = "select *  from apply;";	
                
         	    //Load mysql jdbc driver		
           	    Class.forName("com.mysql.jdbc.Driver");			
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,Username,Password);
            	System.out.println("sfvsf" +con);
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         
         		// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		String myName = rs.getString(1);								        
                            String myAge = rs.getString(2);					                               
                            System. out.println(myName+"  "+myAge);		
                    }		
      			 // closing DB Connection		
      			con.close();			
		}
}



/*while(rs.next()) {
int id=rs.getInt(1);
//System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
WebDriver driver1 = new FirefoxDriver();
driver1.get("file:///E:/Selenium/html/testselenium1.html");
WebElement fName=driver1.findElement(By.id("transliterateDiv"));
fName.sendKeys(rs.getString(2).toString()+' ');
Thread.sleep(1000);
*/
