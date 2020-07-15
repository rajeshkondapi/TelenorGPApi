package test_automation_webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test3schools {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/");
		WebElement ww=driver.findElement(By.xpath("html/body/div[7]/div[2]/div[1]/h3"));
		System.out.println(ww.getText());
		
		

	}

}
