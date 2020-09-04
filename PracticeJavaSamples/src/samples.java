import java.util.Scanner;

public class samples {
	
	public static void main(String[] args) {
	String s=  "Weeeclommm";
	
	Scanner ip = new Scanner(System.in);
	System.out.println("Enter String = ");
	char[] c = ip.next().toString().toCharArray();
	int cnt=0;
 	for (int i=0; i<ip.nextLine().length() ;i++) {
		for(int j=i+1; j<ip.nextLine().length();j++) {
			if(c[j] == c[i]) {
				System.out.println(c[j]);
				cnt++;
			}
		}
		
	}
	}

}
