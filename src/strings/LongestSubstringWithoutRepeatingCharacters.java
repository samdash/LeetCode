package strings;

/*
 Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
import java.util.HashSet;
import java.util.Set;


public class LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String[] args) {
		System.out.println(longest("abcabcbb"));
	}
	
		
	public static int longest(String s) {
		int max = 0;
		
		Set<Character> set = new HashSet<>();
    	for(int i = 0; i < s.length(); i++) {
    		if(set.contains(s.charAt(i))) {
    			set.remove(s.charAt(i));
    		}else {
    			set.add(s.charAt(i));
    			max = Math.max(max,set.size());
    		}
    	}
		
		return max;
	}
}
