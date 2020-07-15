
public class removeodd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sess  = "ad5f0be534a347d4aca36434b8de4049";
		String session[] = {sess};
		
		for(String word : session){
	        boolean even = true;
	        StringBuilder oddChars = new StringBuilder();
	        for(char c : word.toCharArray()){
	            if(even){
	                System.out.print(c);
	            } else {
	                oddChars.append("append = "+c);
	            }
	            even = !even;
	        }
	        
	    }
		
		
	}
	}
