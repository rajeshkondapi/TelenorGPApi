/*
class SuperUsage_Animal1 {
		String color = "Red";
}	
		class dog extends SuperUsage_Animal1 {
		String color = "Blue";
		
		void display_color(){
			System.out.println(color);
			System.out.println(super.color);
			
		}
		}	
public class SuperUsage_Animal{		
	public static void main(String[] args) {
		
		dog  d =  new dog();
		d.display_color();
				
	
}
}
*/
/*public class Animal_SuperClass{
	 void  ani(String d){
	System.out.println(d);
	}
public static void main(String[] args){
Dog d = new Dog();
d.print();


}
}
class Dog extends Animal_SuperClass{
	String d = "Red";
void print(){
System.out.println(d);
super.ani("blue");


}
}*/
class test {
	test(){
		System.out.println("Super keyword using constructor in parent class");
	}
	
}
class dog extends test {
	dog() {
		super();
	System.out.println("Super keyword using constructor in child  class");
}
}
class Animal_SuperClass {
	public static void main(String args[]){ 
		
		dog d = new dog();
			
	}
}