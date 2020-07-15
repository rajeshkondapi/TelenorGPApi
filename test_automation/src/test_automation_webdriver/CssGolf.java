package test_automation_webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CssGolf {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.americangolf.co.uk/golf-clubs/fairway-woods");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("hello i eneterd");
		int count =driver.findElements(By.cssSelector(".refinement.brand>div>div>a")).size();
		
		System.out.println(count);
		for(int i=1;i<count;i++){
			Thread.sleep(1000);
			WebElement web=driver.findElement(By.cssSelector(".refinement.brand>div>div>a"));
			web.click();
		}
		
		

	}

}
