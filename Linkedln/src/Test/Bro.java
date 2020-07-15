package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Bro{
	
	public static WebDriver driver;
	
	@Parameters("browser")
	 
	  @BeforeClass

	public static void bro(String browser){	
		
		System.out.println("i am here");
		
		if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "E:\\library sel\\selenium\\geckodriver.exe");
			  driver = new FirefoxDriver();
		 
		  // If browser is IE, then do this	  
		 
		  }else if (browser.equalsIgnoreCase("chrome")) { 
		 
			  // Here I am setting up the path for my IEDriver
		 
			  System.setProperty("webdriver.ie.driver", "E:\\library sel\\selenium\\chromedriver.exe");
		 
			  driver = new ChromeDriver();
		 
		  } 
		 
		
//		System.setProperty("webdriver.chrome.driver", "E:\\library sel\\selenium\\chromedriver.exe");
//	    driver = new ChromeDriver();
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
//	}
//	
//	
//	public static void fireFoxDriver(){		
//		
//		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\selenium\\geckodriver.exe");
//		driver=new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	}
//	
	
}
}
