package arrays;

// find element in the sorted matrix
public class MatrixSortedFind {

	public static void main(String[] args) {
		int[][] matrix = {
				   {10,  22,  30,  40},
				   {12,  22,  33,  45},
				   {14,	 24,  44,  47},
				   {16,  26,  46,  50}
				  };

		boolean found = find(matrix,24);
		System.out.println(found);
	}
	 
	public static boolean find(int[][] matrix, int value) {
		// goto the last element in the first row.
		int i=0; 
		int n = matrix[0].length;
		int j = n -1;
		
		while( i< n && j >=0) {
			if(value == matrix[i][j]) return true;
			else {
				if( value < matrix[i][j])
					j--;
				else 
					i++;
			}
		}
		return false;
	}
	

}
