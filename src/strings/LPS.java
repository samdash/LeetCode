package strings;

import java.util.Arrays;

// Longest palindrome subsequence

public class LPS {

	public static void main(String[] args) {
		String s = "abca"; // longest is aba
		String s1 = "adbgcfbea"; // longest is abgba
		LPS lps = new LPS();
		System.out.println(lps.longestPalindromeSubseq(s));
	}
	
	 // another way of doing this.
	 public int longestPalindromeSubsequence(String s) {
	        int[][] matrix = new int[s.length()][s.length()];
	        // set all the diagonals to 1
	        for(int i=0;i<s.length();i++) {
	        	matrix[i][i]=1; 
	        }
	        
	        return helper(matrix,0,s.length()-1,s);
	    }
     private int helper(int[][] matrix,int i,int j,String s){
        // base case
    	if(i>j || matrix[i][j]!=0) { 
        	return matrix[i][j];
        }
    	// for each cell above diagonal , if the characters match then add +2
        if(s.charAt(i)==s.charAt(j)) { 
        	
        	matrix[i][j]=helper(matrix,i+1,j-1,s)+2; // add +2 to the existing diagonal value
        
        }
        else {
        	matrix[i][j]= Math.max(helper(matrix,i,j-1,s),helper(matrix,i+1,j,s) );// then get max of left cell and down cell 
        }
        return matrix[i][j];
     }
    
    
	 public int longestPalindromeSubseq(String s) {
	        int[][] dp = new int[s.length()][s.length()];
	        
	        for (int i = s.length() - 1; i >= 0; i--) {
	            dp[i][i] = 1; // set all the diagonals to 1
	            for (int j = i+1; j < s.length(); j++) {
	                if (s.charAt(i) == s.charAt(j)) {
	                    dp[i][j] = dp[i+1][j-1] + 2;	// add +2 to the existing diagonal value
	                } else {
	                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]); // then get max of left cell and down cell  of current cell
	                }
	            }
	        }
	        return dp[0][s.length()-1]; // result will be in the first row and last column
	    }
	 

}
