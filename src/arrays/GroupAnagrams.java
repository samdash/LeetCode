package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Given an array of strings, group anagrams together.

//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:

//[
//["ate", "eat","tea"],
//["nat","tan"],
//["bat"]
//]
//Note: All inputs will be in lower-case.
public class GroupAnagrams {

	public static void main(String[] args) {
		 String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
		 List<List<String>> list = groupAnagrams(words);
		 System.out.println(list);
		  
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(String s : strs) {
        	
        	char[] chars = s.toCharArray();
        	
        	Arrays.sort(chars);
        	
        	String key = String.valueOf(chars);
        	map.putIfAbsent(key, new ArrayList<String>());
        	
        	map.get(key).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
        
	}
}
