package queues;

import java.util.Arrays;

/***
  
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2 power of 31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4 

 */
public class WallsAndGates {

	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		
		int[][] rooms = {
				{max,-1,0,max},
				{max,max,max,-1},
				{max,-1,max,-1},
				{0,-1,max,max}
		};
		
		WallsAndGates w = new WallsAndGates();
		w.wallsAndGates(rooms);
		
		System.out.println(Arrays.deepToString(rooms));
	}

	 public void wallsAndGates(int[][] rooms) {
	      
	        if(rooms.length == 0 || rooms[0].length == 0) 
	            return;
	        for(int row = 0; row < rooms.length; row++) {
	            for(int col = 0; col < rooms[0].length; col++) {
	                if(rooms[row][col] == 0) bfs(rooms, row, col, 0);
	            }
	        }
	    }
	    private void bfs(int[][] rooms, int row, int col, int distance) {
	        if(row<0||row>=rooms.length ||col<0||col>=rooms[row].length|| rooms[row][col] < distance)
	            return;
	        rooms[row][col] = distance;
	        bfs(rooms, row+1, col, distance+1);
	        bfs(rooms, row-1, col, distance+1);
	        bfs(rooms, row, col+1, distance+1);
	        bfs(rooms, row, col-1, distance+1);  
	    }
}
