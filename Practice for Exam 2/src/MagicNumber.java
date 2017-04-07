
public class MagicNumber {
	
	public static void main(String[] args){
		
		System.out.println("upper limit?");
		int limit = IO.readInt();
		int sum;
		
		for(int i = 1; i < limit; i++){
			sum = 0;
			for(int j = 1; j < i; j++){
				if(i%j == 0){
					sum+= j;
				}
			}
			
			if(sum == i){
				IO.outputStringAnswer(i + " is a magic number");
			}
			
		}
		
	}

}
