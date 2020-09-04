import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class threadSamples extends Thread {
	
	//arr[] a = {"Rajesh","Kondapi"};
	
	static void vectex(int x) {
		
		ArrayList al = new ArrayList<>();
		Vector v = new Vector();
		Map<String,String> m =  new HashMap<>();
		
		for (int i=0; i<=x;i++) {
			al.add(i);
		}
		
		System.out.println("Arraylist = "+al);
		
	
		
		v.add("Rajesh");
		v.add("KOndapi");
		
		System.out.println("vector = "+v);
		
		if(v.containsAll(al)) {
			System.out.println("Equal elements = "+v);
		}
		
		
		for(int j=0;j<v.size();j++) {
			//ListIterator<String> li = al.listIterator();
			//while(li.hasNext()) {
				
				m.put(v.get(j).toString(), al.get(j).toString());
				//System.out.println(v.get(j));
				//System.out.println(al.get(j));
				
				if(m.containsKey("Rajesh")) {
					m.replace("Rajesh", "0", "10");
				}
				
			}
			
			System.out.println("Map key values pair ="+m);
			
			
			System.out.println(m.keySet());
			
			
			
	}
	
	Thread t1 = new Thread();
	
		
		
		
			
	public static void main(String[] args) {
		vectex(10);
	}


}