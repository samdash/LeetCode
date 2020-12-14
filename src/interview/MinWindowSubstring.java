package interview;



/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

 */
public class MinWindowSubstring {

	public static void main(String[] args) {
		String s = "abaacd";//"ADOBECODEBANC";
		String t = "abc";
		
		MinWindowSubstring ms = new MinWindowSubstring();
		String result = ms.minWindow(s, t);
		System.out.println(result);
		
	}

	public String minWindow(String s, String t) {
        int[] map = new int[256]; // or 128 or 256 if CAPITAL LETTERS
        for(int i=0; i<t.length(); i++){
            map[t.charAt(i)]++;
        }
        int lo = 0, hi = 0, head = 0;
        int count = 0, min = Integer.MAX_VALUE;
        while(hi<s.length()){
            char c = s.charAt(hi++);
            if(map[c]-- > 0) {
            	count++;
            }
            while(count == t.length()){
                if(hi - lo < min){
                    min = hi - lo;
                    head = lo;
                }
                if(map[s.charAt(lo++)]++ >=0 )count--; 
            }
        }
        return min == Integer.MAX_VALUE?"":s.substring(head, head+min);
    }
	
	public String minWindowII(String s, String t) {
        int[] map = new int[26];  // works with only smaller case letters
        for(int i=0; i<t.length(); i++){
            map[t.charAt(i)- 'a']++;// works with only smaller case letters
        }
        int lo = 0, hi = 0, head = 0;
        int count = 0, min = Integer.MAX_VALUE;
        while(hi<s.length()){
            char c = s.charAt(hi++);
            if(map[c -'a']-- > 0) {
            	count++;
            }
            while(count == t.length()){
                if(hi - lo < min){
                    min = hi - lo;
                    head = lo;
                }
                if(map[s.charAt(lo++) -'a']++ >=0 ) {
                	count--; 
                }
            }
        }
        return min == Integer.MAX_VALUE?"":s.substring(head, head+min);
    }

	
public String minWindow(String s, String t) {
    HashMap<Character, Integer> goal = new HashMap<>();
    int goalSize = t.length();
    int minLen = Integer.MAX_VALUE;
    String result = "";
 
    //target dictionary
    for(int k=0; k<t.length(); k++){
        goal.put(t.charAt(k), goal.getOrDefault(t.charAt(k), 0)+1);
    }
 
    int i=0;
    int total=0;
    HashMap<Character, Integer> map = new HashMap<>();
    for(int j=0; j<s.length(); j++){
        char c = s.charAt(j);
        if(!goal.containsKey(c)){
            continue;
        }
 
        //if c is a target character in the goal, and count is < goal, increase the total
        int count = map.getOrDefault(c, 0);
        if(count<goal.get(c)){
            total++;
        }
 
        map.put(c, count+1);
 
        //when total reaches the goal, trim from left until no more chars can be trimmed.
        if(total==goalSize){
            while(!goal.containsKey(s.charAt(i)) || map.get(s.charAt(i))>goal.get(s.charAt(i))){
                char pc = s.charAt(i);
                if(goal.containsKey(pc) && map.get(pc)>goal.get(pc)){
                    map.put(pc, map.get(pc)-1);
                }
 
                i++;
            }
 
            if(minLen>j-i+1){
                    minLen = j-i+1;
                    result = s.substring(i, j+1);
            }
        }            
    }
 
    return result;
}	
	
}
