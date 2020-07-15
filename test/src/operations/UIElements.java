package operations;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UIElements {
	 WebDriver driver;
	
	 int rows,coloumns;
	 public UIElements(WebDriver driver){
	        this.driver = driver;
	    }
	 
	 public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
	        // operation is click,settext,gotourl,gettext
		 	
	        switch (operation.toUpperCase()) {
	        
	        case "CLICK":
	            //Perform click
	            driver.findElement(this.getObject(p,objectName,objectType)).click();
	          
	            break;
	        case "SETTEXT":
	            //Set text on control
	            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
	            	            break;
	            
	        case "GOTOURL":
	            //Get url of application
	        	//System.out.println(p.getProperty(value));
	        	//System.out.println(p.getProperty("tablepart1"));
	            driver.get(p.getProperty(value));	            
	            break;
	            
	        case "GETTEXT":
	            //Get text of an element
	            driver.findElement(this.getObject(p,objectName,value)).getText();
	            break;
	            
	        case "DROPDOWNSELECT AND BYVALUE":	        	
	        	Select selvalue = new Select(driver.findElement(this.getObject(p, objectName, objectType)));	  
	        	selvalue.selectByValue(p.getProperty(value));
	        	break;        	
	        	
	        case "DROPDOWNSELECT AND VISIBLETEXT":	        	
	        	Select seltext = new Select(driver.findElement(this.getObject(p, objectName, objectType)));	  
	        	seltext.selectByVisibleText(p.getProperty(value));	
	        	break;
	        	
	        case "DROPDOWNSELECT AND BYINDEX":	        	
	        	Select selindex = new Select(driver.findElement(this.getObject(p, objectName, objectType)));	  
	        	selindex.selectByIndex(Integer.valueOf(p.getProperty(value)));
	        	break;       
	        	
	        case "SWTICHTO":
	        	driver.switchTo().frame(driver.findElement(this.getObject(p, objectName, objectType)));
	        	break;
	        	
	        case "TABLE":
	        	
	        	for(int i=1;i<=tablemethod(p, objectName, objectType);i++){
       				for(int j=1;j<=tablemethod(p, objectName, objectType);j++){
       					//String[] a = objectName
	        			//String s = p.getProperty(a[0]) + "(" + i + ")" + p.getProperty(a[1]) + "(" + j + ")" + p.getProperty(a[2]);
	        			//String txt = driver.findElement(this.getObject(p, s, objectType)).getText();
	        			//System.out.println(s + " " + txt);
	        			/*if(txt.equals(p.getProperty("prevdate"))){
	     	        		System.out.println(txt);
	     	        	Actions action= new Actions(driver);
	     	        	action.contextClick(driver.findElement(this.getObject(p, objectName, objectType)+"("+i+")"+getObject(p, objectName, objectType)+"("+j+")"+getObject(p, objectName, objectType))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	     	        	}*/
	        		}
	        	}
	        	
	        	break;
	        	
	        default:
	            break;
	           
	        
	        }
	    }
	 
	 /**
	  *  {"xx"}
	     * Find element BY using object type and value
	     * @param p
	     * @param objectName
	     * @param objectType
	     * @return
	     * @throws Exception
	     */
	 
	 
	    public By getObject(Properties p,String objectName,String objectType) throws Exception{
	        //Find by xpath
	        if(objectType.equalsIgnoreCase("XPATH")){
	            
	            return By.xpath(p.getProperty(objectName));
	        }
	        //find by class
	        else if(objectType.equalsIgnoreCase("CLASSNAME")){
	            
	            return By.className(p.getProperty(objectName));
	            
	        }
	        //find by name
	        else if(objectType.equalsIgnoreCase("NAME")){
	            
	            return By.name(p.getProperty(objectName));
	            
	        }
	        //Find by css
	        else if(objectType.equalsIgnoreCase("CSS")){
	            if(p.equals(""))
	            	return By.cssSelector(objectName);
	            else
	            	return By.cssSelector(p.getProperty(objectName));
	            
	        }
	        //find by link
	        else if(objectType.equalsIgnoreCase("LINK")){
	            
	            return By.linkText(p.getProperty(objectName));
	            
	        }
	        //find by partial link
	        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
	            
	            return By.partialLinkText(p.getProperty(objectName));
	            
	        }
	      //find by ID link
	        else if(objectType.equalsIgnoreCase(("ID"))){
	        	return By.id(p.getProperty(objectName));
	        }
	        else
	        {
	            throw new Exception("Wrong object type");
	        }
	    }
	    
	    
	    
	    public int tablemethod(Properties p,String objectName,String objectType) throws Exception{
	    	
	    	//List<Integer> l= new ArrayList<Integer>();
	    	
	    	int count= driver.findElements(getObject(p, objectName, objectType)).size();
	    	System.out.println(count);
	    	return count;	
	     }
	    
	    }

