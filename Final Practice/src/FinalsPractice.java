
public class FinalsPractice {
	
	
//Strings------------------------------------------------------------
	public static String ReFormat(String input){
		String output = "";
		input = input.trim();
		input = input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
		String[] words = input.split(" ");
		
		for(int i = 0; i < words.length; i++){
			if(words[i].compareTo("i") == 0){
				words[i] = "I";
			}
			if(words[i].length() != 0 && i != words.length - 1){
				output += words[i] + " ";
			} else if(words[i].length() != 0){
				output += words[i];
			}
		}
		if(!(output.endsWith("!") || output.endsWith("?") || output.endsWith("."))){
			output += ".";
		}
		
		return output;
	}
	public static String ReverseWords(String input){
		input = input.toLowerCase().substring(0, input.length() - 1);
		String output = "";
		String[] words = input.split(" ");
		String temp = "";
		
		for(int i = 0; i < words.length; i ++){
			for(int j = words[i].length() - 1; j >= 0; j--){
				temp += words[i].charAt(j);
			}
			output += temp + " ";
			temp = "";
		}
		
		
		return output.substring(0, 1).toUpperCase() + output.substring(1,output.length() - 1) + ".";
	}
	

//Recursion------------------------------------------------------------
	public static double Round(double x, int n){
		if(n <= 0){
			return Math.round(x);
		} else {
			return Round(x * 10, n - 1) / 10;
		}
	}
	public static String Reverse(String str){
		if(str.length() == 0){
			return "";
		} else {
			return str.substring(str.length() - 1, str.length()) + Reverse(str.substring(0,str.length() - 1));
		}
	}
	public static boolean hasNegative(int[] numbers, int n){
		if(n == 0){
			return false;
		} else if(numbers[n - 1] < 0){
			return true;
		} else {
			return hasNegative(numbers, n - 1);
		}
	}
	public static int factorial(int n){
		if(n <= 1)
			return 1;
		return n * factorial(n - 1);
	}
	
	public static void main(String[] args){
		
		
		System.out.println(factorial(0));
		
	}

}
