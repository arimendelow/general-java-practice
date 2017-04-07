
public class Fibonacci {
	
	public static void main(String[] args){
		
		System.out.println("how many numbers into the sequence do you want to compute?");
		int n = IO.readInt();
		int j = 0;
		int k;
		int l;
		
		k = 0;
		j = 0;
		l = 1;
		
		for(int i = 0; i < n; i++){
			
			j = k + l;
			
			l = k;
			k = j;
			
			System.out.println(j);
			
		}
		
	}

}
