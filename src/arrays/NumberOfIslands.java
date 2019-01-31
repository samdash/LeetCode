package arrays;

public class NumberOfIslands {

	public static void main(String[] args) {
		
		char[][] grid1 = {
						{'1','1','0','0','0'},
						{'0','0','0','0','0'},
						{'0','0','1','1','0'},
						{'0','0','1','1','0'}
						};
		char[][] grid2 = {
		{'1','1','1'},
		{'0','1','0'},
		{'1','1','1'}
		};
		
		
			NumberOfIslands s = new NumberOfIslands();
			System.out.println("Result for grid1 : "+s.numIslands(grid1));
			System.out.println("Result for grid2 : "+s.numIslands(grid2));
				
		}

	
	 public  int numIslands(char[][] grid) {
		 int count =0;
		 for(int i=0;i<grid.length;i++) {
			 for(int j=0;j<grid[i].length;j++) {
				 if(isLand(grid,i,j)) {
					 count++;
				 }
			 }
		 }
		 return count;
	 }

	private  boolean isLand(char[][] grid, int i, int j) {
		
		if(grid[i][j] == '1') {
			grid[i][j] = 'x';
			if(i >= 1) isLand(grid,i-1,j);
			if(j >= 1) isLand(grid,i,j-1);
			if(i < grid.length -1)isLand(grid,i+1,j);
			if(j < grid[0].length -1)isLand(grid,i,j+1);
			return true;
		}
		return false;
	}
	 
	 
}
