package strings;

import java.util.HashSet;
import java.util.Set;

/*
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class LongestPalindromeLength {

	public static void main(String[] args) {
		String s = "racecarX";
		LongestPalindromeLength lp = new LongestPalindromeLength();
		int size = lp.longestPalindrome(s);
		System.out.println(size);
	}


	
	public int longestPalindrome(String s) {
    	Set<Character> set = new HashSet<Character>();
    	System.out.println(s.length());
    	for(int i = 0; i < s.length(); i++) {
    		
    		if(set.contains(s.charAt(i))) {
    			set.remove(s.charAt(i));
    		} else {
    			set.add(s.charAt(i));
    		}
    	}
    	// the middle one element will be unique in palindrome and will not be removed from set
    	if(set.size() < 2) { 
    		return s.length();
    	} else {
    		return s.length() - set.size() + 1; 
    	}
    }
	
}
