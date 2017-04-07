import java.util.Scanner;


public class FirstLetter {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Gimme your string");
		String input = scan.nextLine();
		System.out.println(FirstLetters(input));
		System.out.println(LastLetters(input));
		
	}
	
	public static String FirstLetters(String input) {
		
		String output = "";
		String[] words = input.split(" ");
		
		for(int i = 0; i < words.length; i ++) {
			output += words[i].charAt(0) + "";
		}
		
		return output;
	}
	
	public static String LastLetters(String input) {
		
		String output = "";
		String[] words = input.split(" ");
		
		for(int i = 0; i < words.length; i ++) {
			output += words[i].substring(words[i].length() - 1, words[i].length());
		}
		
		return output;
	}

}
