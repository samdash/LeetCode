package arrays;

public class RotateMatrix180 {	  
    // Function to Rotate the 
    // matrix by 180 degree 
    static void rotateMatrix(int mat[][]) 
    { 
  
        // Simply print from last 
        // cell to first cell. 
        for (int i = mat.length - 1; i >= 0; i--) { 
            for (int j = mat[i].length - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " "); 
            }
            System.out.println(); 
        } 
    } 
  
    // Driver Code 
    public static void main(String[] args) 
    { 
        int[][] mat = { { 1, 2, 3 }, 
                        { 4, 5, 6 }, 
                        { 7, 8, 9 } }; 
  
        rotateMatrix(mat); 
    } 
}
