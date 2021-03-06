package test_automation_webdriver;



import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRefresh {

	private static FirefoxDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
		driver=new FirefoxDriver();
		String Url="https://www.linkedin.com/uas/login";
		driver.navigate().to(Url);
		driver.findElementByLinkText("Forgot password?").click();
		driver.navigate().back();
		Thread.sleep(2000);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		
	}

}
