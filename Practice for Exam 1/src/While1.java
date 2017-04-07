/* this program reads a sequence of positive integers input by the user and will print the average 
 * of those integers. the user is prompted to enter one integer at a time, inputting a 0 to mark the end 
 * of the data (0 is not included in the data to be averaged). the program does not check whether input is
 * positive or negative so will actually add up both positive and negative values.
 */


public class While1 {

	public static void main(String[] args) {
		
		int inputNumber;    //integer most recently input
		int sum;           //sum of the positive integers
		int count;        //number of positive integers inputed
		double average;  //average of positive integers
		
		sum = 0;
		count = 0;
		
		System.out.println("enter your first positive integer");
		inputNumber = IO.readInt();
		
		while(inputNumber != 0) {
			
			 sum += inputNumber; //add inputNumber to running sum
			 count++;
			 System.out.println("enter your next positive integer or 0 to end: ");
			 inputNumber = IO.readInt();
			
		}
		
		if (count==0) {
			
			System.out.println("You didn't enter any data!");
			IO.reportBadInput();
			IO.outputStringAnswer("You didn't enter any data!");
			
		} else {
			average = ((double)sum) / count;
			IO.outputStringAnswer("You entered " + count + " positive integers.");
			IO.outputStringAnswer("Their average is " + average);
			
		}
		
		
	}
	
	
}
