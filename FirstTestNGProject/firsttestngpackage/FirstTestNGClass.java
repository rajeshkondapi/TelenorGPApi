package firsttestngpackage;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class FirstTestNGFile {
	 public String baseUrl = "https://www.guru99.com/all-about-testng-and-selenium.html";
	 //System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
	    //String driverPath = "C:\\geckodriver.exe";
	    public WebDriver driver ; 
  @Test
  public void verifyHomepageTitle() {
      
      System.out.println("launching firefox browser"); 
      //System.setProperty("webdriver.firefox.marionette", driverPath);
      System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      System.out.println("Verified");
      driver.close();
  }
}
}
