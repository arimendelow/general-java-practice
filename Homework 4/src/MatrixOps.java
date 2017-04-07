public class MatrixOps {
	public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
		
		int r1, c1, r2, c2;
		
		r1 = matrix1.length;
		c1 = matrix1[0].length;
		r2 = matrix2.length;
		c2 = matrix2[0].length;
		
		double[][] multiplied = null;
		
		if(c1 != r2){
			return null;
		} else{
			
			multiplied = new double[r1][c2];
			
			for (int i = 0; i < r1; i++) { // aRow
	            for (int j = 0; j < c2; j++) { // bColumn
	                for (int k = 0; k < c1; k++) { // aColumn
	                    multiplied[i][j] += matrix1[i][k] * matrix2[k][j];
	                }
	            }
	        }
			
		}
		return multiplied;
		
	}
}


