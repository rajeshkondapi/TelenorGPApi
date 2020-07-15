package datatypedemo;

public class DynamicString {

	public static void main(String[] args) {
		String abc="This is Updated number 14572";
		String d=abc.substring(22);
		System.out.println(d);
		String e="14572 is Updated number ";		
		String f=e.substring(0);
		String g=e.substring(0,5);
		System.out.println(f);
		System.out.println(g);

	}

}
