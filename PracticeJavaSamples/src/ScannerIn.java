import java.util.Scanner;

public class ScannerIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1,Str2;
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter Frist String 1 :");
		str1 = ip.nextLine();
		//System.out.println("Str1 = "+str1);
		
		System.out.println("Enter Second String 2 :");
		Str2 = ip.nextLine();
		System.out.println("Your Details = "+Str2 +" "+str1);
	}

}
