package design;

public class ConnectedCells {

	public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}};

            int result = getBiggestRegion(matrix);
            System.out.println(result);
            
	}
	
	public static int getBiggestRegion(int[][] matrix) {
		int maxRegion =0;
		for(int row =0;row<matrix.length;row++) {
			for(int column = 0 ; column < matrix[row].length;column++) {
				if(matrix[row][column] == 1) {
					int size = getRegion(matrix,row,column);
					maxRegion = Math.max(size, maxRegion);
				}
			}
		}
		
		return maxRegion;
	}
        
	public static int getRegion(int[][] matrix,int row, int col) {
		if(row<0 || col<0 || row>= matrix.length || col >= matrix[0].length) {
			return 0;
		}
		
		if(matrix[row][col] == 0) return 0;
		
		matrix[row][col] = 0;
		int size = 1;
		// now go all the 8 directions 
		for( int r = row -1 ; r <= row +1; r++) {
			for(int c = col -1; c<=col+1; c++) {
				if(r !=row || c != col) {
					size += getRegion(matrix,r,c);
				}
			}
		}
		
		return size;
	}

}
