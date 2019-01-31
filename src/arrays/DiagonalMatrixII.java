package arrays;

public class DiagonalMatrixII {

	public static void print(int [][] matrix){

        //print first half
        int row =0;
        int col;

        while(row<matrix.length){
            col =0;
            int rowTemp = row;
            while(rowTemp>=0){
                System.out.print(matrix[rowTemp][col] + " ");
                rowTemp--;
                col++;
            }
            System.out.println();
            row++;
        }

        //print second half
        col = 1;

        while(col<matrix.length){
            int colTemp = col;
            row = matrix.length-1;
            while(colTemp<=matrix.length-1){
                System.out.print(matrix[row][colTemp] + " ");
                row--;
                colTemp++;
            }
            System.out.println();
            col++;
        }

    }

    public static void main(String[] args) {
        int [][] matrix = {
		        		{1,2,3,4},
		        		{5,6,7,8},
		        		{9,10,11,12},
		        		{13,14,15,16}
        			};
        print(matrix);

    }
}
