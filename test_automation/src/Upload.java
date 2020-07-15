import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Upload {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/samples.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement wb=driver.findElement(By.id("attach4589"));
		wb.sendKeys("E:\\ssss.xls");
}
}