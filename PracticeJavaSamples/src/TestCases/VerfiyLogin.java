/**
 * 
 */
package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;

/**
 * @author rajesh.kondapi
 *
 */
public class VerfiyLogin {
	
	@Test
	public void verfiyValidLogin() throws Exception{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajesh.kondapi\\Desktop\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://uat.pullthrough.tools/novo/Login.aspx");
		
		LoginPage login = new LoginPage(driver);	
		
		login.opengmail4token("rajesh.kondapi@sagarsoft.in", "Krajesh1234!!");
		
		Thread.sleep(5000);
		
		String tok = login.token();
		
		System.out.println("Token generated is = "+tok);
		
		login.archive();
		
		//driver.quit();
		
	}

}
