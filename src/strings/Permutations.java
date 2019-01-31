package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

	// abc
	
	public static void main(String[] args) {
		String s = "ABC";
		// add Set to remove duplicates if there are any
		Set<String> set = new HashSet<String>();
		 permutation("",s);
		 //permutationsWithDuplicates(s,"",set);
		
	}
	
	public static void permutation(String chosen,String s) {
		indent(chosen.length());
		String temp = "permutation(\""+chosen+"\",\""+s+"\")";
		System.out.println(temp);
		int n = s.length();
		if(n ==0) {
			System.out.println(chosen.toUpperCase());
		}else {
			for ( int i=0;i<s.length();i++ ) {
				permutation(chosen+s.charAt(i),s.substring(0, i) + s.substring(i+1, s.length()));
			}
		}
	}

	public static void permutationsWithDuplicates(String s ,String chosen, Set<String> set) {
		indent(chosen.length());
		String temp = "permutation(\""+s+"\",\""+chosen+"\")";
		System.out.println(temp);
		int n = s.length();
		if(n ==0) {
			if(!set.contains(chosen)) {
				set.add(chosen);
				System.out.println(chosen.toUpperCase());
			}
		}else {
			for ( int i=0;i<s.length();i++ ) {
				permutationsWithDuplicates(s.substring(0, i) + s.substring(i+1, s.length()),chosen+s.charAt(i),set);
			}
		}
	}

	public static void indent(int n) {
		for(int i=0;i<n;i++)System.out.print("    ");
	}
	
	/*
     * Better recursion: backtracking
     */
    public static ArrayList<String> getPermutations2(String s) {
        if (s == null) return null;
        ArrayList<String> result = new  ArrayList<String>();
        permute(result, "", s.toCharArray());
        return result;
    }

    private static void permute(ArrayList<String> result, String curr, char[] s) {
        if (curr.length() == s.length) {
            result.add(curr);
        } else {
            for (int i = 0; i < s.length; ++i) {
                if (s[i] == '\0') continue;
                char ch = s[i];
                s[i] = '\0';
                permute(result, curr + ch, s);
                s[i] = ch;
            }
        }
    }

}
