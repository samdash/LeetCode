package arrays;

import java.util.*;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to O.
 * Hints: #17, #74, #102
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        // expected output
        // [0, 0, 0, 0]
        // [0, 1, 0, 1]
        // [0, 0, 0, 0]
        zeroMatrix(matrix);

        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static int[][] zeroMatrix(int[][] matrix) {
        int[] zero = new int[matrix[0].length];
        Arrays.fill(zero, 0);
//        for (int i = 0; i < zero.length; i++) {
//            zero[i] = 0;
//        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                	matrix[i] = zero;
                    
                    set.add(j);// keep track of the columns, since we are zeroing only rows above
                    break;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (Integer s : set) {
                matrix[i][s] = 0;
            }
        }
        return matrix;
    }
}