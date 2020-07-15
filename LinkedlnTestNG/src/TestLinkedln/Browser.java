package TestLinkedln;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver driver;
	
	public static void chromeDriver(){		
		
		System.setProperty("webdriver.chrome.driver", "E:\\library sel\\selenium\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	}
	
	
	public static void fireFoxDriver(){	
		
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\selenium\\gecko32\\geckodriver.exe");
		driver=new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
}
