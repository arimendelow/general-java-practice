import java.util.Scanner;

/**
 *
 * TripleLift Intern Code Challenge, Question 3
 *
 * This program will determine whether there exists some substring of B which
 * is a permutation of A, given a substring A and parent string B.
 *
 * Perry Raskin
 * Computer Science, CUNY Queens College
 */

public class Permutation {
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

    private static void permutation(String prefix, String str, String all[]) {
        // generate all permutations of arg string str
        int n = str.length();
        
        if (n == 0) {

            for (int i = 0; i < all.length; i++) {

                if (all[i] == null) {
                    all[i] = prefix;
                    break;
                }
            }

        }
        else {

            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), all);
        }
    }

    private static boolean isPermutedSubstringInParentString(String inputA, String inputB) {
        // initialize new string of a size that will fit all permutations, hence factorial
        String[] a = new String[getFactorial(inputA.length())];
        permutation("", inputA, a);

        // check if inputB contains permutations of inputA
        for (int i=0; i < a.length; i++) {

            if (inputB.contains(a[i])) return true;
        }

        return false;
    }
    public static int getFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; ++i) {
            factorial *= i;
        }
        return factorial;
    }

}
