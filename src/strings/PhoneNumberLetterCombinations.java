package strings;

import java.util.LinkedList;
import java.util.List;

/*
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.


 */
public class PhoneNumberLetterCombinations {

	public static void main(String[] args) {
		
		PhoneNumberLetterCombinations p = new PhoneNumberLetterCombinations();
		System.out.println(p.letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        
        if (digits.length() == 0)   return ans;
        
        String[] ref = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        ans.add("");
        
        while (ans.peek().length() != digits.length()) {
            String remove = ans.poll();
            String map = ref[digits.charAt(remove.length()) - '0'];
            System.out.println(remove+" map--> "+map);
            for (int i = 0; i < map.length(); i++)
                ans.addLast(remove + map.charAt(i));
        }
        
        return ans;
    }
}
