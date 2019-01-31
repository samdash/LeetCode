package arrays;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralOrderMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				   {1,  2,  3,  4},
				   {5,  6,  7,  8},
				   {9,  10, 11, 12},
				   {13,  14, 15, 16}
				  };

		int rowStart = 0;
		int rowLength = matrix.length -1 ;
		int colStart =0;
		int colLength = matrix[0].length -1;

		while(rowStart <= rowLength && colStart <= colLength) {
			 for(int i=colStart;i<=colLength;i++) {
				  System.out.print(matrix[rowStart][i]+"  ");
			 }
			 rowStart++;System.out.println();
			 
			 for(int j= rowStart;j<=rowLength;j++) {
				 System.out.print(matrix[j][colLength]+"  ");
			 }
			 colLength --;System.out.println();
			 if(rowStart <= rowLength) {
				 for( int k=colLength; k>=colStart;k--) {
					 System.out.print(matrix[rowLength][k]+"  ");
				 }
			 }
			 rowLength--;System.out.println();
			 if(colStart <=colLength) {
				 for(int i = rowLength; i >= rowStart; i--) {
	                    System.out.print(matrix[i][colStart]+"  ");
	                }
			 }
			 colStart ++;System.out.println();
			 
		}
		
	}

}
