package strings;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println(isAnagram(s,t));
		System.out.println(simple(s,t));

	}

	public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        System.out.println();
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
	
	public static boolean isAnagramII(String s1, String s2) { 
		
		if(s1.length() != s1.length()) return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		int[] letters = new int[256]; // int[1<<8]
		
		for ( char c: s1.toCharArray()) {
			letters[c]++;
		}
		for(char c: s2.toCharArray()) {
			letters[c]--;
		}
		
		for ( int i: letters) {
			if( i!=0) return false;
		}
		
		return true;
	}
	
	// another simple solution, just sort both and compare
	public static boolean simple(String s1, String s2) {
		char[] a = s1.toCharArray();
		Arrays.sort(a);
		char[] b = s2.toCharArray();
		Arrays.sort(b);
		
		if(String.valueOf(a).equals(String.valueOf(b))) return true;
		else return false;
		
	}
}
