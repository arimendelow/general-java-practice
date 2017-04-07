
public class BigONotation {
	
	private int[] theArray;
	private int arraySize;
	private int itemsInArray = 0;
	static long startTime;
	static long endTime;
	
	BigONotation(int size){
		arraySize = size;
		theArray = new int[size];
	}
	public void generateRandomArray(){
		for(int i = 0; i < arraySize; i++){
			theArray[i] = (int)(Math.random() * 1000) + 10;
		}
	}
	
	public static void main(String[] args){
		
		BigONotation testAlgo2 = new BigONotation(1000000);
		testAlgo2.generateRandomArray();
		
		BigONotation testAlgo3 = new BigONotation(2000000);
		testAlgo3.generateRandomArray();
		
		BigONotation testAlgo4 = new BigONotation(3000000);
		testAlgo4.generateRandomArray();
		
		BigONotation testAlgo5 = new BigONotation(4000000);
		testAlgo5.generateRandomArray();
		
		testAlgo2.linearSearchForValue(20);
		testAlgo3.linearSearchForValue(20);
		testAlgo4.linearSearchForValue(20);
		testAlgo5.linearSearchForValue(20);
		
	}
	
	//O(1)
	public void addItemToArray(int newItem){
		theArray[itemsInArray++] = newItem;
	}
	
	//O(n)
	public void linearSearchForValue(int value){
		
		boolean valueInArray = false;
		String indexsWithValue = "";
		
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < arraySize; i++){
			if(theArray[i] == value) {
				valueInArray = true;
				indexsWithValue += i + " ";
			}
			
		}
		System.out.println("value found: " + valueInArray);
		endTime = System.currentTimeMillis();
		System.out.println("lin search took " + (endTime - startTime));
		
	}
	
	//O(n^2) - bubble sort would be an example

	//O(log n) - occurs when data is decreased by 50% each time thru algorithm - binary search
	

}
