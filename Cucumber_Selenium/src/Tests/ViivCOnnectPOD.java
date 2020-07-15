package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.LoginPage;
import cucumber.api.java.en.*;

public class ViivCOnnectPOD {
	
	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajesh.kondapi\\Desktop\\drivers\\geck32\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();		
	LoginPage login = new LoginPage(driver);
	

	//@Given("^User (?:is on|navigates|launches) (https.*com.*) $")
	@Given("^User should navigate to \"(.*?)\"$")
	public void user_should_navigate_to(String url) throws Throwable {	
		driver.get(url);
		
	}
	/*@Given("^User should navigate to https://staging\\.pullthrough\\.tools/viiv/Login\\.aspx$")
	public void user_should_navigate_to_https_staging_pullthrough_tools_viiv_Login_aspx() {
		driver.get("https://staging.pullthrough.tools/viiv/Login.aspx");
	}*/
	
	
	@When("^User enter email \"(.*?)\" and click on submit$")
	public void user_enter_email_and_click_on_submit(String email) throws Throwable {
		
		login.loginToNovo(email);
		login.handlealert();
		
	}

	@When("^User fetches the token from email \"(.*?)\" and \"(.*?)\"$")
	public void user_fetches_the_token_from_email_and(String mailid, String password) throws Throwable {
		
		login.token(mailid, password);
		
		//login.gettoken();
		
		login.archive();
	}

	@When("^User should enter valid token$")
	public void user_should_enter_valid_token() throws Throwable {
	   
	}

	@Then("^User Clicks on verify button$")
	public void user_Clicks_on_verify_button() throws Throwable {
	   
	}

}
