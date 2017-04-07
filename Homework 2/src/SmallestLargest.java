
public class SmallestLargest {
	
	public static void main(String[] args) {
		
		double termNum, input, min = 0, max = 0;

		System.out.println("what number do you want to use to terminate?");
		termNum = IO.readDouble();
		
		System.out.println("what number shall i add to the list?");
		input = IO.readDouble();
		
		if(input != termNum){
			min = input;
			max = input;
			
			while(input != termNum) {
				
				if(input < min) {
					min = input;
				}
				if(input > max) {
					max = input;
				} 
				
				System.out.println("what number shall i add to the list?");
				input = IO.readDouble();
				
			}
				IO.outputDoubleAnswer(max);
				IO.outputDoubleAnswer(min);
			
		} else {
			IO.reportBadInput();
			return;
		}
		
	}
		
}
	
