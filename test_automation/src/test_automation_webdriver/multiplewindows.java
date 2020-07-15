package test_automation_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;




public class multiplewindows {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/gmail/about/");
		driver.findElement(By.xpath("html/body/nav/div/a[2]")).click();
		//WebElement Wb =driver.findElement(By.xpath(".//*[@id='lang-chooser']/div[1]/div[1]/div[10]"));	
		
		  Actions action = new Actions(driver);
	      action.clickAndHold(driver.findElement(By.xpath(".//*[@id='lang-chooser']/div[1]/div[1]/div[10]"))).click().build().perform();
	      action.moveToElement(driver.findElement(By.xpath(".//*[@id='lang-chooser']/div[1]/div[1]/div[10]"))).build().perform();
	      
	      JavascriptExecutor jse = (JavascriptExecutor)driver;
	      jse.executeScript("window.scrollBy(0,10)", "");
	      
	     /*Content cont= new Content((ByteBuffer) driver);
	     driver.
		*/
	     
	}

}

	/*  action.mouseMove(
	    		    element(By.xpath(".//*[@id='lang-chooser']/div[1]/div[1]/div[10]"))
	    		  ).build().perform();	*/