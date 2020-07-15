/**
 * 
 */
package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper_Utility.BrowserFactory;
import Pages.LoginPageFactory;

/**
 * @author rajesh.kondapi
 *
 */
public class VerifyValidLoginPF {

	@Test
	public void CheckValidUser() throws Exception{
		
		WebDriver driver = BrowserFactory.startBrowser("firefox","https://accounts.google.com/signin");
		LoginPageFactory Login_PagePF = PageFactory.initElements(driver, LoginPageFactory.class); // byte code
		Login_PagePF.LoginToGmailPF("kondapirajesh@gmail.com", "Krajesh1234");
	}
	
}
