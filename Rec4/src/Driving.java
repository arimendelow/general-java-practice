
public class Driving {
	
	public static void main(String[]args){
		
		System.out.println("what was the driver's speed?");
		int speed = IO.readInt();
		
		if(speed <= 60) {
			IO.outputIntAnswer(0);
		} else if(speed <= 75) {
			IO.outputIntAnswer(100);
		} else if (speed <= 90) {
			IO.outputIntAnswer(200);
		} else {
			IO.outputIntAnswer(500);
		}
		
		
	}

}
