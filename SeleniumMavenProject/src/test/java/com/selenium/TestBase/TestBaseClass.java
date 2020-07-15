package com.selenium.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




public class TestBaseClass {
 
	public static Properties config;
	public static Properties OR;
	public static WebDriver driver;
	
	

	@BeforeTest
	public void intilize() throws IOException{
//create Properties object for that config.properties file
		config=new Properties();
	
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\Config\\config.properties");  
	//load config property file                        F:\SeleniumMavenProject\src\test\java\com\selenium\Config\config.properties  
	config.load(fis);
	//	 //create Properties object for that OR.properties file
      OR=new Properties();
	
	FileInputStream fiss=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\Config\\OR.properties");  
	//load xpath
	OR.load(fiss);
	
	if(config.getProperty("browser").equals("Firefox")){
		
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\pc\\Downloads\\New folder (2)\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}else if(config.getProperty("browser").equals("IE")){
	
		driver=new InternetExplorerDriver();
		
		
      }
	//Maximize the browser window
	driver.manage().window().maximize();

	
}
	
	public static WebElement getObject(String xpathvalue){
		try{
			return driver.findElement(By.xpath(OR.getProperty(xpathvalue)));
		}catch(Throwable t){
			return null;
		}
		
		
		
	}
	 
	 //@AfterTest – Run After any Test method that belongs to the classes is invoked
	 @AfterTest
	 public void close_browser()  {
	
	

  
	 System.out.println("close_browser");
	
	
	  driver.close();
	 }
		
}