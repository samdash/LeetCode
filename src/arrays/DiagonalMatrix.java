package arrays;

public class DiagonalMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				   {1,  2,  3,  4},
				   {5,  6,  7,  8},
				   {9,  10, 11, 12},
				   {13, 14, 15, 16},
				   {17, 18, 19, 20}
				  };

		int c=0,i=0,j=0;
		int count = matrix.length + matrix[0].length -1;
		while(c < count) {
			printDiagonal(i,j,matrix);
			if( i< matrix.length -1) {
				i++;
				
			}else if ( j< matrix[0].length -1) {
				j++;
			}
			c++;
		}
		
	}
	
	public static void printDiagonal(int i, int j, int[][]matrix) {
		while(i>=0 && j< matrix[0].length) {
			System.out.print(matrix[i][j]+" ");
			i--;
			j++;
		}
		System.out.println("");
	}
	

}
