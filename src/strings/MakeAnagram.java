package strings;

import java.util.Arrays;

public class MakeAnagram {

	// how many characters to remove to make 2 strings anagram
	// hello and billion -- > remove " heo " from hello and "biin" from billion , so we need to remove total 6 characters
	public static void main(String[] args) {
		 
		System.out.println(numberNeeded("hello","billion"));
	}
	
	public static int numberNeeded(String first, String second) {
		
		int[] charCount1 = getCharCounts(first);
		System.out.println("-----");
		int[] charCount2 = getCharCounts(second);
		return getDelta(charCount1,charCount2);
		
	}
	
	public static int[] getCharCounts(String s) {
		
		int[] charCounts = new int[26];
		for(int i=0;i< s.length();i++) {
			char c = s.charAt(i);
			int code = c - 'a';
			//System.out.println("c: "+c+" offset: "+offset+" code: "+code);
			charCounts[code]++;

		}
		System.out.println(Arrays.toString(charCounts));

		return charCounts;
	}
	
	public static int getDelta(int[] first, int[] second) {
		int delta =0;
		for(int i=0;i<first.length;i++) {
			int diff = Math.abs(first[i] - second[i]);
			delta += diff;
		}
		return delta;
	}

}
