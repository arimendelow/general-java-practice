
public class Plural {
	
	public static void main(String[] args){
		
		Boolean run = true;
		String input, plural = "";
		
		while(run){
			System.out.println("give me a word or 0 to quit");
			input = IO.readString();
			if(input.compareTo("0") == 0){
				run = false;
			} else {
//				if(input.length() > 3 && input.substring(input.length() - 2, input.length()).compareToIgnoreCase("us") == 0){
//					plural = input.substring(0,input.length() - 2) + "i";
//				}
				if(input.length() > 3 && input.charAt(input.length() - 2) == 'u' && input.charAt(input.length() - 1) == 's'){
					plural = input.substring(0,input.length() - 2) + "i";
				} else {
					plural = input + "s";
				}
				
				System.out.println(input + " plural is " + plural);
				
			}
			
			
			
		}
		
		
		
	}

}
