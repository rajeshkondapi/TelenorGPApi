package test_automation_webdriver;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class DropdownJS {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location='https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp'");
		//List li=driver.findElement(arg0)
		/*WebElement wb= driver.findElement(By.xpath(".//*[@id='content']/iframe"));
		driver.switchTo().frame(wb);
		System.out.println("Navigated to frame with id " +wb);

		WebElement button=driver.findElement(By.xpath(".//*[@id='speed-button']/span[1]"));
		
		
		js.executeScript("arguments[0].click();",button);*/
		WebElement element= driver.findElement(By.id("menu1"));
		element.click();
		Actions actionObject = new Actions(driver);
		actionObject.contextClick(element).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER);
		
		
		List <WebElement> allSuggestions = driver.findElements(By.id("menu1"));      
		 for (int j = 0; j < allSuggestions.size(); j++) {
		        System.out.println(allSuggestions.get(j).getText());

		    }
		
		
		
			 
		}
		
		}	
		
	


	


