
public class FirstTwoMaxval {

	public void GetTwoMaxValues(int[] nums) {

		int maxOne = 0;
		int maxTwo = 0;
		//System.out.println("nums: "+nums);
		for (int n : nums) {
			//System.out.println("n values: "+n);
			
			if (maxOne < n) {
				maxTwo = maxOne;
				//System.out.println("maxTwo values=" +maxTwo);
				maxOne = n;
			} else if (maxTwo < n) {
				maxTwo = n;
			}

		}

		System.out.println("Max1 - " + maxOne);
		System.out.println("Max2 - " + maxTwo);
	}

	public static void main(String[] args) {

		int list[] = { 15, 24, 48, 102, 43, 11, 79, 93 };

		FirstTwoMaxval max = new FirstTwoMaxval();
		max.GetTwoMaxValues(list);
	}
}

	
