package test_automation_webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.testng.annotations.Test;
public class dragdrop {

	public static void main(String[] args) {		
		
			System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.navigate().to("http://jqueryui.com/droppable/");
			//Wait for the frame to be available and switch to it
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
			WebElement sourceElement = driver.findElement(By.cssSelector(".ui-draggable"));
			WebElement destinationElement = driver.findElement(By.cssSelector(".ui-droppable"));
			dragAndDrop(sourceElement,destinationElement);
			String actualText=driver.findElement(By.cssSelector("#droppable>p")).getText();
			
		}
		


	

	private static void dragAndDrop(WebElement sourceElement,
			WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				WebDriver driver = null;
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
		}
		
	}

}
