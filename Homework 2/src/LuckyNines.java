
public class LuckyNines {
	
	public static void main(String[] args){
		
		System.out.println("What is the lowest number?");
		int lowerEnd = IO.readInt();
		System.out.println("What is the highest number?");
		int upperEnd = IO.readInt();
		
		IO.outputIntAnswer(countLuckyNines(lowerEnd, upperEnd));

	}
	
	public static int countLuckyNines(int lowerEnd, int upperEnd) {
		
		if(lowerEnd > upperEnd) {
			IO.reportBadInput();
			return -1;
		} else {
			
			int arraySize = upperEnd - lowerEnd + 1;
			int ninesCount = 0;
			int currentNum = lowerEnd;
			int testedForNeg;
			
			int[] ninesArray = new int[arraySize];
			
			for(int j = 0; j < arraySize; j++) {
				
				ninesArray[j] = currentNum;
				
				testedForNeg = currentNum;
				
				if(testedForNeg <= 0) {
					testedForNeg = testedForNeg*-1;
					System.out.println(testedForNeg);
				}
				
				while(testedForNeg > 0){
					
					if(testedForNeg%10 == 9) {
						ninesCount++;
					}
					testedForNeg = testedForNeg/10;
					
				}
				
				currentNum++;
			} return ninesCount;
			
		}
		
	}
	
}
