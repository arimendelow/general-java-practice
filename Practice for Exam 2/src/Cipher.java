
public class Cipher {
	
	public static void main(String[] args){
		System.out.println("give me a string");
		String input = IO.readString();
		
		decode(input);
	}
	
	public static String decode(String inputString){
		
		String coded = inputString.toLowerCase();
		String decoded = "";
		char currentLetter;
		char newLetter = 0;
		int hold;
		String add;
		int aNumber = (int)'a';
		int zNumber = (int)'z';
		int zeroNumber = (int)'0';
		int nineNumber = (int)'9';
		
		
		for(int i = 0; i < coded.length(); i++){
			currentLetter = coded.charAt(i);
			int letterNumber = (int)currentLetter;
			
			if(currentLetter == 'a'){
				newLetter = 'z';
				add = newLetter + "";
			} else if(letterNumber > aNumber && letterNumber < zNumber){
				hold = (int)currentLetter;
				newLetter = (char)(hold - 1);
				add = newLetter + "";
			} else if(currentLetter == '0'){
				newLetter = '9';
				add = newLetter + "";
			} else if(letterNumber > zeroNumber && letterNumber <= nineNumber){
				hold = (int)currentLetter;
				newLetter = (char)(hold - 1);
				add = newLetter + "";
			} else {
				add = currentLetter + "";
			}
			
			decoded += add;
		} 
		
		IO.outputStringAnswer(decoded);
		return decoded;
	}

}
