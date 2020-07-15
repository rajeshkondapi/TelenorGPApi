package CoreAccessPOD.CoreAccessPODApplications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;


public class CoreAccessPODTestNG {
	
	
 
@Test	
 
  public void beforeClass()  throws Exception  {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajesh.kondapi\\Desktop\\drivers\\geck32\\geckodriver.exe");
	
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://uat.pullthrough.tools/novo/Login.aspx");
	
	LoginPage login = new LoginPage(driver);	
	
	login.loginToNovo("rajesh.kondapi@sagarsoft.in");
	
	login.handlealert();
	
	login.token("rajesh.kondapi@sagarsoft.in", "Krajesh1234!!");
	
	
}
}