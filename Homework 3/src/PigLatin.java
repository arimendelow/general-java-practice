
public class PigLatin {
	
	public static void main(String[] args){
		
		System.out.println("What is your word?");
		String original = IO.readString();
		translate(original);
		
	}
	
	
	public static String translate(String original){
		
		char firstLetter = original.charAt(0);
		String pigLatin = "";
		
		if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u'){
			
			pigLatin = original + "way";
			
		} else {
			
			pigLatin = original.substring(1,original.length()) + firstLetter + "ay";
			
		}
		
		IO.outputStringAnswer(pigLatin);
		return pigLatin;
	}

}