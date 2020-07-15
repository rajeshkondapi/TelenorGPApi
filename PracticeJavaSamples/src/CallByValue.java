





public class CallByValue {	
	
		 /*int data=50;			
		  
		 void change(int data){  
		 data=data+100;//changes will be in the local variable only
		 System.out.println("I am in Local "+data);
		 
		 }  
		     
		 public static void main(String args[]){  
			 CallByValue op=new CallByValue();  
		  
		   System.out.println("before change "+op.data);  
		   op.change(500);  
		   System.out.println("after change "+op.data);  
		  
		 }*/ 

		 int data=50;  
		 String v = "Raes";
	
		  
		 void change(CallByValue op){  
			//System.out.println("1 "+op);
		 op.data=op.data+100;//changes will be in the instance variable  
		 //System.out.println("2: "+op.data);	
		// System.out.println("3: "+op.v);	
		 
		 
		
		 }  
		 
		static String change1(String r){
			CallByValue op=new CallByValue(); 
			op.v=op.v+" " +r;
			 return  op.v;
		 }
		     
		    
		 public static void main(String args[]){  
			 CallByValue op=new CallByValue();  
		  
		 //  System.out.println("before change "+op.data); 
		//passing object  
		   //System.out.println("after change "+op.data);  
		  // System.out.println("after change "+op.v); 
		   
		   op.v = change1("Baha");
		   System.out.println("after change "+op.v); 
		   //op.change(op);
		  
		 }  
		}  

/*
 Constructors can pass as a parameter
 
 * */
