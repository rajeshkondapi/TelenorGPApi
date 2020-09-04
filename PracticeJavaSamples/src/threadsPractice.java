/**
 * 
 */

/**
 * @author rajesh.k
 *
 */
public class threadsPractice extends Thread {	
	
	static int amount =0;

	public void run() {
		//System.out.println("i am in run method to override");
		//amount++;
		//System.out.println("Run Method amount++ value ="+amount);
		
		
		for(int i=1; i<=4;i++) {
			//System.out.println("For loop");
			try {
				Thread.sleep(5000);
				//System.out.println("Waiting time = "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			//amount++;
			System.out.println(i);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		threadsPractice t1 =  new threadsPractice();
		threadsPractice t2 =  new threadsPractice();
		threadsPractice t3 =  new threadsPractice();
		t1.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println("Thread Name = "+t1.getName());
		System.out.println("Thread Priority = "+t1.getPriority());
		//System.out.println("Thread Set Prior = "  +t1.setName("Rajesh Tread"));
		
		t1.setName("Rajesh thread");
		System.out.println(t1.getName());
		t1.setPriority(3);
		System.out.println(t1.getPriority());
		try{  
			// untill t1 completes no other thread will execute
			  t1.join();
			
			//
			//t1.yield();
			 }catch(Exception e){
				 System.out.println(e);
				 }  
			  
			 t2.start();  
			 t3.start(); 
		
		
		 
		
		//thprac2.yield();
		
		/*while(thprac.isAlive()) {
			System.out.println("Inn main waiting");
		}*/
		
		//System.out.println("Value after waiting =  "+amount);
		
		//amount++;
		
		//System.out.println("Operation in main method =  "+amount);
		
		//System.out.println(amount++);
	}

}
