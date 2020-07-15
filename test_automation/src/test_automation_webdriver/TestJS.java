package test_automation_webdriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class TestJS {

	public static void main(String[] args) {		
			System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
			FirefoxDriver driver1 = new FirefoxDriver();
			driver1.manage().window().maximize();
			driver1.navigate().to("https://www.amazon.com/");
			WebElement searchTextBox=driver1.findElement(By.id("twotabsearchtextbox"));
			searchTextBox.sendKeys("Mobiles");
			//WebElement goButton = driver1.findElement(By.cssSelector("input[value=Go]"));
			WebElement goButton=driver1.findElementByCssSelector("input[value=Go]");                 
			safeJavaScriptClick(goButton);
		}

	private static void safeJavaScriptClick(WebElement element) {
		// TODO Auto-generated method stub
		JavascriptExecutor driver = null;
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				
				driver.executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
}
	

