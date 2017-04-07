
public class Cipher2 {
	
	public static void main(String[] args){
		
		boolean run = true;
		String input = "";
		int option;
		
		while(run){
		
			System.out.println("give me a string or type 0 to stop");
			input = IO.readString();
			
			if(input.compareTo("0") == 0){
				System.out.println("goodbye!");
				break;
			} else{
				
				System.out.println("1 to encode, 2 to decode");
				option = IO.readInt();
				
				if(option == 1){
					encode(input);
					
				}
				
				if(option == 2){
					decode(input);
					
				}
			}
		}
	}
	
	public static String encode(String input){
		String inputL = input.toLowerCase();
		String encoded = "";
		char runningLetter;
		int aCode = (int)'a';
		int zCode = (int)'z';
		int zeroCode = (int)'0';
		int nineCode = (int)'9';
		
		for(int i = 0; i < inputL.length(); i++){
			runningLetter = inputL.charAt(i);
			
			if(runningLetter < zCode && runningLetter >= aCode){
				encoded += (char)((int)runningLetter + 1);
			} else if(runningLetter == zCode){
				encoded += (char)aCode;
			} else if(runningLetter < nineCode && runningLetter >= zeroCode){
				encoded += (char)((int)runningLetter + 1);
			} else if(runningLetter == nineCode){
				encoded += (char)zeroCode;
			} else {
				encoded += runningLetter;
			}
		}
		
		
		IO.outputStringAnswer("Your encoded message is: " + encoded);
		return encoded;
	}
	
	public static String decode(String input){
		String inputL = input.toLowerCase();
		String decoded = "";
		char runningLetter;
		int aCode = (int)'a';
		int zCode = (int)'z';
		int zeroCode = (int)'0';
		int nineCode = (int)'9';
		
		for(int i = 0; i < inputL.length(); i++){
			runningLetter = inputL.charAt(i);
			
			if(runningLetter <= zCode && runningLetter > aCode){
				decoded += (char)((int)runningLetter - 1);
			} else if(runningLetter == aCode){
				decoded += (char)zCode;
			} else if(runningLetter <= nineCode && runningLetter > zeroCode){
				decoded += (char)((int)runningLetter - 1);
			} else if(runningLetter == zeroCode){
				decoded += (char)nineCode;
			} else {
				decoded += runningLetter;
			}
		}
		
		
		IO.outputStringAnswer("Your decoded message is: " + decoded);
		return decoded;
	}

}
