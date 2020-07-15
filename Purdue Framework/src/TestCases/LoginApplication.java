package TestCases;

import java.io.IOException;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import reUsableMethods.ReusableMethods;


public class LoginApplication extends ReusableMethods {

	@Test
	
	public void userreg() throws IOException, InterruptedException{
		
		browserType(getProperties("BROWSER"));
		openApplicationURL();
		actionOnElements(getProperties("EMAIL"),"send","rajesh.kondapi@sagarsoft.in");
		actionOnElements(getProperties("EMAILSUBMIT"),"click","");
		//Thread.sleep(3000);
		//popupHandle();
		actionOnElements(getProperties("TOKENPOPUP"),"click","");
		openNewTab();
		openGmailURL();
		actionOnElements(getProperties("GMAILUNAME"),"send","rajesh.kondapi@sagarsoft.in");
		actionOnElements(getProperties("GMAILNEXT"),"click","");
		actionOnElements(getProperties("PASSWORD"),"send","Krajesh1234!!");
		actionOnElements(getProperties("SIGNIN"),"click","");
		
		listElements(actionOnListElements(getProperties("INBOXID")), getProperties("MAILHEADER"));
		
		String actToken=getToken(getProperties("MAILTEXTBODY")).substring(102, 114);
		System.out.println(actToken);
		closeTab();
		actionOnElements(getProperties("MAILSENDBODY"), "send", actToken);
		actionOnElements(getProperties("VERIFYCLICK"), "click", "");
		
		
		listElements(actionOnListElements(getProperties("THERAPEUTICDROPDOWN")), getProperties("THERAPEUTICVALUE"));
		
		
		
		
		/*Select sel=new Select(driver.findElement(By.cssSelector("#ctl00_bodyContent_ddl_ThArea>option")));
		
		sel.selectByIndex(0);
		//closeBrowser();
*/    	
		driver.findElement(By.xpath(".//*[@id='s2id_ctl00_bodyContent_ddl_ThArea']/a")).click();
		ArrayList<String> al=new ArrayList<String>();
		int count=driver.findElements(By.cssSelector("#select2-results-1>li")).size();
		System.out.println(count);
		for(int i=1; i<=count; i++){
			WebElement ele = driver.findElement(By.cssSelector("#select2-results-1>li:nth-child("+i+")>div"));
			String txt=driver.findElement(By.cssSelector("#select2-results-1>li:nth-child("+i+")>div")).getText();
			
			
			System.out.println(getProperties("TERRITORYVALUE"));
			al.add(txt);
			System.out.println(al);
			
			if(txt.equals(getProperties("TERRITORYVALUE"))){
				ele.click();
				//break;
				
				
			}
			
			/*boolean b = (driver.findElement(By.cssSelector(txt)).getText()).equals(getProperties("TERRITORYVALUE"));
			if(b == true)
				driver.findElement(By.cssSelector(txt)).click();
			}*/
				
		}
	}
    	
		
		
	

	
	}
