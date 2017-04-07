
public class practice {
	
	public static boolean isPalindrome(int[] array, int n, int m){
		if(array.length == 0 || n == m || array.length == 1){
			return true;
		} else {
			if(array[n] != array[m]){
				return false;
			} else if((m - n) == 1 && array[m] == array[n]){
				return true;
			} else {
				return isPalindrome(array, n + 1, m - 1);
			}
		}
	}
	
	public static int max(int arr[], int size){
		if(size == 1) {
			return arr[size - 1];
		}
		else {
			return Math.max(max(arr, size - 1), arr[size - 1]);
		}
	}
	
	public int productOfOdds(int[] arr, int n){
		if(n == 1){
			if(arr[0]%2 == 0){
				return 1;
			} else {
				return arr[0];
			}
		} else if(arr[0]%2 != 0){
			return arr[0] * productOfOdds(arr, n - 1);
		} else {
			return productOfOdds(arr, n - 1);
		}
	}
			
	
	public static void main(String[] args){
		
		int[] a = {0,2,3,2};
		
		System.out.println(max(a, 4));
		
	}

}
