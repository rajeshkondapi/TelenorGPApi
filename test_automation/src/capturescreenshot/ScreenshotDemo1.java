package capturescreenshot;

import library.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotDemo1 {

	public void capturescreenshot1() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Utility.captureScreenshot(driver);
		//driver.manage().window().maximize();
		
		driver.get("https://twitter.com/login");
		
		Utility.captureScreenshot(driver,"BroswerStarted");
		
		driver.findElement(By.xpath(".//*[@id='page-container']/div/div[1]/form/fieldset/div[1]/input")).sendKeys("kondapirajesh");
		
		Utility.captureScreenshot(driver,"TypeUserName");
		
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		ScreenshotDemo1 sc=new ScreenshotDemo1();
		sc.capturescreenshot1();
		
		

	}

}
