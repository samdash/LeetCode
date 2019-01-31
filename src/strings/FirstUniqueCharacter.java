package strings;

/*
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.  -- > l is first not repeating and index = 0;

s = "loveleetcode",
return 2.  --> v is first not repeating and index = 2
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacter {

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(s.charAt(firstUniqueChar(s)));
		System.out.println(s.charAt(lastUniqueChar(s)));

	}
	
	public static int firstUniqueChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
	
	public static int lastUniqueChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = s.length()-1; i>0 ;i --)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;

	}
}
