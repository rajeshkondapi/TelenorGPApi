package Patterns;

public class Pattern_One2 {
	
	
	static void pattern1() {
		System.out.println("Pattern Type 1: ");
		System.out.println();
		for (int i = 1; i<=10;i++) {
			for(int j =1; j<=10;j++) {
				System.out.printf("%3d",i);
			}
			System.out.println();
		}
		
		

	}
	
static void pattern2() {
	System.out.println("Pattern Type 2: ");
	System.out.println();
		for (int i = 1; i<=10;i++) {
			for(int j =1; j<=10;j++) {
				//%3d - Print an integer, taking minimum 3 spaces
				System.out.printf("%3d",j);
			}
			System.out.println();
		}
		

	}

static void pattern3() {
	System.out.println("Pattern Type 3: ");
	System.out.println();
	int count = 1; 
		for (int i = 1; i<=10;i++) {
			for(int j =1; j<=10;j++) {
				//%3d - Print an integer, taking minimum 3 spaces
				System.out.printf("%5d",count++);
			}
			System.out.println();
		}
		

	}

static void pattern4() {
	//same of pattern 3 but diff approach
	
	System.out.println("Pattern Type 4: ");
	System.out.println();
	
		for (int i = 1; i<=100;i++) {
			System.out.printf("%5d",i);
				if(i % 10 == 0) {  // remainder to be 0
				//%3d - Print an integer, taking minimum 3 spaces
					System.out.println();
			}
			//System.out.println();
		}
		

	}


static void pattern5() {
	System.out.println("Pattern Type 5: ");
	System.out.println();
	//int count = 1; 
		for (int i = 1; i<=10;i++) { 
			for(int j =10; j>=1;j--) {
				//%3d - Print an integer, taking minimum 3 spaces
				System.out.printf("%5d",j);
			}
			System.out.println();
		}
		

	}

static void pattern6() {
	System.out.println("Pattern Type 6: ");
	System.out.println();
	//int count = 1; 
		for (int i = 10; i>=1;i--) { 
			for(int j =1; j<=10;j++) {
				//%3d - Print an integer, taking minimum 3 spaces
				System.out.printf("%5d",i);
			}
			System.out.println();
		}
		
	}



static void pattern7() {
	System.out.println("Pattern 7 :");
	for(int i=1; i<=10; i++) {
		System.out.printf("%4c", (char) (i+64));
	}
}

static void pattern8() {
	System.out.println("Pattern 7 :");
	for(int i=1; i<=10; i++) {
		for(int j=1; j<=10; j++) {
		System.out.printf("%4c", (char) (j+64));
	}
		System.out.println();
	}
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pattern1();
		System.out.println();
		//pattern2();
		System.out.println();
		//pattern3();
		System.out.println();
		//pattern4();
		System.out.println();
		//pattern5();
		System.out.println();
		//pattern6();
		System.out.println();
		pattern8();
		
	}

}
