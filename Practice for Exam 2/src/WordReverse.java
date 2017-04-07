
public class WordReverse {
	
	public static void main(String[] args){
		
		String sentence = "The quick brown fox jumps over the lazy dog.";
		
		reverse(sentence);
		
	}
	
	public static String reverse(String original){
		
		String processed = original.toLowerCase().replace(".", "");		
		
		String[] words = processed.split(" ");
		String reversed = (words[words.length - 1].toUpperCase()).charAt(0) + words[words.length - 1].substring(1) + " ";
		
		for(int i = words.length - 2; i >= 0; i--){
			reversed += words[i];
			if(i != 0){
				reversed += " ";
			}
		}
		
		reversed += ".";
		
		IO.outputStringAnswer(reversed);
		
		return original;
	}

}
