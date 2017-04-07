
public class Sum {
	
	public static void main(String[] args) {
		
		int num1, num2;
		
		System.out.println("Enter your first number");
		num1 = IO.readInt();
		System.out.println("Enter your second number");
		num2 = IO.readInt();
		
		int sum = num1 + num2;
		
		IO.outputIntAnswer(sum);
		
	}

}
