
public class ReverseString {
	
	public static void main(String[] args){
		
		System.out.println("gimme a string");
		String input = IO.readString();
		
		reverseString(input);
		
	}
	
	public static String reverseString(String original){
		
		String[] words = original.split(" ");
		String backwardsWord = "";
		String reversed = "";
		
		for(int i = 0; i < words.length; i++){
			for(int j = words[i].length() - 1; j >= 0; j--){
				
				backwardsWord += words[i].charAt(j);
				
			}
			reversed += backwardsWord + " ";
			backwardsWord = "";
		}
		

		IO.outputStringAnswer(reversed);
		return reversed;
	}

}
