package strings;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {
				{'X','B','C','E'},
				{'S','F','C','S'},
				{'R','D','E','E'}
		};
		String word = "BCCED";
		
		WordSearch ws = new WordSearch();
		boolean found = ws.exist(board, word);
		if(found) System.out.println("found the word");
		else System.out.println("did not find the word");
	}
	
	static boolean[][] visited;
	
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(word.charAt(0) == board[row][col]){ 
                	if(search(board, word, row, col, 0))
                		return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int row, int col, int index){
        if(index == word.length()){
            return true;
        }
        
        if(row >= board.length || row < 0 || col >= board[row].length || col < 0 || board[row][col] != word.charAt(index) || visited[row][col]){
            return false;
        }
        
        visited[row][col] = true;
        if(search(board, word, row-1, col, index+1) ||  // up
           search(board, word, row+1, col, index+1) ||  // down
           search(board, word, row, col-1, index+1) ||  // left
           search(board, word, row, col+1, index+1)){   // right
            return true;
        }
        
        visited[row][col] = false;
        return false;
    }

}
