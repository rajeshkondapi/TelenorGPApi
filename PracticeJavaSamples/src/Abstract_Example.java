
abstract class Bike {
	
		  abstract void run();  
		}  
		class Honda4 extends Bike{  
		void run(){
			System.out.println("running safely..");
			} 
		}
		class Abstract_Example{
		public static void main(String args[]){  
			
			StringBuffer sb = new StringBuffer("Java");
			Bike obj = new Honda4();  
		 obj.run();  
		}  
		} 
