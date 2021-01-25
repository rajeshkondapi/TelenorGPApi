import java.util.Scanner;

	public class PrimeNumberVerification {
	    public static void main(String args[])
	    {       
	        int i, j;
	        System.out.print("Enter any number which you want to verify whether it is a prime number or not :");
	        Scanner s = new Scanner(System.in);
	        j = s.nextInt();
	        if(j%2 == 0) {
	        	System.out.println("not prime");
	        	} else {
	        		System.out.println("prime");
	        	}
	        }
	       
	}

