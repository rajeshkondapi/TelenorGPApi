package test_automation_webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {

	public static void main(String[] args) {
		
		/*System.setProperty("webdriver.chrome.driver", "E:\\library sel\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");*/
		
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		String T= driver.getTitle();
		
		Alert alert=driver.switchTo().alert();
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println("Your Title is" +alertMessage);
		
		
		
				
				
		/*((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50000)");
			
		 //WebDriverWait wait = new WebDriverWait(driver, 10);
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-50000)");*/
		 
	
	}

}
