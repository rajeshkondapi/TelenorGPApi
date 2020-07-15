package Pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By username = By.cssSelector("#identifierId");

	By password = By.cssSelector(".whsOnd.zHQkBf");

	By Nextbtn = By.cssSelector(".RveJvd.snByac");

	By gmaillogin = By.cssSelector("#identifierId");

	By gmailpass = By.cssSelector(".whsOnd.zHQkBf");

	By gmailNextbtn = By.cssSelector(".RveJvd.snByac");	

	By emai = By.cssSelector(".yP");  

	By arch = By.cssSelector(".ar8.T-I-J3.J-J5-Ji");

	By tokenid = By.xpath(".//*[@id=':nm']");

	//By appl


	public void loginToGmail(String email, String pass) throws Exception{

		driver.findElement(username).sendKeys(email);

		driver.findElement(Nextbtn).click();

		Thread.sleep(2000);

		driver.findElement(password).sendKeys(pass);

		driver.findElement(Nextbtn).click();
	}
	// constructor

	public LoginPage(WebDriver driver){

		this.driver = driver;

	}

	public void typeUserName(String email){

		driver.findElement(username).sendKeys(email);
	}

	public void ClickButton(){

		driver.findElement(Nextbtn).click();	
	}

	public void typePassword(String pass){

		driver.findElement(password).sendKeys(pass);

		ClickButton();

	}

	public void opengmail4token(String email , String password) throws Exception{


		((JavascriptExecutor)driver).executeScript("window.open();");

		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
		
		driver.navigate().to("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		//driver.navigate.to("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver.findElement(gmaillogin).sendKeys(email);

		driver.findElement(gmailNextbtn).click();

		Thread.sleep(2000);	

		driver.findElement(gmailpass).sendKeys(password);

		driver.findElement(gmailNextbtn).click();	
	}

	public String token(){

		String s2 = "";

		List<WebElement> e = driver.findElements(emai);

		System.out.println(e.size());

		java.util.Iterator<WebElement> i = e.iterator();

		while(i.hasNext()) {

			WebElement row = i.next();

			if(row.getText().equals("applications")){

				row.click();
				
				String s = driver.findElement(tokenid).getText();
				
				System.out.println("I am here for token getting  " +s);
				
				String s1 = "You've requested a token for authentication purposes to the Novo Nordisk Print on Demand Portal; your token is: 8ED48490F793";

				System.out.println(s.length());

				int l = s.length()-12;

				s2 = s.substring(l);

			}

			//System.out.println(row.getText());
		}
		return s2;

	}

	public void archive() {

		//WebElement element = driver.findElement(arch);
		driver.findElement(arch).click();

		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

		//driver.close();

	}



}
