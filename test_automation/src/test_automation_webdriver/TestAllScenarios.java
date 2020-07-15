package test_automation_webdriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class TestAllScenarios {

	private static FirefoxDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		String Url="https://www.linkedin.com/uas/login";
		
		driver.navigate().to(Url);
		
		driver.findElementByLinkText("Forgot password?").click();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		driver.navigate().forward();
		
		driver.findElementById("userName-requestPasswordReset").sendKeys("kondapirajesh@gmail.com");
		
		driver.navigate().refresh();
		
	
		
		
		

	}

}