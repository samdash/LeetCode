package strings;

import java.util.HashMap;

/*
 Isomorphic Strings
 
 Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 */
public class Isomorphic {

	public static void main(String[] args) {
		 String s = "paper";
		 String t = "title";
		 Isomorphic c = new Isomorphic();
		 System.out.println(c.isIsomorphic(s, t));

	}

	public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
       int size = s.length();
       for(int i = 0;i < size; i++){
           if(map.containsKey(s.charAt(i))){
               if(t.charAt(i) != map.get(s.charAt(i))){
                   return false;
               }
           }else{
               if(map.containsValue(t.charAt(i))){
                   return false;
               }
               map.put(s.charAt(i), t.charAt(i));
           }
       }
       return true;
    }
}
