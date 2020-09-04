
public class occarence {

	static void m1() {
		
		int res = 0 ;

		String s = "Raaaaajjjjeshhh";
		String cv= "";

		char[] stringchar = s.toCharArray();


		for (char a1 : stringchar) {

			if(cv.contains(Character.toString(a1))){
				//System.out.println("Hello");
			}
			else {
				for(int f=0; f<stringchar.length;f++) {

					//System.out.println(Character.toString(stringchar[f]).length());

					if(a1 == stringchar[f]) {
						res++;						
					}
										
				}
				System.out.println("occureance of each char ="+ a1 + " are "+ res++);
			}
			res = 0;
			cv = cv+a1;

		}	
	}

	public static void main(String[] args) {

		m1();

	}

}
