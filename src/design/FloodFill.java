package design;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class FloodFill {

    private static final String SEPARATOR = "--------------------------------------------------------------------";

    public static void main(String[] args) {

        // Setup the matrix.
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 1, 2, 2, 1, 1},
                {1, 1, 2, 2, 1, 1},
                {2, 2, 2, 2, 2, 2}};


        // Approach 1 : Using STACK.
        {

            System.out.println("************** STACK APPROACH ************* \n");

            final long stackApproachStart = System.nanoTime();

            Stack<Pair> stack = new Stack<>();
            Set<Pair> visited = new HashSet<>();

            // Starting point.
            Pair start = new Pair(2, 2);
            stack.add(start);

            while (!stack.isEmpty()) {
                Pair pair = stack.pop();
                if (matrix[pair.row][pair.col] == 3) {
                    continue;
                }
        		for( int r = pair.row -1 ; r <= pair.row +1; r++) {
        			for(int c = pair.col -1; c<=pair.col+1; c++) {
        	            if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] != 2 || visited.contains(new Pair(r, c))) {
        	                continue;
        	            }
                        stack.add(new Pair(r, c));

        			}
                }
                visited.add(pair);
                matrix[pair.row][pair.col] = 3;
            }

            printMatrix(matrix);

            System.out.println("\nTotal time taken by STACK approach : [" + (System.nanoTime() - stackApproachStart) / 1000 + "] us\n");
        }

        System.out.println(SEPARATOR);

        // Approach 2 : Using DFS.
        {

            System.out.println("\n************** DFS APPROACH ************* \n");

            final long dfsApproachStart = System.nanoTime();

            Set<Pair> visited = new HashSet<>();

            // Starting point.
            Pair start = new Pair(2, 2);

            dfsOnMatrix(start, matrix, visited);

            printMatrix(matrix);

            System.out.println("\nTotal time taken by DFS approach : [" + (System.nanoTime() - dfsApproachStart) / 1000 + "] us");
        }
    }

    private static void dfsOnMatrix(final Pair pair, final int[][] matrix, final Set<Pair> visited) {
        if (matrix[pair.row][pair.col] == 3) {
            return;
        }
        visited.add(pair);
        matrix[pair.row][pair.col] = 3;

		for( int r = pair.row -1 ; r <= pair.row +1; r++) {
			for(int c = pair.col -1; c<=pair.col+1; c++) {
	            if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] != 2 || visited.contains(new Pair(r, c))) {
	                continue;
	            }
	            dfsOnMatrix(new Pair(r,c), matrix, visited);

			}
		}		
    }

    private static void printMatrix(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    private static class Pair {

        private int row;
        private int col;

        public Pair(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Pair pair = (Pair)o;
            return row == pair.row &&
                    col == pair.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row,col);
        }
    }
}