package datatypedemo;

public class Test1 extends Address {
	//String country;
	Address country;

	public void display(int id, String name){
		System.out.println("hello "+name+" your new id number is "+id);
		
	}
	public void Address(Address country){
		this.country = country;
		
		
		
	}

	public static void main(String[] args) {
		Test1 obj=new Test1();
		obj.display(1,"Rajesh");
		obj.display1("India");
		
		
		
		

	}

}
