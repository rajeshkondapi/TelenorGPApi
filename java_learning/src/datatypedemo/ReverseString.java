package datatypedemo;

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
     // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("d-");
        
        //get current date time with Date()
        Date date = new Date();
        
        // Now format the date
        String date1= dateFormat.format(date);
        System.out.println(date1);
        
        String strDateFormat = "EEEE";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println("Current day in dd format : " + sdf.format(new Date()));
        
       
        
	}
}
    

		
