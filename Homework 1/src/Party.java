
public class Party {
	
	public static void main(String[] args) {
		
		int peopleAttending; //1
		int slicePerPerson;  //2
		int canPerPerson;    //3
		double pieCost;      //4
		int slicePerPie;     //5
		double caseCost;     //6
		int canPerCase;   //7
		
		//1
		System.out.println("How many people will be attending?");
		peopleAttending = IO.readInt();
		//2
		System.out.println("How much pizza will you allow each person to consume?");
		slicePerPerson = IO.readInt();
		//3
		System.out.println("How many cans of soda will you feed each person?");
		canPerPerson = IO.readInt();
		//4
		System.out.println("How much does a pie of pizza cost?");
		pieCost = IO.readDouble();
		//5
		System.out.println("How many slices are in these 'pies'?");
		slicePerPie = IO.readInt();
		//6
		System.out.println("How much does a case of soda cost?");
		caseCost = IO.readDouble();
		//7
		System.out.println("How many cans are in each case?");
		canPerCase = IO.readInt();
		
		//total # of slices
		int totalSlices = peopleAttending*slicePerPerson;
		
		//total # of pies
		int totalPies = ((totalSlices - 1) / slicePerPie + 1);
		
		//total # of cans
		int totalCans = peopleAttending*canPerPerson;
		
		//total # of cases
		int totalCases = ((totalCans - 1) / canPerCase + 1);
		
		//total cost
		
		double costTotal = totalCases * caseCost + totalPies * pieCost;
		

		IO.outputDoubleAnswer(costTotal);
		
	}

}
