package strings;

import java.util.Arrays;
/*
Given two lowercase strings, S1 and S2, sort S1 in same order as S2. If a character in S1 doesn't exist in S2, put them at the end. 
If S1 is "program" and S2 is "grapo", then return "grrapom".  
 */
public class SortBasedOnSecondString {

	public static void main(String[] args) {
//	    String s1 = "grapo";
//	    String s2 = "program";
	    String s1 = "war";
	    String s2 = "Its awesome being a programmer";
	    
	    String result = "";
	    for (int i = 0; i < s1.length(); i++) {
	        int len = s2.length() - s2.replace(String.valueOf(s1.charAt(i)), "").length();

	        s2 = s2.replace(String.valueOf(s1.charAt(i)), "").replace(" ", "");

	        for (int j = 0; j < len; j++)
	            result = result + String.valueOf(s1.charAt(i));
	    }

	    char[] remaining = s2.toCharArray();
	    Arrays.sort(remaining);
	    for (Character c : remaining)
	        result = result + String.valueOf(c);

	    System.out.println(result);
	}
}
