package strings;

import java.util.Arrays;

public class IsPermutation {

	public static void main(String[] args) {

		String s1 = "ad";
		String s2 = "af";
		
		IsPermutation ip = new IsPermutation();
		boolean result = ip.isPermutation(s1, s2);
		System.out.println(result);
		
	}

	
	boolean isPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        int[] charCount = new int[256];
        for (int i = 0; i < s1.length(); ++i) {
            ++charCount[s1.charAt(i)];
        }

        for (int i = 0; i < s2.length(); ++i) {
            if (--charCount[s2.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    boolean isPermutation2(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return new String(charArray1).equals(new String(charArray2));
    }
}
