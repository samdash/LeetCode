package arrays;

public class SnakeMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				   {1,  2,  3,  4},
				   {5,  6,  7,  8},
				   {9,  10, 11, 12},
				   {13, 14, 15, 16},
				   {17, 18, 19, 20}
				  };
		
			printSnake(matrix);
	}
	
	public static void printSnake(int[][] matrix) {
		
		int rowStart = 0;
		int rowLength = matrix.length -1;
		int colLength = matrix[0].length -1;
		
		for(int i=0;i<=rowLength;i++) {
			if(i % 2 == 0) {
				for(int j=0;j<=colLength;j++) {
					System.out.print(matrix[rowStart][j]+" ");
				}
				
			}else {
				for(int j=colLength;j>=0;j--) {
					System.out.print(matrix[rowStart][j]+" ");
				}
			}
			System.out.println();
			rowStart ++;
		}
	}

}
