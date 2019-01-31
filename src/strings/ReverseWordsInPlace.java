package strings;

import java.util.Stack;

/*
 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInPlace {

	public static void main(String[] args) {

		String str = "Let's take LeetCode contest ";
		String result = reverseWords(str);
		System.out.println(result);
	}

	public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String st : str){
            String tmp = reverse(st);
            sb.append(tmp).append(" ");
        }
        return sb.toString().trim();
    }
	
    private static String reverse(String str){
        int start = 0, end = str.length() - 1;
        char[] chs = str.toCharArray();
        while(start < end){
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
        return new String(chs);
    }
	
    
	public static void reverseWordsUsingStack(String str) {
		
		Stack<Character> st=new Stack<Character>(); 
		String result = "";
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i) != ' ')
				st.push(str.charAt(i));
			else {
				result += " ";
				while( !st.isEmpty())
					result += st.pop();
			}
		}
		
		
		System.out.println(result);
		
	}
	
	public String reverseWordsIII(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

}
