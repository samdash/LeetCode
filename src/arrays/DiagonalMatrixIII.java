package arrays;

public class DiagonalMatrixIII {

	public static void main(String[] args) {
		int[][] matrix = {
				   {1,  2,  3,  4},
				   {5,  6,  7,  8},
				   {9,  10, 11, 12},
				   {13, 14, 15, 16},
				   {17, 18, 19, 20}
				  };

		printDiagonal(matrix);
	}
	
	public static void printDiagonal(int[][]matrix) {
		int i =0; // row 
		int j =0; // col
		
		for(int k=0;k<matrix.length -1 ;k++) {
			i=k;
			j=0;
			while(i >=0) {
				System.out.print(matrix[i][j]+" ");
				i--;
				j++;
			}
			System.out.println();

		}
		// print seconds half start from 18 diagonally up
		for( int k=1 ; k<= matrix[0].length -1 ;k++) {
			i = matrix.length -1; // start from 18 last row
			j = k;
			while( j <= matrix[0].length -1) {
				System.out.print(matrix[i][j]+" ");
				i--;
				j++;
			}
			System.out.println();

		}
	}

}
