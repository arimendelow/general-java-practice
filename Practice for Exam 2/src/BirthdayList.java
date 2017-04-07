
public class BirthdayList {
	
	/*Write a program that asks the user for a list of people's names and birthdays.
	 * Birthdays should be input as two numbers, month and day.
	 * Use arrays to store this information. 
	 * Display a menu that offers the following choices:
		Given a person's name, report their birthday.
		Given a month, report all people whose birthdays fall in that month.
		Report all sets of people who happen to have the same birthday.*/
	
	public static void main(String[] args){
		
		String[] names;
		int[] birthMonth, birthDay;
		int timesRun;
		String name;
		int month;
		int nameIndex;
		boolean[] monthOverlap, birthdayOverlap;
		boolean isOverlap;
		
		System.out.println("input names and birthdays.");
		
		System.out.println("how many people do you want to have in your database?");
		timesRun = IO.readInt();
		names = new String[timesRun];
		birthMonth = new int[timesRun];
		birthDay = new int[timesRun];
		
		for(int i = 0; i < timesRun; i++){
			System.out.println("name?");
			names[i] = IO.readString();
			System.out.println("month? (enter #)");
			birthMonth[i] = IO.readInt();
			System.out.println("day?");
			birthDay[i] = IO.readInt();
		}
			
		
		
		while(true){
			System.out.println("Input your choice or 0 to exit");
			System.out.println("1) given a name, report a birthday");
			System.out.println("2) report all people with birthdays in a given month");
			System.out.println("3) report all people with the same birthdays");
			
			int option = IO.readInt();
			if(option == 0){
				break;
			} else if(option == 1){ //Given a person's name, report their birthday.
				System.out.println("whose birthday do you want to know?");
				name = IO.readString();
				nameIndex = -1;
				
				for(int i = 0; i < names.length; i++){
					if(names[i].compareToIgnoreCase(name) == 0){
						nameIndex = i;
					}
				} if(nameIndex == -1){
					System.out.println("no " + name + " in database");
					IO.reportBadInput();
				} else {
					System.out.println();
					IO.outputStringAnswer(name + "'s birthday is " + birthMonth[nameIndex] + "/" + birthDay[nameIndex]);
					System.out.println();
				}
				
				
			} else if(option == 2){ //Given a month, report all people whose birthdays fall in that month.
				monthOverlap = new boolean[timesRun];
				for(int i = 0; i < timesRun; i++){
					monthOverlap[i] = false;
				}
				
				isOverlap = false;
				
				System.out.println("What month do you want to query? (enter #)");
				month = IO.readInt();
				
				for(int i = 0; i < timesRun; i++){
					if(birthMonth[i] == month){
						monthOverlap[i] = true;
						isOverlap = true;
					}
				}
				if(isOverlap){
					System.out.println();
					IO.outputStringAnswer("people born in month " + month + " are:");
					
					for(int i = 0; i < timesRun; i++){
						if(monthOverlap[i]){
							System.out.println(names[i]);
						}
					}
					System.out.println();
					
				} else{
					System.out.println();
					IO.outputStringAnswer("nobody is born in month " + month);
					System.out.println();
				}
				
				
			} else if(option == 3){ //Report all sets of people who happen to have the same birthday.
				
				birthdayOverlap = new boolean[timesRun];
				
				for(int i = 0; i < timesRun; i++){
					
					for(int k = 0; k < timesRun; k++){
						birthdayOverlap[k] = false;
					}
					birthdayOverlap[i] = true;
					
					for(int j = i + 1; j < timesRun - 1; j++){
						if(birthMonth[i] == birthMonth[j]) {
							if(birthDay[i] == birthDay[j]){
								birthdayOverlap[j] = true;
							}
						}
					}
					
					System.out.println();
					System.out.println("people born on: " + birthMonth[i] + "/" + birthDay[i]);
					
					for(int k = 0; k < timesRun; k++){
						if(birthdayOverlap[k])
							System.out.print(names[k] + " ");
						}
					} System.out.println();
				}
			}
		}
	}

