package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {
	
	public static void captureScreenshot(WebDriver driver, String screenshotname){
		
		try {
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//TakesScreenshot ts=((TakesScreenshot)driver); // we are typecasting driver to takescreen shot forcefully , using () we type caste any method
			
			//File source=ts.getScreenshotAs(OutputType.FILE); //file is class importing from java package
			
			FileUtils.copyFile(scrFile, new File("./screenshots/" +screenshotname+ ".PNG"));
			
			System.out.println("Done Screeenshot !!");
		}
		catch (Exception e) {
			System.out.println("Exception while testing "+e.getMessage());
			
	}

}
}
