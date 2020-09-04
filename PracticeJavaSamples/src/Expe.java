import java.util.Enumeration;
import java.util.Vector;

public class Expe {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5,5};
		int[] arr = {1,2,3};
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr1[i] == arr[j]) {				
					System.out.println("duplicates elements are ="+arr1[i]);
				}
			}
		}
			
	}
		

}

