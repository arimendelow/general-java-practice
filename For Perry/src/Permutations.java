import java.util.Arrays;

public class Permutations {
	
	public static void main(String[] args){
		
		System.out.println(isPermutedSubstringInParentString("ab3cdefg", "fndsajlf;sadjfhnslxjdsamfdhjalf3cbagdegdslafjha"));
		
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