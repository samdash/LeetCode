package strings;

import java.util.Arrays;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		String s = "ab";
		String p = ".*";
		RegularExpressionMatching rem = new RegularExpressionMatching();
		boolean result = rem.isMatch(s, p);
		System.out.println(result);
		result = rem.isMatchDP(s, p);
		System.out.println(result);

		
	}
	
	public boolean isMatch(String s, String p) {
	    if (p.length() == 0) {
	        return s.length() == 0;
	    }
	    if (p.length() > 1 && p.charAt(1) == '*') {  // second char is '*'
	        if (isMatch(s, p.substring(2))) {
	            return true;
	        }
	        if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
	            return isMatch(s.substring(1), p);
	        }
	        return false;
	    } else {                                     // second char is not '*'
	        if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
	            return isMatch(s.substring(1), p.substring(1));
	        }
	        return false;
	    }
	}

	public boolean isMatchDP(String s, String p) {
        boolean dp[][] = new boolean[1+s.length()][1+p.length()];
        dp[0][0] = true;
        // Init First Row
        for (int j = 2; j < dp[0].length; j+=2) {
            if (p.charAt(j-1) == '*') dp[0][j] = dp[0][j-2];
        }
        System.out.println(Arrays.deepToString(dp));
        // First Col default to false
        
        // Start DP here
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    } 
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
