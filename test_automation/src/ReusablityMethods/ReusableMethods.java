package ReusablityMethods;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReusableMethods {
	public WebDriver driver;
	Properties p = new Properties();

	//Open FirefoxBrowser
	public void firefoxBrowser(){
			
			String firefox =System.getProperty("user.dir")+"\\General\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",firefox);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}

	//Open Chrome Browser
	public void chromeBrowser() throws FileNotFoundException{
		String chrome =System.getProperty("user.dir")+"\\General\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chrome);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String getProperties(String pname) throws IOException{
		
		InputStream pf = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\vProperties\\vPropertiesFile.properties"));
		//load all objects
		p.load(pf);
		return p.getProperty(pname);
		
	}
	
	
	public void perform(String apath,String send,String action){
		
		String[] p = apath.split("@@");
		String path = p[0];String pvalue = p[1];
		
		System.out.println(p[0]);System.out.println(p[1]);
		if(path.equals("name")){			
			if(action.equals("send"))
				driver.findElement(By.name(pvalue)).sendKeys(send);
			else if(action.equals("click"))
				driver.findElement(By.name(pvalue)).click();
		}
		
		if(path.equals("id")){			
			if(action.equals("send"))
				driver.findElement(By.id(pvalue)).sendKeys(send);
			else if(action.equals("click"))
				driver.findElement(By.id(pvalue)).click();
		}
		
		if(path.equals("xpath")){			
			if(action.equals("xpath"))
				driver.findElement(By.xpath(pvalue)).sendKeys(send);
			else if(action.equals("click"))
				driver.findElement(By.xpath(pvalue)).click();
		}
		
	}
	
	

}
