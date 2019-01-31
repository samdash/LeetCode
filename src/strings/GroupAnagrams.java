package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] s = {"ate","eat","bat","tab","man"};
		System.out.println(groupAnagrams(s));				
	}

	
	public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
	
}
