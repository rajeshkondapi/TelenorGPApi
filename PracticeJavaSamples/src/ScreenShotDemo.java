import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShotDemo{

	//String driverExecutablePath = "lib\\chromedriver.exe";
	WebDriver driver;
	String result;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "E:\\library sel\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//Set implicit wait of 3 seconds
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	
	@Test
	//Tests google calculator
	public void googleCalculator() throws IOException{
		
		//Launch google
		driver.get("http://www.google.co.in");
		
		//Write 2+2 in google textbox
		WebElement googleTextBox = driver.findElement(By.id("lst-ib"));
		googleTextBox.sendKeys("5+8");
		
		//Hit enter
		googleTextBox.sendKeys(Keys.ENTER);
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.id("cwtltblr"));
		result = calculatorTextBox.getText();
		
		//Intentionaly checking for wrong calculation of 2+2=5 in order to take screenshot for failing test
		//Assert.assertEquals(result, "14");
	}
		
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("ITestResult= "+ITestResult.FAILURE);
			System.out.println("Result is= "+testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:\\Selenium\\PracticeJavaSamples\\errorScreenshots" + testResult.getName() + "-" 
					+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
			//driver.close();
	   }  
		else{
			System.out.println("Your result is "+result);
		}
	}
	
}