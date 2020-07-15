package TelenorGp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.StringEncoderComparator;

import com.google.protobuf.Int32Value;

public class datetime {

	
		
		
	  
	    // Driver code 
	    public static void main(String[] args) 
	    {
	    	Random random = new Random();
	        ArrayList<Integer> arrayList = new ArrayList<Integer>();

	        while (arrayList.size() < 6) { // how many numbers u need - it will 6
	            int a = random.nextInt(49)+1; // this will give numbers between 1 and 50.

	            if (!arrayList.contains(a)) {
	                arrayList.add(a);
	            }
	        }
	    
	    } 

	}
	
	
	

