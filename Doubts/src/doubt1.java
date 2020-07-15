import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class doubt1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajesh.kondapi\\Desktop\\drivers\\geck32\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.get("https://app.meksi.com/login");	
		driver.findElement(By.xpath(".//*[@id='defaultNavbar1']/ul[2]/li[2]/a")).click();
		driver.findElement(By.id("name")).sendKeys("Gopal");
		driver.findElement(By.id("email")).sendKeys("gopalm@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("test123");
		driver.findElement(By.xpath("html/body/div[4]/div/div/div/div/form/div[5]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/section/div/div/div[2]/div/a")).click();
		
		WebElement wb =driver.findElement(By.cssSelector("btn btn-default"));		

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wb);
		
		

	}

}
