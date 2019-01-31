package arrays;

import java.util.LinkedList;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class NumberOfIslandsII {

	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
				};

		NumberOfIslandsII noi = new NumberOfIslandsII();
		int result = noi.numIslands(grid);
		System.out.println(result);
		
	}
	//Using Flood Fill algorithm:
	public int numIslands(char[][] grid) {
	    int count=0;
	    for(int i=0;i<grid.length;i++)
	        for(int j=0;j<grid[0].length;j++){
	            if(grid[i][j]=='1'){
	                dfsFill(grid,i,j);
	                count++;
	            }
	        }
	    return count;
	}
	private void dfsFill(char[][] grid,int i, int j){
	    if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
	        grid[i][j]='0';
	        dfsFill(grid, i + 1, j);
	        dfsFill(grid, i - 1, j);
	        dfsFill(grid, i, j + 1);
	        dfsFill(grid, i, j - 1);
	    }
	}
	
	private void bfsFill(char[][] grid,int x, int y){
	    grid[x][y]='0';
	    int n = grid.length;
	    int m = grid[0].length;
	    LinkedList<Integer> queue = new LinkedList<Integer>();  
	    int code = x*m+y;  
	    queue.offer(code);  
	    while(!queue.isEmpty())  
	    {  
	        code = queue.poll();  
	        int i = code/m;  
	        int j = code%m;  
	        if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
	        {  
	            queue.offer((i-1)*m+j);  
	            grid[i-1][j]='0';  
	        }  
	        if(i<n-1 && grid[i+1][j]=='1')  //down
	        {  
	            queue.offer((i+1)*m+j);  
	            grid[i+1][j]='0';  
	        }  
	        if(j>0 && grid[i][j-1]=='1')  //left
	        {  
	            queue.offer(i*m+j-1);  
	            grid[i][j-1]='0';  
	        }  
	        if(j<m-1 && grid[i][j+1]=='1')  //right
	        {  
	            queue.offer(i*m+j+1);  
	            grid[i][j+1]='0';  
	        }
	    } 
	}
}
