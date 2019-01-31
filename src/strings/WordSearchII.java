package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tries.Trie;

/*
 Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.

 */
public class WordSearchII {

	public static void main(String[] args) {
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		WordSearchII wsII = new WordSearchII();
		List<String>list = wsII.findWords(board, words);
		System.out.println(list);
	}

	Set<String> res = new HashSet<String>();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, visited, "", row, col, trie);
            }
        }
        
        return new ArrayList<String>(res);
    }
    
    public void dfs(char[][] board, boolean[][] visited, String str, int row, int col, Trie trie) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if (visited[row][col]) return;
        
        str += board[row][col];
        if (!trie.startsWith(str)) return;
        
        if (trie.search(str)) {
            res.add(str);
        }
        System.out.println("row: "+row+" col: "+col);
        visited[row][col] = true;
        dfs(board, visited, str, row - 1, col, trie); // up
        dfs(board, visited, str, row + 1, col, trie); // down
        dfs(board, visited, str, row, col - 1, trie); // left
        dfs(board, visited, str, row, col + 1, trie); // right
        visited[row][col] = false;
    }
}
