package Pages;

import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	WebDriver driver;
	
	
	By email12 = By.cssSelector("#ctl00_mainContent_txtEmail");	
	
	By submitbtn = By.cssSelector("#ctl00_mainContent_btnEmailSubmit");
	
	By gmaillogin = By.cssSelector("#identifierId");
	
	By gmailpass = By.cssSelector(".whsOnd.zHQkBf");
	
	By gmailNextbtn = By.xpath(".//*[@id='identifierNext']/div[2]");
	
	By gmailpassNextbtn = By.xpath(".//*[@id='passwordNext']/content/span");
	
	//By firstname = By.xpath("//input[contains(@name,'firstName')]");
	
	//By lastname = By.xpath("//input[contains(@name,'lastName')]");
	
	By security_Check = By.cssSelector(".WaidBe");
	
	By emai = By.cssSelector(".yP");
	
	By new_emai = By.cssSelector(".zF");
	
	By arch = By.cssSelector(".ar8.T-I-J3.J-J5-Ji");	
	
	By tokenid = By.cssSelector(".adn.ads>div:nth-child(2)>div:nth-child(7)>div");
	
	
	

public void loginToNovo(String email) throws Exception{
	
	driver.findElement(email12).sendKeys(email);	
	
	Thread.sleep(2000);
	
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
	
	try {
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    Assert.assertTrue(alert.getText().contains("A log-in token has been sent to your email."));
	} catch (Exception e) {
	    //exception handling
	}
}

public void token(String email , String password) throws Exception{
	
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	
	driver.switchTo().window(tabs.get(0));
	
	driver.get("https://accounts.google.com");
	
	driver.findElement(gmaillogin).sendKeys(email);
	
	Thread.sleep(2000);
	
	driver.findElement(gmailNextbtn).click();
	
	Thread.sleep(2000);	
	
	driver.findElement(gmailpass).sendKeys(password);
	
	driver.findElement(gmailpassNextbtn).click();
	
	securitymail();
	
	
	
}

/*public String gettoken() {
	System.out.println("in gettoken");

	String s2 = "";
	//StringBuffer s = new StringBuffer();
	
	List<WebElement> e = driver.findElements(emai);

	System.out.println("List content in inbox is :"+e);
	System.out.println("List content in inbox is :"+e.size());
	
		for(int i=0;i<e.size();i++){			
			Iterator<WebElement> iterator = e.iterator();
			System.out.println("iterator :"+iterator);
			WebElement row = iterator.next();
			System.out.println("row :"+row);
			if(e.get(i).equals("Email.alerts")) {
			row.click();
				
			}
		}
	

	java.util.Iterator<WebElement> i = e.iterator();

	while(i.hasNext()) {
		
		WebElement row = i.next();

		if(row.getText().equals("Email.alerts@precisionxtract.com || Email.Alerts@precisionxtract.com")){

			row.click();
			
			String s1 = "You've requested a token for authentication purposes to the Novo Nordisk Print on Demand Portal; your token is: 8ED48490F793";

			//System.out.println(s.length());

		}

		System.out.println(row.getText());
	}
	return s2;

}
*/
public String new_inbox() throws Exception {
	
	String s2 = "";
	
	System.out.println("entered");
	
		Thread.sleep(3000);
		
		WebElement new_inbox = driver.findElement(new_emai);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 	
		
		
		 js.executeScript("arguments[0].click();", new_inbox);
		 
		 System.out.println("entered after click ");
		 
		 WebDriverWait wait = new WebDriverWait(driver, 5);
		 
		 WebElement emailField = wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(tokenid)));
		 
		 
		 /*WebElement tokenid1 = driver.findElement((By) emailField); 
		
		 js.executeScript("arguments[0].text;", tokenid1);*/
		 
		 String s = driver.findElement(tokenid).getText();
		
		System.out.println("I am here for token getting  " +s);
		
		int l = s.length()-12;
		
		s2 = s.substring(l);
		
		System.out.println(s2);
		
		//}
	return s2;
}
public void archive() {

	//WebElement element = driver.findElement(arch);
	driver.findElement(arch).click();

	//((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

	//driver.close();

}

public void securitymail() throws Exception{
	
	if(security_Check != null) {
	driver.findElement(security_Check).click();
	Thread.sleep(2000);
	new_inbox();
}
	else{
		new_inbox();
	}
	}
}