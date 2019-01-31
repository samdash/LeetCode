package strings;

/*
 Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance {

	public static void main(String[] args) {
		 String word1 = "horse", word2 = "ros";
		 
		 EditDistance ed = new EditDistance();
		 int value = ed.minDistance(word1, word2);
		 System.out.println(value);
		 value = ed.findMinEditDistance(word1,word2);
		 System.out.println(value);
	}

	public int minDistance(String s1, String s2) {
        return minDistanceHelperDP(s1, s2, s1.length(), s2.length());
    }
    
    private int minDistanceHelperDP(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i=0;i<=m;i++) {
            for (int j=0;j<=n;j++) {
                // First substring is empty
                if (i == 0) {
                    dp[i][j] = j;
                }
                // Second substring is empty
                else if (j == 0) {
                    dp[i][j] = i;
                }
                // If character are same, value is same as the previous dp array
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // If different, then 1 + min of diagonal,left and up 
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }
    
    
    
    public int findMinEditDistance(String s1 , String s2 ) {
    	
    	int[][] dp = new int[s1.length()+1][s2.length()+1];
    	
    	for(int i=0;i< s1.length() +1 ; i++) {
    		for(int j=0;j< s2.length() +1 ; j++) {
    			if(i == 0 && j ==0 ) dp[i][j] = 0; // first row and column are null string's , first 0th col and 0th row starts with 0.
    			else if(i == 0) dp[i][j] = dp[i][j-1] +1;
    			else if(j == 0) dp[i][j] = dp[i-1][j] +1;
    			else {
    				if(s1.charAt(i-1) == s2.charAt(j-1)) {
    					dp[i][j] = dp[i-1][j-1];
    				}else {
    					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
    				}
    			}
    			
    		}
    	}
    	
    	return dp[s1.length()][s2.length()];
    }
    
}
