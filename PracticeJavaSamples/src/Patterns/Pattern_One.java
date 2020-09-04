package Patterns;

public class Pattern_One {
	
	
	static void pattern1() {
		System.out.println("Pattern Type 1: ");
		System.out.println();
		for (int i = 1; i<=10;i++) {
			for(int j =1; j<=i;j++) {
				System.out.printf("%3d",j); // try with i
			}
			System.out.println();
		}
		
		

	}
	
	static void pattern2() {
		System.out.println("Pattern Type 2: ");
		System.out.println();
		for (int i = 10; i>=1;i--) {
			for(int j =10; j>=i;j--) {
				System.out.printf("%3d",j); // try with i
			}
			System.out.println();
		}

	}
	
	static void pattern3() {
		System.out.println("Pattern Type 3: ");
		System.out.println();
		for (char ch = 'a'; ch<='z';ch++) {
			for(int ch2 ='a'; ch2<=ch;ch2++) {
				System.out.printf("%3c",ch2); // try with ch
			}
			System.out.println();
		}

	}
	
static void pattern4() {
	
	System.out.println("Pattern 4:");
	System.out.println();
	char ch = '*';
	for(int i=1; i<=10; i++) {
		for(int j=1; j<=i; j++) {
			System.out.printf("%10C", ch);				
		}
		
		System.out.println();
	}//System.out.println();
	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pattern3();
		System.out.println();
		//pattern2();
		System.out.println();
		//pattern3();
		System.out.println();
		//pattern4();
		System.out.println();
		//pattern5();
		
		
	}

}
