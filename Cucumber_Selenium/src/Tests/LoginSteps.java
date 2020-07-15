package Tests;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;
	/*@Given("^User (?:is on|navigates|launches) (https.*com.*) $")
	public void NavigateTo(String url) throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}*/
	
	@Given("^User is on https://www\\.google\\.com/gmail/about$")
	public void NavigateTo() throws Throwable {
		//throw new PendingException();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.get("https://www.google.com/gmail/about"); 
	}

	@When("^User clicks on SignIn link$")
	public void user_clicks_on_SignIn_link() throws Throwable {
	    driver.findElement(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__sign-in")).click();
	}

	@And("^User logs in using valid username (.*) and password (.*)$")
	public void LoginDemo(String username, String password) throws Throwable {
	   driver.findElement(By.cssSelector("#identifierId")).sendKeys(username);
	   driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys(password);
	   driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
	  WebElement googletext = driver.findElement(By.cssSelector(".sfYUmb"));
	}

	@Then("^User is taken to myaccount page$")
	public void user_is_taken_to_myaccount_page() throws Throwable {
		WebElement googletext = null;
		try{
			googletext =driver.findElement(By.cssSelector(".gb_Xa.gb_dc"));
		}
		catch(Exception exp){
			System.out.println("Not able to locate");
			//throw exp;
		}
		
		Assert.assertNotNull("something went worng with google text !", googletext);
	}

}
