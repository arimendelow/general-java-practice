
public class arrayPractice {
	
	public static void count(int[][] array){ 
		int countOne = 0, countZero = 0;
		
		for(int i = 0; i < array.length; i++){ //loops through the rows
			for(int j = 0; j < array.length; j++){ //loops through the columns
				
				if(array[i][j] == 1){
					countOne++;
				} else if(array[i][j] == 0){
					countZero++;
				}
				
			}
		}
		
	}
	
	public static void getAverages(int[][] grades){
		
		for(int i = 0; i < grades.length; i ++){
			
			int smallest = 101; //grades are from 0-100
			int total = 0;
			
			for(int j = 0; j < grades[i].length; j ++){
				
				total += grades[i][j];
				if(grades[i][j] < smallest) {
					smallest = grades[i][j];
				}
				
			}
			
			total -= smallest;
			System.out.println((double)total/(grades[i].length - 1));
		}
		
	}
	

}
