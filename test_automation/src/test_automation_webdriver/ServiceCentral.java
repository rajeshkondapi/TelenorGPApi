package test_automation_webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServiceCentral {

public static void main(String[] args) throws Exception {
System.setProperty("webdriver.gecko.driver", "E:\\library sel\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.get("http://servicecentral.sagarsoft.com/");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element = wait.until(
  ExpectedConditions.visibilityOfElementLocated(By.name("login"))
);
element.sendKeys("SIL-0400");
WebElement element1 = wait.until(
  ExpectedConditions.visibilityOfElementLocated(By.name("password"))
);
element1.sendKeys("Krajesh1234");
driver.findElement(By.name("submit")).click();

WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/table/tbody/tr[1]/td/ul/li[4]/a/span")));
Actions act=new Actions(driver);
act.contextClick(element2).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
System.out.println("i am here");

}
}




