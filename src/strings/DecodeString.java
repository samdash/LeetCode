package strings;

import java.util.Stack;

/*
Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 

For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

	public static void main(String[] args) {
		String s = "3[a]2[bc]11[x]";
		String s1 = "2[abc]3[cd]ef";
		DecodeString dss = new DecodeString();
		String value = dss.decodeString(s);
		System.out.println(value);
	}
	
	public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
         
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
         
        String ans = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    int digit = Character.getNumericValue(s.charAt(i));
                    num = num * 10 + digit;
                    i++;
                }
                 
                numStack.push(num);
            } else if (c == '[') {
                strStack.push(ans);
                i++;
                ans = "";
            } else if (c == ']') {
                int num = numStack.pop();
                StringBuilder sb = new StringBuilder(strStack.pop());
                for (int r = 0 ; r < num; r++) {
                    sb.append(ans);
                }
                 
                ans = sb.toString();
                i++;
            } else {
                ans += c;
                i++;
            }
        }
         
        return ans;
    }
}
