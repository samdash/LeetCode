package arrays;

public class SnakeMatrixReverse {

	public static void main(String[] args) {
		int[][] matrix = {
				   {1,  2,  3,  4},
				   {5,  6,  7,  8},
				   {9,  10, 11, 12},
				   {13, 14, 15, 16},
				   {17, 18, 19, 20}
				  };
		printReverseSnake(matrix);
		
	}

	public static void printReverseSnake(int[][] matrix) {
		
		int rowLength = matrix.length -1;
		int colLength = matrix[0].length -1;
		
		for( int i=rowLength;i>=0; i--) {
			
			if( i % 2 == 0) {
				for(int j = 0;j<=colLength;j++) {
					System.out.print(matrix[rowLength][j]+ " ");
				}
			}else {
				for(int j = colLength;j>=0;j--) {
					System.out.print(matrix[rowLength][j]+" ");
				}
				
			}
			rowLength --;
			System.out.println();
		}
	}
}
