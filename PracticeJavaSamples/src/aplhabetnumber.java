import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class aplhabetnumber {
	
	
	public static void main(String[] args) throws IOException {
		char c;
		int i=1;
		for (c='A'; c<='Z'; c++,i++) {
				//System.out.print(c+ "" +i + " ");
				//i++;
				//}
		}
		
		String s = "Hello world i m in 2020 year on 9th july";
		String snc= new Scanner(s).useDelimiter("[^\\d]").next();
		System.out.println(snc);
		System.out.println(s.replaceAll("[^0-9]", ""));
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rajesh.k\\Downloads\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url="";
		HttpURLConnection huc = null;
		int respocode= 200;
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/popup.php");
		
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		String parentWindowHandle = driver.getWindowHandle();
		 System.out.println("Parent window's handle -> " + parentWindowHandle);
		 
		 Set <String> s1 =  driver.getWindowHandles();
		 Iterator<String> it1 = s1.iterator();
		 while (it1.hasNext())
		 {
			 String childwindow =  it1.next();
			 
			 if(!parentWindowHandle.equalsIgnoreCase(childwindow)) {
				 driver.switchTo().window(childwindow);
				 System.out.println("In window child");
				 driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
				 driver.findElement(By.name("btnLogin")).click();
				 driver.close();
			 }
			 
			 driver.switchTo().window(parentWindowHandle);
			 
			 System.out.println("In window parent");
			 
		 }
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()) {
			url = it.next().getAttribute("href");
			System.out.println(url);
			if(url == null || url.isEmpty()) {
				System.out.println("Broken urls");
				continue;
			}
			
			if(!url.startsWith("http://www.zlti.com")) {
				System.out.println("RL belongs to another domain, skipping it");
				continue;
			}
			
			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				respocode = huc.getResponseCode();
				if(respocode >=400) {
					System.out.println("Broken links are provides");
				} else {
					System.out.println("Good urls");
				}
				
			} catch(MalformedURLException mal) {
				mal.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		/*driver.get("https://toolsqa.com/");
		List<WebElement> ll = driver.findElements(By.tagName("a"));
		System.out.println(ll.size());
		for (int y =1; y<ll.size();y++) {
			System.out.println(ll.get(y).getText());
			System.out.println(ll.get(y).getTagName());
		}*/
		
		
		System.out.println(driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		System.out.println(driver.manage().getCookies());
		driver.close();
	}
	
	
}


//A1 B2 C3 ... Z26