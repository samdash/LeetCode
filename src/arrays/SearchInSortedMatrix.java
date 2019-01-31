package arrays;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
	       int [][] matrix = {
	        		{10,20,30,40},
	        		{12,22,33,45},
	        		{14,24,44,47},
	        		{16,26,46,50}
   			};

	       
	       boolean found = find(matrix, 16);
	       
	       System.out.println(found);
	}
	
	public static boolean find(int[][] matrix, int target) {
		
		int i = 0;
		int j = matrix[0].length -1;
		
		while( i< matrix.length && j>=0 ) { // start from last column first row ( i=0 and j = 3 ) which is 40
			if(target == matrix[i][j]) {
				return true;
			}else if( target < matrix[i][j]) { // if target is less than 40 , then decrement column ( as column values are ascending and you wont find any thing here
				j--;
			}else i++;
		}
		
		
		return false;
	}

}
