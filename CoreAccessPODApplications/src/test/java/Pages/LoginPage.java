package Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By email12 = By.cssSelector("#ctl00_mainContent_txtEmail");	
	By submitbtn = By.cssSelector("#ctl00_mainContent_btnEmailSubmit");
	By gmaillogin = By.cssSelector("#identifierId");
	By gmailpass = By.cssSelector(".whsOnd.zHQkBf");
	By gmailNextbtn = By.cssSelector(".RveJvd.snByac");
	
	
	

public void loginToNovo(String email) throws Exception{
	driver.findElement(email12).sendKeys(email);
	
	//driver.findElement(Nextbtn).click();
	Thread.sleep(2000);
	//driver.findElement(password).sendKeys(pass);
	driver.findElement(submitbtn).click();
}
// constructor
public LoginPage(WebDriver driver){
	this.driver = driver;
	
}
public void typeUserName(String email){
	driver.findElement(email12).sendKeys(email);
}
public void ClickButton(){
	driver.findElement(submitbtn).click();
	
}
public void handlealert(){
	
}

public void token(String email , String password) throws Exception{
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(0));
	driver.get("https://accounts.google.com");
	driver.findElement(gmaillogin).sendKeys(email);
	driver.findElement(gmailNextbtn).click();
	Thread.sleep(2000);	
	driver.findElement(gmailpass).sendKeys(password);
	driver.findElement(gmailNextbtn).click();
	
	
}
/*public void typePassword(String pass){
	driver.findElement(password).sendKeys(pass);
	ClickButton();
	
}*/
}