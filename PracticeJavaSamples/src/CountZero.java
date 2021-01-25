import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountZero {

	static int HasZero(int x) {

		int count=0;
		
		String number = String.valueOf(x);

		char[] digits1 = number.toCharArray();	

		for (char a : digits1) {			
			if(a == '0') 
				count++;				
		}				
		return count++;		
	}

	static int GetCount(int n) 
	{ 

		int count = 0;       
		for (int i = 1; i <= n; i++) 
			count += HasZero(i);       
		return count; 
	} 

	public static void main(String[] args) {

		int res =  GetCount(100);
		System.out.println("reslt= "+res);

	}
}

