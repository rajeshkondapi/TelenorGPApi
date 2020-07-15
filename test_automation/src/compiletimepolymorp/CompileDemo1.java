package compiletimepolymorp;

public class CompileDemo1 {

	public static void main(String[] args) {
		CompileDemo1 obj1=new CompileDemo1();
		obj1.add(45, 45);
		obj1.add(44, 45, 46);
		obj1.add(33.44, 44.55);
		obj1.add(66.77, 45);
		obj1.add(44, 22.2);

	}
	public void add(double a , int b){
		double sum=a+b;//type casting=as int is converted to double
		System.out.println("Sum is " +sum);
	}
	public void add(int a , double b){
		double sum=a+b;//type casting=as int is converted to double
		System.out.println("Sum is " +sum);
	}
	public void add(double a , double b){
		double c = a+b;
		System.out.println("Sum is " +c);
	}
	public void add(int a , int b){
		int c = a+b;
		System.out.println("Sum is " +c);
	}
	public void add(int a , int b, int d){
		int c = a+b+d;
		System.out.println("Sum is " +c);
	}

}
//in this we have same method with different signature's
//signature is nothing but type of argument, order of argument,no.of argument
//these are called method overloading