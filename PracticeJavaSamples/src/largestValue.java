
public class largestValue {

		public static void main(String[] args){

			int[] arr={28,3,15,9,30,17,4,23,2};

			int val=arr[0];
			System.out.println(val);

			for(int i=0; i<arr.length; i++){
				if(arr[i] > val){
					val=arr[i];
					
				}
				//System.out.println(val);
			}
			System.out.println("Largest value in the Given Array is "+ val);
		}
	}
