import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatefromArray {

	public static void main(String[] args) {
		/*int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
		int current = input[0];
		boolean found = false;

		for (int i = 0; i < input.length; i++) {
		    if (current == input[i] && !found) {
		        found = true;
		    } else if (current != input[i]) {
		        System.out.print(" " + current);
		        current = input[i];  // current value changes here 
		        found = false;
		    }
		}
		System.out.print(" " + current); 

	}
		
		int[] a = {1,2,3,4,5};
		int[] b = {1,6,7,5,2};
		
		for(int i =0; i<a.length;i++) {
		if(a[i]==b[i]) {
			System.out.println("DUplicate");
		}
		else {
			System.out.println("Not Equal");
			}
		}
	}
	*/
		String str = "1,280 AVAILABLE POINTS";
		System.out.println(str.replaceAll("[^a-zA-Z0-9]", ""));
		
		List<String> arr = new ArrayList<String>(4); 
		  
        // using add() to initialize values 
        // ["geeks", "for", "geeks"] 
        arr.add("geeks"); 
        arr.add("for"); 
        arr.add("10 available points"); 
      String s="";
      for(String str1 : arr) {
    	  
    	  if(str1.contains("available points")) {
    		 s=str1;
    		 break;
    		 
    	  }
    	  
      }
      if(!s.isEmpty()) {
    	  System.out.println("value = "+s);
    	  System.out.println("value after = "+s.replaceAll("[^0-9]", ""));
      }
      
		
		
	}

}
