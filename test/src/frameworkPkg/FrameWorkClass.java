package frameworkPkg;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FrameWorkClass {
	public WebDriver driver;
	private static ChromeDriverService service;
	
	
	@Parameters({"browser"})
	@Test
	public void test1(String browser) throws IOException{
		 System.out.println("browser from xml is " +browser);
		 if(browser.equals("chrome")){
	
				System.setProperty("webdriver.chrome.driver","E:\\library sel\\selenium\\chromedriver.exe");
				driver=new ChromeDriver();				
			
		 			}
		 else if(browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();	
		driver.get("http://servicecentral.sagarsoft.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Parameters({"username", "password"})
	@Test(priority=1)
	 public void credentials(String username, String password){  
		System.out.println("username is " +username);
		System.out.println("password is " +password);		
		driver.findElement(By.name("login")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
	   
	 } 
	
}


