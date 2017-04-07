
public class LuckySevens {
	
	public static void main(String[] args) { 
		
		System.out.println("What is the lowest number?");
		int lowNum = IO.readInt();
		System.out.println("What is the highest number?");
		int highNum = IO.readInt();
		
		if(lowNum > highNum) {
			IO.reportBadInput();
			return;
		} else {
			
			int arraySize = highNum - lowNum + 1;
			int sevensCount = 0;
			int currentNum = lowNum;
			int testedForNeg;
			
			int[] sevensArray = new int[arraySize];
			
			for(int j = 0; j < arraySize; j++) {
				
				sevensArray[j] = currentNum;
				
				testedForNeg = currentNum;
				
				if(testedForNeg <= 0) {
					testedForNeg = testedForNeg*-1;
					System.out.println(testedForNeg);
				}
				
				while(testedForNeg > 0){
					
					if(testedForNeg%10 == 7) {
						sevensCount++;
					}
					testedForNeg = testedForNeg/10;
					
				}
				
				currentNum++;
			} IO.outputIntAnswer(sevensCount);
			
			
			
		}
		
		
	}

}
