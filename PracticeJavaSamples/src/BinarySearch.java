import java.util.Arrays;
public class BinarySearch {

	public static void main(String[] args) {
		Integer  arr[]  = {10,20,30,40,50};  
	        int key = 50;
	        for(int i=0;i<arr.length;i++){
	        	if(key==arr[i]){
	        		System.out.println(Arrays.asList(arr).indexOf(key)); 
	        	}
	        		// or //BinarySearch we can find index of array
	        /*int result = Arrays.binarySearch(arr,key);  
	        if (result < 0)  
	            System.out.println("Element is not found!");  
	        else  
	            System.out.println("Element is found at index: "+result);*/  
	    }  

	}
}

