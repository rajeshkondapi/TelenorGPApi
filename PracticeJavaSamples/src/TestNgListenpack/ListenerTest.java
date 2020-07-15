package TestNgListenpack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//package.listenerclassname.class
@Listeners(TestNgListenpack.TestNgListener.class)
public class ListenerTest {
	
	@Test
	public void googleverify() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rajesh.k\\Downloads\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		
	}
	@Test
	public void failegoogle() {
		System.out.println("Fail Example");
		
		org.testng.Assert.assertTrue(false);
	}

}
