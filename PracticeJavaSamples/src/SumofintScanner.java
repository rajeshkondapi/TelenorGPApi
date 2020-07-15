import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SumofintScanner {

	public static void main(String[] args) {
		String a;
		// TODO Auto-generated method stub
		int b,c;
		
		/*Scanner ip= new Scanner(System.in);
		System.out.print("Enter first num: ");
		//int num1= ip.nextInt();
		//System.out.println("num1 = "+num1);
		StringBuilder input1 = new StringBuilder(); 
		input1.append(ip.nextLine());
		//System.out.println(input1);
		StringBuilder input2 = new StringBuilder();	
		
		//String str = "w3schools";
		  int cnt = 0;
		  char[] inp = input1.toString().toCharArray();
		  System.out.println("Duplicate Characters are:");
		  for (int i = 0; i < input1.toString().length(); i++) {
		   for (int j = i + 1; j < input1.toString().length(); j++) {
		    if (inp[i] == inp[j]) {
		     System.out.println(inp[j]);
		     
		     input2.append(inp[j]).toString();
		     System.out.println("input2 = "+input2);
		     cnt++;
		     break;
		    }
		   }
		  }
		*/
			
			//System.out.println(input1.reverse());
		/*int x, y,t;
		String fn, ln, fl;
		Scanner ip= new Scanner(System.in);
		System.out.print("Enter fn num: ");
		fn= ip.next();
		System.out.print("Enter ln num: ");
		ln =ip.next();
		
		System.out.println("Before Swap");
		//System.out.println("x = "+x +" and "+ "y = "+y );
		System.out.println("fn = "+fn +" and "+ "ln = "+ln );
		t=x;
		x=y;
		y=t;
		
		fl = fn;
		fn=ln;
		ln=fl;
		System.out.println("After Swap");
		
		//System.out.println("x = "+x +" and "+ "y = "+y );
		System.out.println("fn = "+fn +" and "+ "ln = "+ln );
		*/
		
		/* String original, reverse = ""; // Objects of String class  
	      Scanner in = new Scanner(System.in);   
	      System.out.println("Enter a string/number to check if it is a palindrome");  
	      original = in.nextLine();   
	      int length = original.length();   
	      for ( int i = length - 1; i >= 0; i-- )  
	         reverse = reverse + original.charAt(i);
	      		System.out.println(reverse+" = REverser");
	      if (original.equals(reverse))  
	    	
	         System.out.println("Entered string/number is a palindrome.");  
	      else  
	         System.out.println("Entered string/number isn't a palindrome.");   
	   }  */
		
		/*String key, value;
		
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter key = ");
		 key = in.next();
		 System.out.println("Enter value = ");
		 value = in.next();
		 
		 Map<String,String>  mp = new LinkedHashMap<String,String>();
		 mp.put(key, value);
		 
		 System.out.println(mp);
		 System.out.println(mp.get(key));
	}*/
		
		Map<String, String> map = new HashMap<String, String>();
	      map.put("One", "1");
	      map.put("Five", "5");
	      map.put("Four", "4");
	      map.put("Two", "2");
	      map.put("Three", "3");
	      System.out.println("HashMap: \n" + map);

	      Map<String, String> map1 = new LinkedHashMap<String, String>();
	      map1.put("One", "1");
	      map1.put("Five", "5");
	      map1.put("Four", "4");
	      map1.put("Two", "2");
	      map1.put("Three", "3");
	      System.out.println("LinkedHashMap: \n" + map1);

	      Map<String, String> map2 = new TreeMap<String, String>();
	      map2.put("One", "1");
	      map2.put("Five", "5");
	      map2.put("Four", "4");
	      map2.put("Two", "2");
	      map2.put("Three", "3");
	      System.out.println("TreeMap: \n" + map2);
	   }
		 
			
	
		
		//b = ++a;
		/*ArrayList<Integer> ar = new ArrayList<Integer>(); 	
		
		for (String bb:a.charAt(a.length())) {
			
			ar.add(u);
			System.out.println("Adding == "+ar);
		}
			System.out.println("Size of array === "+ar.size());
			
			ArrayList<Integer> revarr = new ArrayList<Integer>();
			
			for (int k= ar.size()-1; k>=0; k--) {
						//k=6		
				revarr.add(ar.get(k));
				System.out.println("Reverse = ="+revarr);		
			
		}
		
		System.out.println("a =  "+a);
		//System.out.println("b =  "+b);
		
		int[] a1 = new int[]{ 1,2,3,4,5,6,8,8,9,9,10 };
		System.out.println(a1.length);
		for (int f= 0; f<a1.length;f++) {
			for(int h=f+1;h<a1.length;h++) {
				if(a1[f]==a1[h]) {
					System.out.println(a1[h]);
				}
			}
		}*/
		
		
		//Scanner ip= new Scanner(System.in);
		/*System.out.print("ENter Second num: ");
		int num2= ip.nextInt();
		System.out.println("num1 = "+num2);*/
		
		
		//float sum= num1+ num2;
		/*if(num1>num2) {
			System.out.println("num1 is bigger");
		} else if(num1<num2) {
			System.out.println("num2 is bigger");
		} else {
			System.out.println("same");
		}*/
		//System.out.println(sum);
		
		
//		System.out.print("ENter first name: ");
//		String FN= ip.nextLine();
//		System.out.println("FN = "+FN);
//		
//		//Scanner ip= new Scanner(System.in);
//		System.out.print("ENter Second name: ");
//		String LN= ip.nextLine();
//		System.out.println("LN = "+LN);
//		
//		System.out.println(LN +" "+ FN);
		
		
		

	

}
