import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
public class BrowserStack {

  /*public static final String USERNAME = "rajeshkondapi1";
  public static final String AUTOMATE_KEY = "V8MRVsND9psWijxiDaxY";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browserName", "android");    
    //caps.setCapability(MobileCapabilityType.UDID, "4d0082a64a9d41c7");
	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
   
    caps.setCapability("real_mobile", "true");
    caps.setCapability("project", "BrowserTest");
    caps.setCapability("build", "BrowserTestBuild");
    caps.setCapability("name", "BrowserTestName");
    caps.setCapability("browserstack.local", "false");
    caps.setCapability("browserstack.debug", "true");
    caps.setCapability("browserstack.networkLogs", "true");
    caps.setCapability("browserstack.timezone", "India");


    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com/ncr");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("Cricbuzz");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }*/
	
	 public static String userName = "rajeshkondapi1";
	  public static String accessKey = "V8MRVsND9psWijxiDaxY";

	  public static void main(String args[]) throws MalformedURLException, InterruptedException {
	    DesiredCapabilities caps = new DesiredCapabilities();

	   
	caps.setCapability("os_version", "9.0");
	    caps.setCapability("project", "My First Project");
	    caps.setCapability("build", "My First Build");
	    caps.setCapability("name", "ooredoo");
	    caps.setCapability("app", "https://apps.imimobile.com/mgw/app/AAPL9K");
	    

	    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

	    /* Write your Custom code here */

	    driver.quit();
	  }
}



