package strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
public class PalindromePartition {

	public static void main(String[] args) {

		String s = "aab";
		PalindromePartition pp = new PalindromePartition();
		List<List<String>> list = pp.partition(s);
		System.out.println(list);
	}

	public List<List<String>> partition(String s) {
		   List<List<String>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), s, 0);
		   return list;
		}

	public void backtrack(List<List<String>> list, List<String> chosen, String s, int start){
	   if(start == s.length())
	      list.add(new ArrayList<>(chosen));
	   else{
	      for(int i = start; i < s.length(); i++){
	         if(isPalindrome(s, start, i)){
	            chosen.add(s.substring(start, i + 1));
	            backtrack(list, chosen, s, i + 1);
	            chosen.remove(chosen.size() - 1);
	         }
	      }
	   }
	}

	public boolean isPalindrome(String s, int low, int high){
	   while(low < high)
	      if(s.charAt(low++) != s.charAt(high--)) return false;
	   return true;
	} 
}
