import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sudheer {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\rajesh.k\\Desktop\\driversinstall\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rajesh.k\\Desktop\\driversinstall\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://staging.cloudev.com/staging/ForceMotors/Signin.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"tuserid\"]")).sendKeys("fmsadmin");
		driver.findElement(By.xpath("//*[@id=\"tpassword\"]")).sendKeys("FML@IMS#18559");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"liTemplates\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addTemplate\"]")).click();
		//WebElement wb = dri.findElement(By.id("ddlLanguage"));
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='ddlLanguage']"));
		Select sel = new Select(dropdownElement);
	
		 
		sel.selectByValue("Telugu");
		
		//dri.switchTo().frame(0);
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Language Pad"))).click();
		
		//driver.findElement(By.linkText("Language Pad")).click();
		
		//*[@id='tTemplateMsg']//preceding::a[@id='ancLanPad']"
		
		//*[@id='ancLanPad']/following::textarea[@id='tTemplateMsg']
		
		
		/*Actions act  = new Actions(dri);
		act.moveToElement(element).click().build().perform();
		act.sendKeys("hammaya").build().perform();*/
	
		//JavascriptExecutor js = (JavascriptExecutor) dri;  
		
		
		//js.executeScript("document.getElementById('tTemplateMsg').value='someValue';");
		
		driver.findElement(By.cssSelector("textarea[id='tTemplateMsg']")).sendKeys("Sarigama");
		driver.findElement(By.xpath("//*[@id='txtTemplLengends']")).sendKeys("Hello first");
		

	}

}
