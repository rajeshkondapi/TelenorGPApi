package test_automation_webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Callable_Methods {	
	
	
	public static void browserentry(String browser) throws Exception{
		WebDriver driver;
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println("hello");
			
			System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://servicecentral.sagarsoft.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver","E:\\library sel\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://servicecentral.sagarsoft.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	}



