package Helper_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String BrowserName , String url){
		
		if(BrowserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajesh.kondapi\\Desktop\\drivers\\geck32\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("chrome")){
			
			driver = new ChromeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("IE")){
			
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		return driver;
	}
	

}
