import java.util.HashMap;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class EvenOddArray {

	public static void main(String[] args) {
		HashMap<String, String> mn = new HashMap<>();
		mn.put("Rajesh", "Kondapi");
		System.out.println(mn.get("Rajesh"));
		
		
		int a[]={1,2,3,4,5,6,7,8,9,10,11,12};
		System.out.println(a.length);
		
		for(int i=0;i<a.length;i++){
			if(a[i]%2==0){
				
				System.out.println("Even Numbers are = "+a[i]);
			}
			else{
				System.out.println("odd Numbers are = "+a[i]);
			}
			
		}
		
		String s = "Rajesh";
		char[] revere = s.toCharArray();
		String rev = "";
		for(int j=revere.length - 1; j>=0; j--) {
			rev = rev + revere[j]; 
		}
		System.out.println(rev);
		exm();

	}
	
	static WebDriver driver;
	
	public static void exm() {
	/*Set<String> s = driver.getWindowHandles();
	ListIterator<String> ls = (ListIterator<String>) s.iterator();
	while(ls.hasNext()) {
		String childwindow = ls.next();

driver.switchTo().window(childwindow);*/

	}
	
	
	}
	


