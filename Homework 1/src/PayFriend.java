
public class PayFriend {
	
	public static void main(String[] args) {
		
		double payAmt,fee = 0;
		
		System.out.println("What's your payment amount?");
		payAmt = IO.readDouble();
		
		if (payAmt <= 0) {
			System.out.println("Payment must be positive");
			IO.reportBadInput();
			
		} else {
			if (payAmt <= 100) {
				fee = 5;
				
			} else if (payAmt <= 1000) {
				//has fee of 3% or 6$, whichever is higher
				
				double fee1 = payAmt*.03;
				double fee2 = 6;
				
				if (fee1 > fee2) {
					fee = fee1;
				} else {
					fee = fee2;
				}
				
			} else if (payAmt < 10000){
				//has fee of 1% or $15, whichever is higher
				
				double fee1 = payAmt*.01;
				double fee2 = 15;
				
				if (fee1 > fee2) {
					fee = fee1;
				} else {
					fee = fee2;
				}

			//first 10000 has fee of 1%, next 5000 has fee of 2%, rest has fee of 3%
			} else if (payAmt >= 10000 && payAmt < 15000) {
				
				fee = 10000*.01 + (payAmt - 10000)*.02;
				
			} else if (payAmt >= 15000) {
				
				fee = 10000*.01 + 5000*.02 + (payAmt - 15000)*.03;
			}
		}
		
		IO.outputDoubleAnswer(fee);
		
	}
	

}
