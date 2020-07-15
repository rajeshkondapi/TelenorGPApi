package reUsableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReusableMethods {

	// Load the property file

	public WebDriver driver;
	Properties p = new Properties();	
    private List<WebElement> ls;
    
	public String getProperties(String pname) throws IOException {
		FileInputStream pf = new FileInputStream(
				"E:\\Selenium\\Purdue Framework\\src\\properties\\Login.properties");
		// InputStream in =
		// this.getClass().getResourceAsStream("Login.properties");
		p.load(pf);
		return p.getProperty(pname);
	}

	public void browserType(String browserName) {

		switch (browserName) {
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"E:\\jars\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			break;
		}
	}

	public void openApplicationURL() {
		System.out.println("inside URL");
		System.out.println(p.getProperty("URL"));
		driver.get(p.getProperty("URL"));
	}

	public void openGmailURL() {
		driver.get(p.getProperty("GMAILURL"));
	}

	
	public void openNewTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	}

	public void closeTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
	}

	public void closeBrowser() {
		driver.close();
	}

	public void popupHandle() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void actionOnElements(String eIdentifier, String eAction, String eData) {
		String element[] = eIdentifier.split("@@");

		if (element[0].equals("id")) {
			if (eAction.equals("click")) {
				driver.findElement(By.id(element[1])).click();
			} else if (eAction.equals("send")) {
				driver.findElement(By.id(element[1])).sendKeys(eData);
			}
		}

		if (element[0].equals("name")) {
			if (eAction.equals("click")) {
				driver.findElement(By.name(element[1])).click();
			} else if (eAction.equals("send")) {
				driver.findElement(By.name(element[1])).sendKeys(eData);
			}
		}

		if (element[0].equals("xpath")) {
			if (eAction.equals("click")) {
				driver.findElement(By.xpath(element[1])).click();
			} else if (eAction.equals("send")) {
				driver.findElement(By.xpath(element[1])).sendKeys(eData);
			}
		}

		if (element[0].equals("cssSelector")) {
			if (eAction.equals("click")) {
				driver.findElement(By.id(element[1])).click();
			} else if (eAction.equals("send")) {
				driver.findElement(By.id(element[1])).sendKeys(eData);
			}
		}
	}
	
	public List<WebElement> actionOnListElements(String eIdentifier){
		String element[] = eIdentifier.split("@@");
		if (element[0].equals("id")) {
			ls = driver.findElements(By.id(element[1]));
		}
		else if (element[0].equals("name")) {
			ls = driver.findElements(By.name(element[1]));
		}
		else if (element[0].equals("xpath")) {
			ls = driver.findElements(By.xpath(element[1]));
		}
		return ls;
	}
	//to get all mails
	public void listElements(List<WebElement> list, String compareText) throws IOException{
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(compareText)){ // if u want to click on the specific mailthen here ucan pass it
				list.get(i).click();
				break;
			}
		}
		
		}
	public String getToken(String subtoken){
		String element[]=subtoken.split("@@");
		String text1= null;
		if(element[0].equals("id")){
			 text1=driver.findElement(By.id(element[1])).getText();
			 System.out.println(text1);
		}
		else if(element[0].equals("name")){
			 text1=driver.findElement(By.name(element[1])).getText();
			 System.out.println(text1);
		}
		else if(element[0].equals("xpath")){
			 text1=driver.findElement(By.xpath(element[1])).getText();
			 System.out.println(text1);
	}
		else if(element[0].equals("cssSelector")){
			 text1=driver.findElement(By.cssSelector(element[1])).getText();
			 System.out.println(text1);
		}
		return text1;		


	}
	public void territoryDropdown(String path1, String path2,int size, String CompareText){
		
		
		
			}
		
	}
	


