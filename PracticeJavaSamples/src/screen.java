import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class screen {
	
public void capturescreenshot1() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Utility.captureScreenshot(driver);
		//driver.manage().window().maximize();
		
		driver.get("https://twitter.com/login");		
		
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		 // now copy the  screenshot to desired location using copyFile //method
			driver.findElement(By.xpath(".//*[@id='page-container']/div/div[1]/form/fieldset/div[1]/input")).sendKeys("kondapirajesh");
			Thread.sleep(5000);
		    FileUtils.copyFile(src, new File("D:\\Selenium_workspace\\IMIBotApplication\\"+System.currentTimeMillis()+".png"));
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
		
		driver.quit();
	}

public static void main(String[] args) throws Exception {
	screen sc=new screen();
	sc.capturescreenshot1();
	
	

}
}
