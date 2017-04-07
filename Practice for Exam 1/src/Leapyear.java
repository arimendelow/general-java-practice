
public class Leapyear {
	
	public static void main(String[] args){
		
		System.out.println("What year do you want to check?");
		int year = IO.readInt();
		boolean isLeap = false;
		
		if(year % 4 == 0){
			
			if(year % 400 == 0){
			isLeap = true;
			} else if(year % 100 == 0) {
				isLeap = false;
			} else {
				isLeap = true;
			}
		}
		
		IO.outputBooleanAnswer(isLeap);
		
	}

}
