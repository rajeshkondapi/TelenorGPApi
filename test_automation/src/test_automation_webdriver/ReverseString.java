package test_automation_webdriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReverseString {
	

	public static void main(String[] args) {
	
 
        String originalString = "Rajesh";

       
        String reverseString = "";

        int length = originalString.length();
        System.out.println(length);

       
        for(int i=originalString.length()-1; i>=0;i--){
        	

       
           reverseString = reverseString+originalString.charAt(i);
           
           
           
}
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println("Current time is " +date1);
        
       
        
	}
}
    

		
