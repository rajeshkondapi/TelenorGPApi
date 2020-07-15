package test_automation_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Dropable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();		
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();
		
		driver.switchTo().frame(0);
		 WebElement From = driver.findElement(By.id("draggable"));
		 WebElement To = driver.findElement(By.id("droppable"));
		 
		  Actions builder = new Actions(driver);

	      Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();

		  dragAndDrop.perform();
		  System.out.println(driver.findElement(By.xpath(".//*[@id='droppable']/p")));
		
		 

		

	}

}
