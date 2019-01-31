package strings;
/*
Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
 */
public class IsOneEditDistance {

	public static void main(String[] args) {
		String s = "ab";
		String t = "acb";
		
		System.out.println(isOneEditDistanceII(s, t));

	}

	public static boolean isOneEditDistanceII(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        if (Math.abs(n - m) > 1 || s.equals(t)) {
            return false;
        }
        
        int l = Math.min(m, n);
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i))  //delete
                    || s.substring(i + 1).equals(t.substring(i + 1)) // replace
                    || s.substring(i).equals(t.substring(i + 1)); // insert
            }
        }
        
        return true;
    }

	
	
	public static boolean isOneEditDistance(String s, String t) {
        //replace one character  by adding one character by removing one character
        if (s.length() != t.length() && s.length() + 1 != t.length() &&s.length() != t.length() + 1) {
            return false;
        }
        if (s.equals(t)) {
            return false;
        }
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i ++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
            return false;
        }
        else {
            String longer = s;
            String shorter = t;
            if (s.length() < t.length()) {
                longer = t;
                shorter = s;
            }
            for (int i = 0; i < shorter.length(); i ++) {
                if (shorter.charAt(i) != longer.charAt(i)) {
                    return shorter.substring(i).equals(longer.substring(i + 1));
                }
            }
            return true;
        }
    }
	
	
}
