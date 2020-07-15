package test_automation_webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class facebookreg {

public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver", "D:\\library sel\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.get("https://www.facebook.com/");
driver.findElement(By.xpath(".//*[@id='u_0_2']")).sendKeys("Rajeshkondapi");
driver.findElement(By.xpath(".//*[@id='u_0_i']")).click();
Select sel1=new Select(driver.findElement(By.xpath(".//*[@id='day']")));
sel1.selectByValue("2");
Select sel2=new Select(driver.findElement(By.xpath(".//*[@id='month']")));
sel2.selectByVisibleText("May");
Select sel3=new Select(driver.findElement(By.xpath(".//*[@id='year']")));
sel3.selectByIndex(5);
driver.findElement(By.xpath(".//*[@id='u_0_m']")).click();
driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
driver.navigate().back();
}

}