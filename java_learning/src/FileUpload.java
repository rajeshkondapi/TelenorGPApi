public class FileUpload {

public static void main(String[] args) {
WebDriver driver=new FirefoxDriver();
driver.manage().window().maximize();
driver.get("https://www.mycontactform.com/samples.php");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElement(By.id("attach4589")).sendKeys("E:\\ssss.xls");