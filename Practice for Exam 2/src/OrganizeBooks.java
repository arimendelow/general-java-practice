
public class OrganizeBooks {
	
	public static void main(String[] args){
		
		String[] bookList = {"Hamlet","The Great Gatsby","Great Expectations"};
		
//		System.out.println("first book");
//		bookList[0] = IO.readString();
//		System.out.println("second book");
//		bookList[1] = IO.readString();
//		System.out.println("third book");
//		bookList[2] = IO.readString();
		
		OrganizeBooks(bookList);
		
	}
	
	public static String[] OrganizeBooks(String[] x){
		
		boolean flag = true;
		String temp;
	
		while(flag){
			flag = false;
			for(int i = 0; i < x.length-1; i++){
				if((x[i].toLowerCase().replace("the ","")).compareTo(x[i + 1].toLowerCase().replace("the ","")) > 0){
					temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
					flag = true;
				}
			}
		}
		
		IO.outputStringAnswer(x[0]);
		IO.outputStringAnswer(x[1]);
		IO.outputStringAnswer(x[2]);
		return x;
		
	}

}
