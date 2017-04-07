
public class WordCount {
	
	public static void main(String[] args){
		
		System.out.println("gimme a string");
		String original = IO.readString();
		
		System.out.println("what is your minimum word length?");
		int minLength = IO.readInt();
		
		countWords(original, minLength);
		
	}
	
	public static int countWords(String original, int minLength){
		
		int wordCount = 0;
		int letterCount = 0;
		
		String words[] = original.split(" ");
		
		for(int i = 0; i < words.length; i++){
			
			letterCount = countLetters(words[i]);
			
			if(letterCount >= minLength){
				
				wordCount++;
				
			}
			
		}
		
		IO.outputIntAnswer(wordCount);
		return wordCount;
		
	}
	
	public static int countLetters(String word){
		
		int letterCount = 0;
		
		for(int i = 0; i < word.length(); i++){
			
			if(Character.isLetter(word.charAt(i))){
				
				letterCount++;
				
			}
			
		}
	
		
		return letterCount;
		
	}

}
