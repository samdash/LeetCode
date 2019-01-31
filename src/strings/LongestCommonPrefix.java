package strings;


/*
 Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		 String[] strs = {"flower","flow","flight"};
		 System.out.println(longestCommonPrefix(strs));
	}

	/*
	  take the first word " flower " and keep checking character by character in other words
	   1) check if "f" is first character in other words
	   2) check if "fl" are first character in other words, and keep repeating until it is not same.
	   3) if it is not same return substring of 0 to length of matched characters.
	  	
	 */
	public static String longestCommonPrefix(String[] strs) {

		for( int index = 0;index<strs[0].length();index++) {
			char c = strs[0].charAt(index);
			for(int i=1;i<strs.length;i++) {
				if(strs[i].charAt(index)!=c) {
					return strs[i].substring(0, index);
				}
			}
		}
		return strs[0];
	}
	
	 public static String longestCommonPrefixII(String[] strs) {
	        if (strs.length == 0) return "";
	        String pre = strs[0]; // get the first word
	        for (int i = 1; i < strs.length; i++) { // iterate from second word
	            while(strs[i].indexOf(pre) != 0)
	                pre = pre.substring(0,pre.length()-1);
	        }
	        return pre;
	    }
	
}
