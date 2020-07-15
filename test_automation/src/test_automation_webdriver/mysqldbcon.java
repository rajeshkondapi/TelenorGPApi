package test_automation_webdriver;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mysqldbcon {

public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, InterruptedException{
WebDriver driver=new FirefoxDriver();
driver.get("http://www.google.com");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8080/jobs4u","root","");  
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select *from city");
while(rs.next()) {
int id=rs.getInt(1);
//System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
WebDriver driver1 = new FirefoxDriver();
driver1.get("file:///C:/xampp/htdocs/engtotelugu.html");
WebElement fName=driver1.findElement(By.id("transliterateDiv"));
fName.sendKeys(rs.getString(2).toString()+' ');
Thread.sleep(1000);

}

}

}