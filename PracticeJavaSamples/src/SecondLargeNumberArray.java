import java.util.ArrayList;

public class SecondLargeNumberArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		
		
		int arr[]={11,2,3,5,12,15,20};
		
		
		
		
		
		//int copy[] = new int[arr.length];
		//System.out.println(arr);
		
		
		
		
		
		
		
		for(int i=0; i<arr.length;i++) {
			//System.out.println(arr[i]);
			if(arr[0]<=arr[i]) {
				//System.out.println(arr[i]);
				
				arr[0] = arr[i];
				System.out.println("larget num = "+arr[0]);
				//copy[i] = arr[0];
				
				
			}
			
			
		}
		
		

	}

}


