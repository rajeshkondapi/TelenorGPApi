package paramater;

public class ParameterDemo {

	public static void main(String[] args) {
		ParameterDemo obj1= new ParameterDemo();
		obj1.add(599, 233);
		obj1.sub(544.25, 125.45);
		

	}
	public void add(int a , int b){
		int c=a+b;
		System.out.println("Hey Result is "+c);
	}
		
	public void sub(double x,double y){
		double result=y-x;
		
		System.out.println("Hey Result is "+result);
}
}
