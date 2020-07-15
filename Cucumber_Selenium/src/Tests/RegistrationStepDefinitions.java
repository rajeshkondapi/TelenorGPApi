package Tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class RegistrationStepDefinitions {
	
	
	WebDriver driver = new ChromeDriver();
	
	@Given("^User goes to https://twitter\\.com/signup$")
	public void GoToRegisterPage() throws Throwable {
		driver.get("https://twitter.com/signup");
	    
	}

	@When("^User fills in given details registration form$")
	public void FillTheForm(DataTable testdata) throws Throwable {
	   //List<String> testdataAslist = testdata.asList(String.class);
	  
	   
	   Map<String, String> testdataAsMaps = testdata.asMap(String.class, String.class);
	   
	   /*WebElement index0 = driver.findElement(By.cssSelector("#full-name"));
	   index0.sendKeys(testdataAslist.get(0));
	   driver.findElement(By.cssSelector("#email")).sendKeys(testdataAslist.get(1));
	   
	   driver.findElement(By.cssSelector("#password")).sendKeys(testdataAslist.get(2));*/
	   
	   WebElement index0 = driver.findElement(By.cssSelector("#full-name"));
	   index0.sendKeys(testdataAsMaps.get("Fullname"));
	   driver.findElement(By.cssSelector("#email")).sendKeys(testdataAsMaps.get("Phone"));
	   
	   driver.findElement(By.cssSelector("#password")).sendKeys(testdataAsMaps.get("Password"));
	   
	   
	    System.out.println(testdataAsMaps.toString());
	    
	    
	    
	}
	
	
}
