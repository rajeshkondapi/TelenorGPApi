package test_automation_webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchTabDemo1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///E:/Selenium/html/testselenium1.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String SwitchTabDemo1=driver.getWindowHandle();
		System.out.println("title is "+driver.getTitle());
		driver.findElement(By.linkText("Google")).click();
		Set<String> strHandles=driver.getWindowHandles();
		for(String handle:strHandles)
		{
			driver.switchTo().window(handle);
			String strTitle=driver.getTitle();
			if(strTitle.equalsIgnoreCase("Google")){
				System.out.println(driver.getTitle());
				
			}
		}
		
		

	}

}
