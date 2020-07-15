package Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;


public class Test extends Bro{
	
	public static void main(String[] args) throws InterruptedException, IOException, BiffException, RowsExceededException, WriteException, ParseException {
		
	// Read data from excel
		
		
		String FilePath = "C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\urls.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		
		// TO get the access to the sheet
		Sheet sh = wb.getSheet(0);
		
		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();
		System.out.println("TOTAL IDs : "+totalNoOfRows);
		
		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		//chromeDriver();
		/*Bro br = new Bro();
		br.bro("browser");	*/
		
		//Actions action= new Actions(driver);
		driver.get("http://www.linkedin.com");
		driver.findElement(By.id("login-email")).sendKeys("rathnakar@sagarsoft.com");
		driver.findElement(By.id("login-password")).sendKeys("Sagar06033");		
		driver.findElement(By.id("login-submit")).click();	
		
		if(totalNoOfRows>0){
			
			for (int row = 0; row < totalNoOfRows; row++) {
				String contactid = sh.getCell(0, row).getContents();
				String url = sh.getCell(1, row).getContents();		
			
	
		driver.navigate().to(url);	
		//driver.navigate().to("https://www.linkedin.com/in/evan-miller-707659ba/");.
		
		String filename = "C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\Test.xls";
		// Delete temp file if exists 
		 try{
		      
		        String tempFile = "C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\Test.xls";
		        String existingidexcel = "C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\"+contactid+".xls";
		        //Delete if tempFile exists
		        File fileTemp = new File(tempFile);
		        File excelExisting = new File(existingidexcel);
		        
		          if (fileTemp.exists()){
		             fileTemp.delete();
		             System.out.println("Temp.xls file found and Deleted");
		             
		          }  
		          
		          if( excelExisting.exists()){
		        	  excelExisting.delete();
		        	  System.out.println("Exising ContactID Excel Found and Deleted");
		        	  
		          }
		          
		          
		      }catch(Exception e){
		         // if any error occurs
		         e.printStackTrace();

		      }
	
		//Files.deleteIfExists(filename1);
		Files.copy(Paths.get("C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\Temp\\Test.xls"), Paths.get("C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\Test.xls"));
	  // Excel
		  Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\Test.xls"));
		  WritableWorkbook book = Workbook.createWorkbook(new File("C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\Test.xls"), workbook);
		  
		  WritableSheet contact = book.getSheet("Contact");	
		  WritableSheet jobs = book.getSheet("Jobs");	
		  WritableSheet education = book.getSheet("Education");	
		  WritableSheet skills = book.getSheet("Skills");
		  
		  // LinkedIn ID
		  
			Label label= new Label(0, 1, contactid);
			
			contact.addCell(label);
			
			// src
			
			// src 
			WebElement ele1 = driver.findElement(By.cssSelector(".presence-entity__image"));
			JavascriptExecutor execute = (JavascriptExecutor)driver;  
			execute.executeScript("arguments[0].click();", ele1);
			//action.moveToElement(driver.findElement(By.cssSelector(".presence-entity__image"))).click();
			
			Thread.sleep(250);
			if(driver.findElements(By.cssSelector(".pv-member-photo-modal__image")).size() != 0){
			WebElement element = driver.findElement(By.cssSelector(".pv-member-photo-modal__image"));
			String src = ((JavascriptExecutor)driver).executeScript("return arguments[0].attributes['src'].value;", element).toString();
			System.out.println("PROFILE SRC: "+src);

				Label srclabel= new Label(1, 1, src);
				
				contact.addCell(srclabel);
				
				driver.findElement(By.cssSelector(".pv-member-photo-modal__close")).click();
		 
			}
			
			else{
				
				System.out.println("Image is not uploaded by the user");
				 Label srclabel= new Label(1, 1, "Avatar is not available");
				 contact.addCell(srclabel);
			}
		  

		  
	
		String name = driver.findElement(By.cssSelector(".pv-top-card-section__body>div:nth-child(1)>div>h1")).getText();
		System.out.println(name);
		//Writing into Excel		
		 Label labe2= new Label(2, 1, name);		 
		 contact.addCell(labe2);
		

		
		if(driver.findElements(By.cssSelector(".truncate-multiline--truncation-target")).size() != 0){
			String contactdescription = driver.findElement(By.cssSelector(".truncate-multiline--truncation-target")).getText();
			
			System.out.println(contactdescription);
			
			//Writing into Excel
			 Label description= new Label(5, 1, contactdescription);
			 contact.addCell(description);
		}

		String citi = driver.findElement(By.cssSelector(".pv-top-card-section__body>div:nth-child(1)>h3:nth-child(4)")).getText();
		System.out.println(citi);		
		//Writing into Excel
		 Label citiE= new Label(6, 1, citi);
		 contact.addCell(citiE);  
		 
		 // LinkedIn url
		 Label LinkedINurl= new Label(9, 1, url);
		 contact.addCell(LinkedINurl);
		 
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,180)", "");
			
			Thread.sleep(750);
	 
		 
		if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).size() != 0){
			for(int p=1 ; p<=4 ; p++){
			
			if(driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button")).getText().equals("See fewer positions"))
			{
			break;
			}
			else{
			//Thread.sleep(100);
				
			
				WebElement element = driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span"));
				//Actions action = new Actions(driver);
				//action.moveToElement(element).click();
			//driver.findElement(By.cssSelector(".pv-profile-section__see-more-inline.link")).click();
			System.out.println("See more Experiance Link Clicked");			
			Thread.sleep(2000);
			}
			
		}
		 }
		//JavascriptExecutor jsx = (JavascriptExecutor)driver;
		JavascriptExecutor jsx1 = (JavascriptExecutor)driver;	
		jsx1.executeScript("window.scrollBy(0,120)", "");
			
		System.out.println("***JOBS***");
		//CSS 1
		
		List<WebElement> listChanges1 = driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li>div>a"));
		int expcount1 = listChanges1.size();
		System.out.println("CSS 1 Total Companies Found: "+expcount1);
		
		Thread.sleep(500);
		
		//CSS 2
		List<WebElement> listChanges2 = driver.findElements(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view"));
		int expcount2 = listChanges2.size();
		System.out.println("CSS 2 Total Companies Found: "+expcount2);
		
		// Below two veriables are usind in expcount2 for loop
		int st = expcount1+1;
		int end = expcount1+expcount2;
		
		System.out.println("Starting CSS: "+expcount1+ " And Ending CSS:"+end+"");
		
		
		
		if(expcount1>0){
			
			for(int i=1;i<=expcount1;i++){
				
				System.out.println("");
				System.out.println("      ****COMPANY "+i+ " DETAILS***");
				
				if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h4:nth-child(2)>span:nth-child(2)")).size() > 0){
					
					
				//	action.moveToElement(driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h3"))).sendKeys("");
					
				String expcompname = driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h4:nth-child(2)>span:nth-child(2)")).getText();
				System.out.println(expcompname);

				//Writing into Excel
				 Label labe3= new Label(0, +i, contactid);
				 Label compnayname= new Label(1, +i, expcompname);
				 jobs.addCell(labe3);			 
				 jobs.addCell(compnayname);  
				}
				
				if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h3")).size() > 0){
				String exptitle = driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h3")).getText();
				System.out.println(exptitle);

				
				//Writing into Excel
				 Label jobtitle = new Label(2, +i, exptitle);
				 jobs.addCell(jobtitle);  			
				}
				
				if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h4:nth-child(3)>span:nth-child(2)")).size() > 0){
				String expyears = driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h4:nth-child(3)>span:nth-child(2)")).getText();
				System.out.println(expyears);
				
				String[] split = expyears.split(" � ");
	  			String split1 = split[0];
	  			
	  			String split2 = split[1];
	  			
	  			
	  			if(split1.contains(" ")  && split2.matches("[0-9]+") && split2.length() > 2){						
					
	  				String deliverydate1= split1;
	  				String deliverydate2= split2;
	  				System.out.println("split1 = " +deliverydate1);
	  				System.out.println("split2 = " +deliverydate2);
	  				
	  				SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");
	  				SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
	  				
	  				Date date1=sdf1.parse(deliverydate1);
	  				Date date2=sdf2.parse(deliverydate2);
	  				
	  				sdf1=new SimpleDateFormat("MM-dd-yyyy");
	  				sdf2=new SimpleDateFormat("01-32-yyyy");
	  				
	  				String sdf3 = sdf1.format(date1);
	  				String sdf4 = sdf2.format(date2);
	  				
	  				 Label experiancestartdate = new Label(3, +i, sdf3);
	  				 jobs.addCell(experiancestartdate); 
	  				 System.out.println("Start Date:"+sdf3);

	  				 Label experianceenddate = new Label(4, +i, sdf4);
	  				 jobs.addCell(experianceenddate);  
	  				 System.out.println("End Date:"+sdf4);
	  				
	  		
	  				}
	  				
	  				
	  				if((split1.contains(" "))  && (split2.contains(" "))  && (!split1.equals(split2))){						
	  				
	  				String deliverydate1= split1;
	  				String deliverydate2= split2;
	  				
	  				SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");
	  				SimpleDateFormat sdf2=new SimpleDateFormat("MMM yyyy");
	  				
	  				Date date1=sdf1.parse(deliverydate1);
	  				Date date2=sdf2.parse(deliverydate2);
	  				
	  				sdf1=new SimpleDateFormat("MM-dd-yyyy");
	  				sdf2=new SimpleDateFormat("MM-dd-yyyy");
	  				
	  				String sdf3 = sdf1.format(date1);
	  				String sdf4 = sdf2.format(date2);
	  				
	  				 Label experiancestartdate = new Label(3, +i, sdf3);
	  				 jobs.addCell(experiancestartdate); 
	  				 System.out.println("Start Date:"+sdf3);

	  				 Label experianceenddate = new Label(4, +i, sdf4);
	  				 jobs.addCell(experianceenddate);  
	  				 System.out.println("End Date:"+sdf4);			
	  		
	  				}
	  				
	  				
	  				if(split1.matches("[0-9]+") && split1.length() > 2 && split2.contains(" ")){
	  					
	  					String deliverydate1= split1;
	  					String deliverydate2= split2;
	  					
	  					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");
	  					SimpleDateFormat sdf2=new SimpleDateFormat("MMM yyyy");
	  					
	  					Date date1=sdf1.parse(deliverydate1);
	  					Date date2=sdf2.parse(deliverydate2);
	  					
	  					sdf1=new SimpleDateFormat("01-32-yyyy");
	  					sdf2=new SimpleDateFormat("MM-dd-yyyy");
	  					
	  					String sdf3 = sdf1.format(date1);
	  					String sdf4 = sdf2.format(date2);
	  					
	  					 Label experiancestartdate = new Label(3, +i, sdf3);
	  					 jobs.addCell(experiancestartdate); 
	  					 System.out.println("Start Date:"+sdf3);

	  					 Label experianceenddate = new Label(4, +i, sdf4);
	  					 jobs.addCell(experianceenddate);  
	  					 System.out.println("End Date:"+sdf4);	
	  					

	  				
	  				}
	  					
	  				
	  				// Checks only Year(yyyy) and changes to 01-32-yyyy for both start and End date
	  				if(split1.matches("[0-9]+") && split1.length() > 2 && (split2.matches("[0-9]+") && split2.length() > 2)){
	  					
	  					String deliverydate1= split1;
	  					String deliverydate2= split2;
	  					
	  					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");
	  					SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
	  					
	  					Date date1=sdf1.parse(deliverydate1);
	  					Date date2=sdf2.parse(deliverydate2);
	  					
	  					sdf1=new SimpleDateFormat("01-32-yyyy");
	  					sdf2=new SimpleDateFormat("01-32-yyyy");
	  					
	  					String sdf3 = sdf1.format(date1);
	  					String sdf4 = sdf2.format(date2);
	  					
	  					 Label experiancestartdate = new Label(3, +i, sdf3);
	  					 jobs.addCell(experiancestartdate); 
	  					 System.out.println("Start Date:"+sdf3);

	  					 Label experianceenddate = new Label(4, +i, sdf4);
	  					 jobs.addCell(experianceenddate);  
	  					 System.out.println("End Date:"+sdf4);	
	  					
	  					
	  					
	  				}
	  				
	  				if(split1.matches("[0-9]+") && split1.length() > 2 && split2.equals("Present")){
	  					
	  					String deliverydate1= split1;
	  					String deliverydate2= split2;
	  					
	  					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");

	  					
	  					Date date1=sdf1.parse(deliverydate1);

	  					
	  					sdf1=new SimpleDateFormat("01-32-yyyy");				
	  					String sdf3 = sdf1.format(date1);
	  					
	  					 Label experiancestartdate = new Label(3, +i, sdf3);
	  					 jobs.addCell(experiancestartdate); 
	  					 System.out.println("Start Date:"+sdf3);

	  					 Label experianceenddate = new Label(4, +i, deliverydate2);
	  					 jobs.addCell(experianceenddate);  
	  					 System.out.println("End Date:"+deliverydate2);	
	  					

	  					
	  				}
	  				
	  				
	  				if(split1.contains(" ") && split2.equals("Present")){
	  					
	  					String deliverydate1= split1;
	  					String deliverydate2= split2;
	  					
	  					SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");

	  					
	  					Date date1=sdf1.parse(deliverydate1);

	  					
	  					sdf1=new SimpleDateFormat("MM-dd-yyyy");

	  					
	  					String sdf3 = sdf1.format(date1);
	  					
	  					 Label experiancestartdate = new Label(3, +i, sdf3);
	  					 jobs.addCell(experiancestartdate); 
	  					 System.out.println("Start Date:"+sdf3);

	  					 Label experianceenddate = new Label(4, +i, deliverydate2);
	  					 jobs.addCell(experianceenddate);  
	  					 System.out.println("End Date:"+deliverydate2);	


	  					
	  				}
	  				
	  				if(split1.equals(split2) && (split1.contains(" "))  && (split2.contains(" "))){
	  					
	  					
	  						
	  						String deliverydate1= split1;
	  						String deliverydate2= split2;
	  						
	  						SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");				
	  						SimpleDateFormat sdf2=new SimpleDateFormat("MMM yyyy");
	  						
	  						Date date1=sdf1.parse(deliverydate1);
	  						Date date2=sdf2.parse(deliverydate2);
	  						
	  						sdf1=new SimpleDateFormat("MM-dd-yyyy");
	  						sdf2=new SimpleDateFormat("MM-99-yyyy");
	  						
	  						String sdf3 = sdf1.format(date1);				
	  						String sdf4 = sdf2.format(date2);
	  						
	  						
	  						 Label experiancestartdate = new Label(3, +i, sdf3);
	  						 jobs.addCell(experiancestartdate); 
	  						 System.out.println("Start Date:"+sdf3);

	  						 Label experianceenddate = new Label(4, +i, sdf4);
	  						 jobs.addCell(experianceenddate);  
	  						 System.out.println("End Date:"+sdf4);	
	  						

	  					
	  					
	  				}
				
				}
				
				//Company info.	
					//action.moveToElement(driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>h3"))).click();
					
					Thread.sleep(1500);
					
					// New Code for Src 
					
					if(driver.findElements(By.cssSelector(".org-top-card-module__container.container-with-shadow.clearfix>img")).size() != 0)
					{
						By by = By.cssSelector(".org-top-card-module__container.container-with-shadow.clearfix>img");
						String explogosrc = driver.findElement(by).getAttribute("src");
						System.out.println("src: "+explogosrc);
						
						boolean  c = explogosrc.startsWith("data");
						
						if(c==false)
							
						{
							 Label exlogo = new Label(15, +i, explogosrc);
							 jobs.addCell(exlogo);  

						}
						else
						{
							System.out.println("Company logo url is not available");
							Label expcomplogo= new Label(15, +i, "Image is not available");
							jobs.addCell(expcomplogo);
						
						}
					}
					
					else
					{
						System.out.println("Company logo url is not available");
						Label expcomplogo= new Label(15, +i, "Image is not available");
						jobs.addCell(expcomplogo);
					}
					
					if(driver.findElements(By.cssSelector(".org-about-us-organization-description__company-heading")).size() != 0){
					
					if(driver.findElements(By.cssSelector("#org-about-company-module__show-details-btn>li-icon>svg>g>path")).size() > 0){
						driver.findElement(By.cssSelector("#org-about-company-module__show-details-btn>li-icon>svg>g>path")).click();					
					
					}
					
					if(driver.findElements(By.cssSelector(".org-about-us-organization-description.ember-view>p")).size() > 0){
					String description = driver.findElement(By.cssSelector(".org-about-us-organization-description.ember-view>p")).getText();
					System.out.println(description);

					
					//Writing into Excel
					 Label compdes = new Label(5, +i, description);
					 jobs.addCell(compdes);  	
					}				
					
					 	if(driver.findElements(By.cssSelector(".org-about-us-company-module__website.mb3.link-without-visited-state.ember-view")).size() > 0){
							String comwebsite = driver.findElement(By.cssSelector(".org-about-us-company-module__website.mb3.link-without-visited-state.ember-view")).getText();
							System.out.println(comwebsite);

						
							//Writing into Excel
							 Label compweb = new Label(6, +i, comwebsite);
							 jobs.addCell(compweb);  
					 	}
					 	
					 	if(driver.findElements(By.cssSelector(".org-about-company-module__specialities")).size() > 0){
							String compspecialities = driver.findElement(By.cssSelector(".org-about-company-module__specialities")).getText();
							System.out.println(compspecialities);

						
							//Writing into Excel
							 Label comSpe = new Label(7, +i, compspecialities);
							 jobs.addCell(comSpe);  
					 	}	
					 	
					 	if(driver.findElements(By.cssSelector(".org-about-company-module__company-staff-count-range")).size() > 0){
							String compsize = driver.findElement(By.cssSelector(".org-about-company-module__company-staff-count-range")).getText();
							System.out.println(compsize);

						
							//Writing into Excel
							 Label comSize = new Label(8, +i, compsize);
							 jobs.addCell(comSize);  
					 	}
							 
					 	if(driver.findElements(By.cssSelector(".org-about-company-module__headquarters")).size() > 0){
							String compheadquarters = driver.findElement(By.cssSelector(".org-about-company-module__headquarters")).getText();
							System.out.println(compheadquarters);

						
							//Writing into Excel
							 Label compaddress1 = new Label(9, +i, compheadquarters);
							 jobs.addCell(compaddress1);  
					 	}	 
			 
					driver.navigate().to(url);				
					Thread.sleep(2000);
					
					JavascriptExecutor jsx55 = (JavascriptExecutor)driver;
					jsx55.executeScript("window.scrollBy(0,200)", "");
					
					if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).size() != 0){
						for(int p=1 ; p<=4 ; p++){
						
						if(driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button")).getText().equals("See fewer positions"))
						{
						break;
						}
						else{
						
						driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).click();
						System.out.println("See more Experiance Link Clicked");			
						Thread.sleep(2000);
						}
						
					}
					 }
						JavascriptExecutor jsx23 = (JavascriptExecutor)driver;
						jsx23.executeScript("window.scrollBy(0,200)", "");
				}
				else {
					System.out.println("Company Details are not available");
					driver.navigate().to(url);		
					
					Thread.sleep(1500);
					
					if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).size() != 0){
						for(int p=1 ; p<=4 ; p++){
						
						if(driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button")).getText().equals("See fewer positions"))
						{
						break;
						}
						else{
						
						driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).click();
						System.out.println("See more Experiance Link Clicked");			
						Thread.sleep(2000);
						}
						
					}
					 }
					
						JavascriptExecutor jsx24 = (JavascriptExecutor)driver;
						jsx24.executeScript("window.scrollBy(0,120)", "");
				}
				
			}

		}
		
			
	
		if(expcount2>0){
			System.out.println("Entered into FIRST CSS");
			
			//JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(1000);			
		
		for(int i=st;i<=end;i++){
			
			System.out.println("");
			System.out.println("      ****COMPANY "+i+ " DETAILS***");
			
							
			//Writing into Excel
			 
				JavascriptExecutor jsx2 = (JavascriptExecutor)driver;
				//jsx2.executeScript("window.scrollBy(0,150)", "");			
				
			
		        
		        if(driver.findElements(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h4:nth-child(2)>span:nth-child(2)")).size() != 0){
		        	/*driver.findElement(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h3")).sendKeys(""); // Exp title css
		        	
					action.moveToElement(driver.findElement(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h3")));
					action.sendKeys("");
			        action.build().perform();*/
			        
		        	jsx2.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h3")));
			        
		        	
		        String expcompname = driver.findElement(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h4:nth-child(2)>span:nth-child(2)")).getText();
			System.out.println(expcompname);

			//Writing into Excel
			 Label labe3= new Label(0, +i, contactid);
			 Label compnayname= new Label(1, +i, expcompname);
			 jobs.addCell(labe3);			 
			 jobs.addCell(compnayname);  
			}
			
		
			
			
			if(driver.findElements(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h3")).size() != 0){
			String exptitle = driver.findElement(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h3")).getText();
			System.out.println(exptitle);

			
			//Writing into Excel
			 Label jobtitle = new Label(2, +i, exptitle);
			 jobs.addCell(jobtitle);  			
			}
			
			if(driver.findElements(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h4:nth-child(3)>span:nth-child(2)")).size() != 0){
			String expyears = driver.findElement(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h4:nth-child(3)>span:nth-child(2)")).getText();
			System.out.println(expyears);
			
			String[] split = expyears.split(" � ");
  			String split1 = split[0];
  			String split2 = split[1];
  			
  			if(split1.contains(" ")  && split2.matches("[0-9]+") && split2.length() > 2){						
				
  				String deliverydate1= split1;
  				String deliverydate2= split2;
  				
  				System.out.println("split1 is =" +deliverydate1);
  				System.out.println("split2 is =" +deliverydate2);
  				
  				SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");
  				SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
  				
  				Date date1=sdf1.parse(deliverydate1);
  				Date date2=sdf2.parse(deliverydate2);
  				
  				sdf1=new SimpleDateFormat("MM-dd-yyyy");
  				sdf2=new SimpleDateFormat("01-32-yyyy");
  				
  				String sdf3 = sdf1.format(date1);
  				String sdf4 = sdf2.format(date2);
  				
  				 Label experiancestartdate = new Label(3, +i, sdf3);
  				 jobs.addCell(experiancestartdate); 
  				 System.out.println("Start Date:"+sdf3);

  				 Label experianceenddate = new Label(4, +i, sdf4);
  				 jobs.addCell(experianceenddate);  
  				 System.out.println("End Date:"+sdf4);
  				
  		
  				}
  				
  				
  				if((split1.contains(" "))  && (split2.contains(" "))  && (!split1.equals(split2))){						
  				
  				String deliverydate1= split1;
  				String deliverydate2= split2;
  				
  				SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");
  				SimpleDateFormat sdf2=new SimpleDateFormat("MMM yyyy");
  				
  				Date date1=sdf1.parse(deliverydate1);
  				Date date2=sdf2.parse(deliverydate2);
  				
  				sdf1=new SimpleDateFormat("MM-dd-yyyy");
  				sdf2=new SimpleDateFormat("MM-dd-yyyy");
  				
  				String sdf3 = sdf1.format(date1);
  				String sdf4 = sdf2.format(date2);
  				
  				 Label experiancestartdate = new Label(3, +i, sdf3);
  				 jobs.addCell(experiancestartdate); 
  				 System.out.println("Start Date:"+sdf3);

  				 Label experianceenddate = new Label(4, +i, sdf4);
  				 jobs.addCell(experianceenddate);  
  				 System.out.println("End Date:"+sdf4);			
  		
  				}
  				
  				
  				if(split1.matches("[0-9]+") && split1.length() > 2 && split2.contains(" ")){
  					
  					String deliverydate1= split1;
  					String deliverydate2= split2;
  					
  					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");
  					SimpleDateFormat sdf2=new SimpleDateFormat("MMM yyyy");
  					
  					Date date1=sdf1.parse(deliverydate1);
  					Date date2=sdf2.parse(deliverydate2);
  					
  					sdf1=new SimpleDateFormat("01-32-yyyy");
  					sdf2=new SimpleDateFormat("MM-dd-yyyy");
  					
  					String sdf3 = sdf1.format(date1);
  					String sdf4 = sdf2.format(date2);
  					
  					 Label experiancestartdate = new Label(3, +i, sdf3);
  					 jobs.addCell(experiancestartdate); 
  					 System.out.println("Start Date:"+sdf3);

  					 Label experianceenddate = new Label(4, +i, sdf4);
  					 jobs.addCell(experianceenddate);  
  					 System.out.println("End Date:"+sdf4);	
  					

  				
  				}
  					
  				
  				// Checks only Year(yyyy) and changes to 01-32-yyyy for both start and End date
  				if(split1.matches("[0-9]+") && split1.length() > 2 && (split2.matches("[0-9]+") && split2.length() > 2)){
  					
  					String deliverydate1= split1;
  					String deliverydate2= split2;
  					
  					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");
  					SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
  					
  					Date date1=sdf1.parse(deliverydate1);
  					Date date2=sdf2.parse(deliverydate2);
  					
  					sdf1=new SimpleDateFormat("01-32-yyyy");
  					sdf2=new SimpleDateFormat("01-32-yyyy");
  					
  					String sdf3 = sdf1.format(date1);
  					String sdf4 = sdf2.format(date2);
  					
  					 Label experiancestartdate = new Label(3, +i, sdf3);
  					 jobs.addCell(experiancestartdate); 
  					 System.out.println("Start Date:"+sdf3);

  					 Label experianceenddate = new Label(4, +i, sdf4);
  					 jobs.addCell(experianceenddate);  
  					 System.out.println("End Date:"+sdf4);	
  					
  					
  					
  				}
  				
  				if(split1.matches("[0-9]+") && split1.length() > 2 && split2.equals("Present")){
  					
  					String deliverydate1= split1;
  					String deliverydate2= split2;
  					
  					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");

  					
  					Date date1=sdf1.parse(deliverydate1);

  					
  					sdf1=new SimpleDateFormat("01-32-yyyy");				
  					String sdf3 = sdf1.format(date1);
  					
  					 Label experiancestartdate = new Label(3, +i, sdf3);
  					 jobs.addCell(experiancestartdate); 
  					 System.out.println("Start Date:"+sdf3);

  					 Label experianceenddate = new Label(4, +i, deliverydate2);
  					 jobs.addCell(experianceenddate);  
  					 System.out.println("End Date:"+deliverydate2);	
  					

  					
  				}
  				
  				
  				if(split1.contains(" ") && split2.equals("Present")){
  					
  					String deliverydate1= split1;
  					String deliverydate2= split2;
  					
  					SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");

  					
  					Date date1=sdf1.parse(deliverydate1);

  					
  					sdf1=new SimpleDateFormat("MM-dd-yyyy");

  					
  					String sdf3 = sdf1.format(date1);
  					
  					 Label experiancestartdate = new Label(3, +i, sdf3);
  					 jobs.addCell(experiancestartdate); 
  					 System.out.println("Start Date:"+sdf3);

  					 Label experianceenddate = new Label(4, +i, deliverydate2);
  					 jobs.addCell(experianceenddate);  
  					 System.out.println("End Date:"+deliverydate2);	


  					
  				}
  				
  				if(split1.equals(split2) && (split1.contains(" "))  && (split2.contains(" "))){
  					
  					
  						
  						String deliverydate1= split1;
  						String deliverydate2= split2;
  						
  						SimpleDateFormat sdf1=new SimpleDateFormat("MMM yyyy");				
  						SimpleDateFormat sdf2=new SimpleDateFormat("MMM yyyy");
  						
  						Date date1=sdf1.parse(deliverydate1);
  						Date date2=sdf2.parse(deliverydate2);
  						
  						sdf1=new SimpleDateFormat("MM-dd-yyyy");
  						sdf2=new SimpleDateFormat("MM-99-yyyy");
  						
  						String sdf3 = sdf1.format(date1);				
  						String sdf4 = sdf2.format(date2);
  						
  						
  						 Label experiancestartdate = new Label(3, +i, sdf3);
  						 jobs.addCell(experiancestartdate); 
  						 System.out.println("Start Date:"+sdf3);

  						 Label experianceenddate = new Label(4, +i, sdf4);
  						 jobs.addCell(experianceenddate);  
  						 System.out.println("End Date:"+sdf4);	
  						

  					
  					
  				}
			
			}
				//Company info.
			Thread.sleep(1000);
			
			WebElement element = driver.findElement(By.cssSelector(".pv-profile-section__card-item.pv-position-entity.ember-view:nth-child("+i+")>a>div:nth-child(2)>h4:nth-child(2)>span:nth-child(2)"));
			
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", element);
			System.out.println("Clicked element is "+element);
				Thread.sleep(1000);
				// New Code for Src 
				
				if(driver.findElements(By.cssSelector(".org-top-card-module__container.container-with-shadow.clearfix>img")).size() != 0)
				{
					By by = By.cssSelector(".org-top-card-module__container.container-with-shadow.clearfix>img");
					String explogosrc = driver.findElement(by).getAttribute("src");
					System.out.println("src: "+explogosrc);
					
					boolean  c = explogosrc.startsWith("data");
					
					if(c==false)
						
					{
						 Label exlogo = new Label(15, +i, explogosrc);
						 jobs.addCell(exlogo);  

					}
					else
					{
						System.out.println("Company logo url is not available");
						Label expcomplogo= new Label(15, +i, "Image is not available");
						jobs.addCell(expcomplogo);
					
					}
				}
				
				else
				{
					System.out.println("I am entering without coming into looop");
					System.out.println("Company logo url is not available");
					Label expcomplogo= new Label(15, +i, "Image is not available");
					jobs.addCell(expcomplogo);
				}
			
			
			if(driver.findElements(By.cssSelector(".org-about-us-organization-description__company-heading")).size() != 0){
				
				if(driver.findElements(By.cssSelector("#org-about-company-module__show-details-btn>li-icon>svg>g>path")).size() != 0){
					WebElement element1=driver.findElement(By.cssSelector("#org-about-company-module__show-details-btn"));
					JavascriptExecutor executor2 = (JavascriptExecutor)driver;
					executor2.executeScript("arguments[0].click();", element1);
					//action.moveToElement(driver.findElement(By.cssSelector("#org-about-company-module__show-details-btn>li-icon>svg>g>path"))).click();					
				
				}
				
				if(driver.findElements(By.cssSelector(".org-about-us-organization-description.ember-view>p")).size() != 0){
				String description = driver.findElement(By.cssSelector(".org-about-us-organization-description.ember-view>p")).getText();
				System.out.println(description);

				
				//Writing into Excel
				 Label compdes = new Label(5, +i, description);
				 jobs.addCell(compdes);  	
				}				
				
				 	if(driver.findElements(By.cssSelector(".org-about-us-company-module__website.mb3.link-without-visited-state.ember-view")).size() != 0){
						String comwebsite = driver.findElement(By.cssSelector(".org-about-us-company-module__website.mb3.link-without-visited-state.ember-view")).getText();
						System.out.println(comwebsite);

					
						//Writing into Excel
						 Label compweb = new Label(6, +i, comwebsite);
						 jobs.addCell(compweb);  
				 	}
				 	
				 	if(driver.findElements(By.cssSelector(".org-about-company-module__specialities")).size() != 0){
						String compspecialities = driver.findElement(By.cssSelector(".org-about-company-module__specialities")).getText();
						System.out.println(compspecialities);

					
						//Writing into Excel
						 Label comSpe = new Label(7, +i, compspecialities);
						 jobs.addCell(comSpe);  
				 	}	
				 	
				 	if(driver.findElements(By.cssSelector(".org-about-company-module__company-staff-count-range")).size() != 0){
						String compsize = driver.findElement(By.cssSelector(".org-about-company-module__company-staff-count-range")).getText();
						System.out.println(compsize);

					
						//Writing into Excel
						 Label comSize = new Label(8, +i, compsize);
						 jobs.addCell(comSize);  
				 	}
						 
				 	if(driver.findElements(By.cssSelector(".org-about-company-module__headquarters")).size() != 0){
						String compheadquarters = driver.findElement(By.cssSelector(".org-about-company-module__headquarters")).getText();
						System.out.println(compheadquarters);

					
						//Writing into Excel
						 Label compaddress1 = new Label(9, +i, compheadquarters);
						 jobs.addCell(compaddress1);  
				 	}	 
		 
				driver.navigate().to(url);				
				Thread.sleep(2000);
				
				JavascriptExecutor jsx56 = (JavascriptExecutor)driver;
				jsx56.executeScript("window.scrollBy(0,200)", "");
				
				if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).size() != 0){
					for(int p=1 ; p<=4 ; p++){
					
					if(driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button")).getText().equals("See fewer positions"))
					{
					break;
					}
					else{
					
					driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).click();
					System.out.println("See more Experiance Link Clicked");			
					Thread.sleep(2000);
					}
					
				}
				 }
					JavascriptExecutor jsx22 = (JavascriptExecutor)driver;
					jsx22.executeScript("window.scrollBy(0,120)", "");

			}
			else {
				System.out.println("Company Details are not available");
				driver.navigate().to(url);		
				
				Thread.sleep(1500);
				
				if(driver.findElements(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).size() != 0){
					for(int p=1 ; p<=4 ; p++){
					
					if(driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button")).getText().equals("See fewer positions"))
					{
					break;
					}
					else{
					
					driver.findElement(By.cssSelector(".pv-profile-section.experience-section.ember-view>div>button>span")).click();
					System.out.println("See more Experiance Link Clicked");			
					Thread.sleep(2000);
					}
					
				}
				 }
					JavascriptExecutor jsx3 = (JavascriptExecutor)driver;
					jsx3.executeScript("window.scrollBy(0,120)", "");
			}
			
		}
		
		}
		//Education
		
		System.out.println("***EDUCATION***");		
		
		Thread.sleep(1500);
		
		//JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,550)", "");
		
		
		if(driver.findElements(By.cssSelector(".pv-profile-section.education-section.ember-view>div>button")).size() != 0){
			driver.findElement(By.cssSelector(".pv-profile-section.education-section.ember-view>div>button")).click();
			
			
			System.out.println("See more Education Clicked");
			Thread.sleep(1500);
		}
		
		List<WebElement> edulist = driver.findElements(By.cssSelector(".pv-profile-section.education-section.ember-view>ul>li"));
		int educount = edulist.size();
		
		System.out.println("Total "+educount+" Education Records found");
		
		if(educount ==0){
			
			 Label edunotavailable = new Label(2, 1, "Education Details are not Available");
			 education.addCell(edunotavailable); 			
			
		}
		
		else{
		
		for(int i=1;i<=educount;i++){	
			System.out.println("");
			System.out.println("		***EDUCATION "+i+" DETAILS***");
			
			
			// School Name
			if(driver.findElements(By.xpath("(//*[contains(@class, 'pv-entity__school-nam')])["+i+"]")).size() != 0){
				String empschool = driver.findElement(By.xpath("(//*[contains(@class, 'pv-entity__school-name')])["+i+"]")).getText();
				
				//Writing into Excel
				 Label labe3= new Label(0, +i, contactid);
				 Label SchoolName = new Label(1, +i, empschool);
				 education.addCell(labe3);  
				 education.addCell(SchoolName);  
				 System.out.println("SCHOOL NAME: "+empschool);
			}
			
			
			// Degree Name
			if(driver.findElements(By.xpath("(//*[contains(@class, 'pv-entity__degree-name')])[position()="+i+"]/following-sibling::p/span[2]")).size() != 0){
				String empdegree = driver.findElement(By.xpath("(//*[contains(@class, 'pv-entity__degree-name')])[position()="+i+"]/following-sibling::p/span[2]")).getText();
				
				//Writing into Excel
				
				 Label edudegree = new Label(2, +i, empdegree);
				 education.addCell(edudegree);  
				 System.out.println("DEGREE:" +empdegree);
			}
			
			// Degree Type
			if(driver.findElements(By.xpath("(//*[contains(@class, 'pv-entity__degree-name')])[position()="+i+"]/span[2]")).size() != 0){
				String empdegreetype = driver.findElement(By.xpath("(//*[contains(@class, 'pv-entity__degree-name')])[position()="+i+"]/span[2]")).getText();
				
				//Writing into Excel
				
				 Label edudegreetype = new Label(3, +i, empdegreetype);
				 education.addCell(edudegreetype);  	
				 System.out.println("EDUCATION TYPE: "+empdegreetype);
			}
			
			// Graduation Year
			if(driver.findElements(By.xpath("((//*[contains(@class, 'pv-entity__dates')])/span[2])["+i+"]")).size() != 0){
				String empgrdyear = driver.findElement(By.xpath("((//*[contains(@class, 'pv-entity__dates')])/span[2])["+i+"]")).getText();
				
				//Writing into Excel	
				
				if(empgrdyear.contains(" � ")){
					
					String[] split = empgrdyear.split(" � ");
		  			String split1 = split[0];
		  			String split2 = split[1];
		  			
					 Label GraduationYear = new Label(4, +i, split2);
					 education.addCell(GraduationYear); 
					 System.out.println("GRADUATION YEAR: "+split2);
					
				}
				else{
					
				 Label GraduationYear = new Label(4, +i, empgrdyear);
				 education.addCell(GraduationYear); 
				 System.out.println("GRADUATION YEAR: "+empgrdyear);
				}
			}
			
			// Activities
			/*if(driver.findElements(By.xpath("((//*[contains(@class, 'activities-societies')]))["+i+"]")).size() != 0){
				String empactivities = driver.findElement(By.xpath("((//*[contains(@class, 'activities-societies')]))["+i+"]")).getText();*/
				
				
				// New Code
			
			if(driver.findElements(By.xpath("((//*[contains(@class, 'pv-entity__dates')])/span[2])["+i+"]")).size() != 0){
				
			if(driver.findElements(By.cssSelector(".pv-profile-section.education-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>p:nth-child(3)>span:nth-child(2)")).size() != 0){
				String empactivities = driver.findElement(By.cssSelector(".pv-profile-section.education-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>p:nth-child(3)>span:nth-child(2)")).getText();
				
					//Writing into Excel				

				 Label activities = new Label(5, +i, empactivities);
				 education.addCell(activities); 
				 System.out.println("ACTIVITIES: "+empactivities);
			}
			
		}
			
			else
			{
				
				if(driver.findElements(By.cssSelector(".pv-profile-section.education-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>p>span:nth-child(2)")).size() != 0){
					String empactivities = driver.findElement(By.cssSelector(".pv-profile-section.education-section.ember-view>ul>li:nth-child("+i+")>div>a>div:nth-child(2)>p>span:nth-child(2)")).getText();
					
						//Writing into Excel				

					 Label activities = new Label(5, +i, empactivities);
					 education.addCell(activities); 
					 System.out.println("ACTIVITIES: "+empactivities);
				}
				
			}
		}
		
		}
		
		// Skills
		
		
		jsx.executeScript("window.scrollBy(0,850)", "");
		Thread.sleep(1500);
		
		
		System.out.println("	***SKILLS***");
		//if(driver.findElements(By.cssSelector(".pv-featured-skills-list.pv-profile-section__section-info.section-info.pv-featured-skills-list--include-highlights>li:nth-child(1)>div:nth-child(1)>div>a>div>span:nth-child(1)")).size() > 0){
		if(driver.findElements(By.cssSelector(".pv-skill-entity__pill-contents.static-pill")).size() > 0){
		
		
			for(int i=1; i<=3 ; i++){
				
				if(driver.findElements(By.xpath("(//*[contains(@class, 'pv-skill-entity__skill-name')])["+i+"]")).size() != 0){
					String empskill = driver.findElement(By.xpath("(//*[contains(@class, 'pv-skill-entity__skill-name')])["+i+"]")).getText();
					
					//Writing into Excel					
					 Label labe3= new Label(0, +i, contactid);
					 skills.addCell(labe3); 
					 Label Skill = new Label(1, +i, empskill);
					 skills.addCell(Skill);  
					 
					 System.out.print(empskill+"	");
					 
				}
				
				if(driver.findElements(By.xpath("(//*[contains(@class, 'pv-skill-entity__endorsement-count')])["+i+"]")).size() != 0){
					String empendo = driver.findElement(By.xpath("(//*[contains(@class, 'pv-skill-entity__endorsement-count')])["+i+"]")).getText();
					
					//Writing into Excel					

					 Label Endorsements = new Label(2, +i, empendo);
					 skills.addCell(Endorsements);  
					 System.out.print(empendo);
					 System.out.println("");
					 
				}
								
			}				
	}
		
		else {
			System.out.println("Skills not found");		
			 Label Endorsements = new Label(2, 1, "Skills not found");
			 skills.addCell(Endorsements); 


		}
		
		System.out.println("");
		System.out.println(""+contactid+": DATA FETCHING IS SUCCESSFULLY COMPLETED");
		
		  // Excel
		    book.write();
		    book.close();
		    
		    
		    // File Renaming
		    
	        File oldfile =new File("C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\Test.xls");
	        File newfile =new File("C:\\Users\\rajesh.kondapi\\Desktop\\Linkedln\\"+contactid+".xls");

	        if(oldfile.renameTo(newfile))
	        {
	        	System.out.println("File renamed");
	        }
	        
	        else
	        {
	            System.out.println("Sorry! the file can't be renamed");
	        }
	        
	        System.out.println("ROW "+row+" IS COMPLETED");
		    
		}
			
		}
		
		else{
			System.out.println("URL ECXEL IS EMPTY");
		}
		driver.quit();
		System.out.println("Data Extraction Completed");

	}
	
	
	public static void readDataFromExcel(){
		
	}
	
}
	