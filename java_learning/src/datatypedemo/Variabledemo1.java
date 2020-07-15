package datatypedemo;

public class Variabledemo1 {
	static int mynumber; //global variable ->contains null or default value
	public static void main(String[] args) {
		int a=1; // local variable ->contains garbage value
		System.out.println(a);
		System.out.println(mynumber);
	}

}
