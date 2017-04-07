
public class ChangeGiven {
	
	public static void main(String[] args) {
		
		int salesCharge, moneyGiven, change;
		int twenties, tens, fives, singles, quarters, dimes, nickels, pennies;
		
		System.out.println("what is the total sales charge?");
		salesCharge = (int)(IO.readDouble() * 100); //sales charge in cents
		System.out.println("how much is the customer giving?");
		moneyGiven = (int)(IO.readDouble() * 100); //sales charge in cents
		
		change = moneyGiven - salesCharge;
		
		if(moneyGiven > salesCharge) { 
			
			IO.outputStringAnswer("change is:");
			
			twenties = change / 2000;
			if(twenties > 0) {
				change = change % 2000;
				IO.outputStringAnswer(twenties + " $20 bills");
			}
			
			tens = change / 1000;
			if(tens > 0) {
				change = change % 1000;
				IO.outputStringAnswer(tens + " $10 bills");
			} 
			
			fives = change / 500;
			if(fives > 0) {
				change = change % 500;
				IO.outputStringAnswer(fives + " $5 bills");
			}
			
			singles = change / 100;
			if(singles > 0) { 
				change = change % 100;
				IO.outputStringAnswer(singles + " $1 bills");
			}
			
			quarters = change / 25;
			if(quarters > 0) { 
				change = change % 25;
				IO.outputStringAnswer(quarters + " quarters");
			}
			
			dimes = change / 10;
			if(dimes > 0) { 
				change = change % 10;
				IO.outputStringAnswer(dimes + " dimes");
			}
			
			nickels = change / 5;
			if(nickels > 0) { 
				change = change % 5;
				IO.outputStringAnswer(nickels + " nickels");
			}
			
			pennies = change / 1;
			if(pennies > 0) { 
				change = change % 1;
				IO.outputStringAnswer(pennies + " pennies");
			}
			
			
		} else if(moneyGiven < salesCharge) {
			
			IO.outputStringAnswer("not enough money!");
			
		} else {
			
			IO.outputStringAnswer("no change needed!");
			
		}
	
		
	}

}
