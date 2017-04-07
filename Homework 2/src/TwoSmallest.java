
public class TwoSmallest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("What is your terminating value? ");
		double term = IO.readDouble();
		double one = 0;
		double two = 0;
		double input = term;
		boolean x=false;
		boolean y = false;
		while(input==term){
			System.out.println("What is your value?");
			input = IO.readDouble();
			if(input==term){
				IO.reportBadInput();
			}
		}
		one=input;
		while(input!=term){
			if(input<=one){
				if(y == true){
					two=one;
				}
				one=input;
				y = true;
			} else if(input<two || two == 0){
				two=input;
			}
			System.out.println("What is your value? ");
			input = IO.readDouble();
			if(input==term){
				if(x==false){
					IO.reportBadInput();
					while(input==term){
						System.out.println("What is your value? ");
						input = IO.readDouble();
						if(input==term){
							IO.reportBadInput();
						}
					}
				}
			}
			x=true;
		}
		IO.outputDoubleAnswer(one);
		IO.outputDoubleAnswer(two);
	}
	
}