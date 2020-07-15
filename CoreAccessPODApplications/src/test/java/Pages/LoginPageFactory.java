/**
 * 
 */
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author rajesh.kondapi
 *
 */
public class LoginPageFactory {
	
	WebDriver driver;
	
	public LoginPageFactory(WebDriver ldriver){
		this.driver = ldriver;
		
	}
	
	@FindBy(css = "#identifierId")
	@CacheLookup
	WebElement email;
	
	@FindBy(how= How.CSS,using = ".whsOnd.zHQkBf") 
	@CacheLookup
	WebElement pass;
	
	@FindBy(how= How.CSS,using =".RveJvd.snByac" ) 
	@CacheLookup
	WebElement btnclick;
	
	public void LoginToGmailPF(String emailPF, String passPF) throws Exception{
		
		email.sendKeys(emailPF);
		
		btnclick.click();
		
		Thread.sleep(2000);
		
		pass.sendKeys(passPF);
		
		btnclick.click();
	}
	

}