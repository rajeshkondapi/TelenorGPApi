package serviceCentralPkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import beanRelated.ServicecentralBean;
import sqlpackage.sqlconnector;

public class ServiceCentral11 extends sqlconnector{
	
	sqlconnector sqlcon= new sqlconnector();
	
	public WebDriver driver;
	
	public void prevdate(String dashprevdate) throws IOException, InterruptedException{
				
		InputStream f = new FileInputStream("E:\\Selenium\\TestFrameWork\\timeConfig11.properties");
		Properties p = new Properties();
		p.load(f);
		
		
		//int count=driver.findElements(By.cssSelector(".month_view_box>tbody>tr>td")).size();
		
		
		loopbrak1:
		for(int i=2; i<=6; i++){
		for(int j=1; j<=7; j++){

		String txt=driver.findElement(By.cssSelector(".month_view_box>tbody>tr:nth-child("+i+")>td:nth-child("+j+")>table>tbody>tr:nth-child(1)>td:nth-child(1)")).getText();
		

		
		if(txt.equals(p.getProperty("prevdate"))){
		Actions action= new Actions(driver);
		
		action.contextClick(driver.findElement(By.cssSelector(".month_view_box>tbody>tr:nth-child("+i+")>td:nth-child("+j+")>table"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		System.out.println("clicked");
		break loopbrak1;		
		}
		}
		}
		
	}

public void fromTimePicker(int d, String a[]) throws InterruptedException{
		
		driver.findElement(By.id("idtxt_start_time"+d)).click();
		
		int hours=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td")).size();
	     
	    String time = a[0];

		OUTER_LOOP:
	    if (time.equals("am")){
	    	 for(int k=1; k<=2; k++){
	    		   for(int j=1; j<=hours; j++ ){
	    			   String val = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).getText();
	    			   if (val.equals(a[1])){
	    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).click();
	    				   break  OUTER_LOOP;
	    			   }
	    		   }
	   		   }
	     } else if (time.equals("pm")){
	    	 for(int k=3; k<=4; k++){
	  		   for(int j=1; j<=hours; j++ ){
	  			   String value = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).getText();
	  			   if (value.equals(a[1])){
	  				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).click();
	  				   break  OUTER_LOOP;
	  			   }
	  		   }
	 		 }
	     }
	    int minutes=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr")).size();
//	    System.out.println("minutes"+minutes);
	
		 OUTER_LOOP2:
    	 for(int i=1; i<=4; i++){
    		 for(int j=1; j<=3; j++){	    		   
    			   String minValue = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
    			   if (minValue.equals(a[2])){
    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]/a")).click();
    				   break  OUTER_LOOP2;
    			   }
    		   }
   		   }
	    
	}
	
	public void toTimePicker(int d, String a[]) throws InterruptedException{
		//System.out.println("toTime");
		Actions act=new Actions(driver);
		WebElement toTime=driver.findElement(By.id("idtxt_end_time"+d));

		Thread.sleep(2000);
		act.moveToElement(toTime).click().build().perform();
		
		int hours=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td")).size();
//	    System.out.println("hours"+hours);
	    
	    String time = a[3];
	    System.out.println(time);
	    
		OUTER_LOOP:
	     if (time.equals("am")){
	    	 for(int k=1; k<=2; k++){
	    		   for(int j=1; j<=hours; j++ ){
	    			   String value = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).getText();
	    			   if (value.equals(a[4])){
	    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).click();
	    				   break  OUTER_LOOP;
	    			   }
	    		   }
	   		   }
	     } else if (time.equals("pm")){
	    	 for(int k=3; k<=4; k++){
	  		   for(int j=1; j<=hours; j++ ){
	  			   String value = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).getText();
	  			   if (value.equals(a[4])){
	  				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).click();
	  				   break  OUTER_LOOP;
	  			   }
	  		   }
	 		 }
	     }
	    int minutes=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr")).size();
	    //System.out.println("hours"+minutes);
	
		 OUTER_LOOP2:
    	 for(int i=1; i<=4; i++){
    		 for(int j=1; j<=3; j++){	    		   
    			   String minvalue = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
    			   if (minvalue.equals(a[5])){
    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]/a")).click();
    				   break  OUTER_LOOP2;
    			   }
    		   }
   		   }
	}
	
	
	public void dropdowns(int numRows)  throws InterruptedException, IOException, ClassNotFoundException, SQLException  {
		
		InputStream f = new FileInputStream("E:\\Selenium\\TestFrameWork\\timeConfig11.properties");
		Properties p = new Properties();
		p.load(f);
		
		prevdate(p.getProperty("prevdate"));		
		
		
		List<ServicecentralBean> al = sqlcon.ss();
		
		Actions act=new Actions(driver);
		for (int w=0; w <numRows; w++){
			
		
			Select dropdownvalues1= new Select(driver.findElement(By.id("idselproj"+w)));
			List<WebElement> dropd1=dropdownvalues1.getOptions();
		
			
			System.out.println(dropd1.size()); //7
			
			
			String dp1=al.get(w).getProjectsdropdown();	
			
			
			 
			System.out.println(dp1);
				for(int i=0;i<dropd1.size();i++){
					//System.out.println(dropd1.get(i).getText());					
				    if(dropd1.get(i).getText().equals(dp1)){
				    dropdownvalues1.selectByVisibleText(dp1);
				    //System.out.println("Element found and selected");
				    break;
				    } 
				
				}
				
				Thread.sleep(1000);
				Select dropdownvalues2= new Select(driver.findElement(By.cssSelector("#idtable>tbody>tr:nth-child(2)>td:nth-child(2)>select")));
			    List<WebElement> dropd2=dropdownvalues2.getOptions();
			    for(int i=0;i<dropd2.size();i++){
			    
					String dp2=al.get(w).getCategorydropdown();					
					//System.out.println(dropd1.get(i).getText());					
				    if(dropd2.get(i).getText().equals(dp2)){
				    dropdownvalues2.selectByVisibleText(dp2);
				    //System.out.println("Element found and selected");
				    break; 
				    			    
				    } 
				 
			    }
			    
			    Thread.sleep(3000);
				Select dropdownvalues3= new Select(driver.findElement(By.cssSelector("#idtable>tbody>tr:nth-child(2)>td:nth-child(3)>select")));
			    List<WebElement> dropd3=dropdownvalues3.getOptions();
			    for(int i=0;i<dropd3.size();i++){
			    
					String dp3=al.get(w).getTaskdropdown();					
					//System.out.println(dropd1.get(i).getText());					
				    if(dropd3.get(i).getText().equals(dp3)){
				    dropdownvalues3.selectByVisibleText(dp3);
				    //System.out.println("Element found and selected");
				    break; 
				    			    
				    }
				 
			    }
			    
			   
			    Thread.sleep(1000);
			    String textarea=al.get(w).getSubtaskdropdown();
			    WebElement textareaallot=driver.findElement(By.id("idtextarea"+w));
			    act.moveToElement(textareaallot).click().sendKeys(textarea).build().perform();    
			   
			    
			    Thread.sleep(1000);
			    String a = new String(p.getProperty(String.valueOf(w)));
				String arr[]=a.split(",");
				Thread.sleep(2000);
				fromTimePicker(w, arr);
				Thread.sleep(2000);
				toTimePicker(w, arr);
				
				
		    if( w != (numRows-1)){
				Thread.sleep(2000);
				act.moveToElement(driver.findElement(By.xpath(".//*[@id='idaddrow']"))).click().build().perform();			
						} 
		
		}
				Thread.sleep(1000);
				WebElement offtime=driver.findElement(By.id("idtextarea_off0"));		
				act.moveToElement(offtime).click().sendKeys("Lunch").build().perform();
				String v=new String(p.getProperty(String.valueOf(5)));
				System.out.println(v);
				String arr1[]=v.split(",");
				//System.out.println(arr1);
				offtimefromhours(arr1);
				offtimetotime(arr1);
	
			
		}

	
		
		public void offtimefromhours(String b[]) throws InterruptedException{
			Thread.sleep(200);
			
			driver.findElement(By.id("idtxt_start_time_off0")).click();
			int offtimehours=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[3]/td")).size();
			
		    String toofftimehour = b[0];
		    OUTER_LOOP:
		    if (toofftimehour.equals("pm")){
		    	for(int k=3; k<=4; k++){
			  		   for(int j=1; j<=offtimehours; j++ ){	    
		    	 
		    			   String value = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).getText();
		    			   														
		    			   if (value.equals(b[1])){
		    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).click();
		    				   break  OUTER_LOOP;
		    
		
		    			   }
			  		   }
		    
		    	}
		    }
		  
			int toofftime=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr")).size();
			
		    OUTER_LOOP2:
		    	 for(int i=1; i<=toofftime; i++){
		    		 for(int j=1; j<=3; j++){	    		   
		    			   String minvalue = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
		    			   if (minvalue.equals(b[2])){
		    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]/a")).click();
		    				   break  OUTER_LOOP2;
		    			   }
		    		   }
		   		   }
			}

		public void offtimetotime(String b[]) throws InterruptedException{
			
			Actions act=new Actions(driver);
			WebElement toTime=driver.findElement(By.id("idtxt_end_time_off0"));

			Thread.sleep(2000);
			act.moveToElement(toTime).click().build().perform();
			
			int hours=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td")).size();
//		    System.out.println("hours"+hours);
		    
		    String time = b[3];
		    System.out.println(time);
		    
			OUTER_LOOP:
		     if (time.equals("am")){
		    	 for(int k=1; k<=2; k++){
		    		   for(int j=1; j<=hours; j++ ){
		    			   String value = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).getText();
		    			   if (value.equals(b[4])){
		    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).click();
		    				   break  OUTER_LOOP;
		    			   }
		    		   }
		   		   }
		     } else if (time.equals("pm")){
		    	 for(int k=3; k<=4; k++){
		  		   for(int j=1; j<=hours; j++ ){
		  			   String value = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).getText();
		  			   if (value.equals(b[4])){
		  				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr["+k+"]/td["+j+"]/a")).click();
		  				   break  OUTER_LOOP;
		  			   }
		  		   }
		 		 }
		     }
		    int minutes=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr")).size();
		    //System.out.println("hours"+minutes);
		
			 OUTER_LOOP2:
	    	 for(int i=1; i<=4; i++){
	    		 for(int j=1; j<=3; j++){	    		   
	    			   String minvalue = driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
	    			   if (minvalue.equals(b[5])){
	    				   driver.findElement(By.xpath(".//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr["+i+"]/td["+j+"]/a")).click();
	    				   break  OUTER_LOOP2;
	    			   }
	    		   }
	   		   }
		}
			
@Test
public void f1() throws InterruptedException, IOException, ClassNotFoundException, SQLException {	
	
	System.setProperty("webdriver.gecko.driver", "E:\\library sel\\selenium\\gecko32\\geckodriver.exe");		
	//DesiredCapabilities capabilities = new DesiredCapabilities();

	
	// win
	//capabilities.setCapability(FirefoxDriver.BINARY, "E:\\library sel\\selenium\\gecko32\\geckodriver.exe");

	//driver = new FirefoxDriver(capabilities);
	driver = new FirefoxDriver();
	//driver.manage().window().maximize();
	driver.get("http://servicecentral.sagarsoft.com/");
	WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	WebElement element = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.name("login"))
	);
	element.sendKeys("SIL-0400");
	WebElement element1 = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.name("password"))
	);
	element1.sendKeys("Krajesh1234");
	driver.findElement(By.name("submit")).click();	
	Thread.sleep(20);
	WebElement wb=driver.findElement(By.xpath("//a[@data-menu='274']/span"));		  
	Actions act=new Actions(driver);
	act.moveToElement(wb).click().build().perform();
	Thread.sleep(20);
	driver.switchTo().frame(driver.findElement(By.id("time_sheets_iframe")));	
	driver.findElement(By.linkText("Dashboard")).click();
	Thread.sleep(2000);
	
	
	
	dropdowns(3);
	/*InputStream f = new FileInputStream("E:\\Selenium\\TestFrameWork\\timeConfig11.properties");
	Properties p = new Properties();
	p.load(f);
	Select sel = new Select(driver.findElement(By.xpath("html/body/div[6]/div/div/form/div[1]/select")));
	sel.selectByVisibleText(p.getProperty("dropdown4"));*/
	Thread.sleep(2000);
	
	Thread.sleep(1000);
	driver.findElement(By.id("idbtnsubmit")).click();
	
	
}
  @AfterClass
  public void afterClass() {
	  driver.close();
	  
  }

}






