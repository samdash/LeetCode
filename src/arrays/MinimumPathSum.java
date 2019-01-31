package arrays;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};

		MinimumPathSum mps = new MinimumPathSum();
		int result = mps.minPathSum(grid);
		System.out.println(result);
	}
	public int minPathSum(int[][] grid) {
		int rowLength = grid.length, colLength = grid[0].length;
		for(int i = 0; i < rowLength; i++){
			for(int j = 0; j < colLength; j++){
				if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
				if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
				if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
		}
		return grid[rowLength-1][colLength-1];
	}
	
}
