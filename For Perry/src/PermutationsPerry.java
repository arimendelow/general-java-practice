import java.util.Arrays;
import java.util.Scanner;

public class PermutationsPerry {
	
	public static void main(String[] args){

		
		Scanner reader = new Scanner(System.in);
        // Read substring A from System.in
        System.out.print("Enter a substring for A: ");
        String inputA = reader.nextLine();

        // Read parent string B from System.in
        System.out.print("Enter a parent string for B: ");
        String inputB = reader.nextLine();

        long startTime = System.currentTimeMillis();
        
		System.out.println(isPermutedSubstringInParentString("Kei.gerS", inputB));
		
		long endTime = System.currentTimeMillis();
	    System.out.println("Total execution time: " + (endTime-startTime) + "ms");
		
	}
	
	public static boolean isPermutedSubstringInParentString(String A, String B){
		
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		char[] tempArray;
		
		Arrays.sort(a);
		
		for(int i = 0; i <= b.length - a.length; i++){
			
			tempArray = Arrays.copyOfRange(b, i, i + a.length);
			Arrays.sort(tempArray);
			
			if(Arrays.equals(a, tempArray)) return true;
		}
		return false;
	}
	
}