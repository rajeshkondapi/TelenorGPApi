import java.util.Scanner;

public class ReverseString {
	
	
	public static void printnextlines() {
		String ss = "Rajesh \n is \n a Crcikert";
		Scanner sss = new Scanner(ss);
		System.out.println(sss.nextLine());
		System.out.println(sss.nextLine());
		System.out.println(sss.nextLine());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printnextlines();
		
		System.out.println("Enter String to reverse :");
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = "";
		for(int i=s.length()-1; i>=0;i--) {
			
			 reverse = reverse + s.charAt(i);
			
		}
		System.out.println(reverse);
		
		if(reverse.equalsIgnoreCase(s)) {
			System.out.println("String is palinddrome");
		} else {
			System.out.println("Not a Palindrome");
		}
	}
	//https://moometric.com/development/java/reverse-a-string-in-java/

}
