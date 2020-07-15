
public class SmallestNumerinArray {

	public static void main(String[] args) {
		int a[]={11,2,3,5,12,15};
		int curr=a[0];
		int count=a.length;
		for(int i=1;i<count;i++){
			if(curr>=a[i]){
				curr=a[i];
			}
		}	
		System.out.println("smallest number in the list = "+curr);
	}

}
