
public class ModulusTests {
	
	public static void main(String[] args) {
		
		System.out.println("enter your first number");
		double numOne = IO.readDouble();
		
		System.out.println("enter your second number");
		double numTwo = IO.readDouble();
		
		double answer = numOne % numTwo;
		
		IO.outputDoubleAnswer(answer);
		
	}

}
