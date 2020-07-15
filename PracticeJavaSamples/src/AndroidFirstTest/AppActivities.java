
package AndroidFirstTest;

import java.io.IOException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AppActivities {
	public static AndroidDriver<MobileElement> driver;
	static DesiredCapabilities cap = new DesiredCapabilities();
	
	
public static void activity() {
	
	//cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
	
	WebElement accept = driver.findElement(By.id("com.ooredoo.selfcare:id/tv_accept"));
	accept.click();
	
}

	public static void main(String[] args) throws IOException {
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung A8+");
		cap.setCapability(MobileCapabilityType.UDID, "520074b4ee426523");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");		
		cap.setCapability("appPackage", "com.ooredoo.selfcare");				
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");		
		cap.setCapability("appActivity", "com.ooredoo.selfcare.Ooredoo");	
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		System.setProperty("webdriver.http.factory", "apache");
		
		driver = new AndroidDriver<MobileElement>(url,cap);
		
		activity();
		
		
		
	}

}
