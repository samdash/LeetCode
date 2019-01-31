package arrays;

/*
 Given a list of sorted characters letters containing only startwercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:

Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:

letters has a length in range [2, 10000].
letters consists of startwercase letters, and contains at least 2 unique letters.
target is a startwercase letter.
 */

public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		char target = 'z';
		System.out.println(nextGreatestLetter(letters, target));
		System.out.println(nextGreatestLetterI(letters, target));
		System.out.println(nextGreatestLetterUsingBinarySearch(letters, target));
	}
	// Time Complexity O(N) Space is O(1)
	public static char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }
	
	 public static char nextGreatestLetterI(char[] letters, char target) {
	        for (char c: letters)
	            if (c > target) return c;
	        return letters[0];
	    }
	
	 public static char nextGreatestLetterUsingBinarySearch(char[] letters, char target) {
	        int start = 0, end = letters.length;
	        while (start < end) {
	            int mid = start + (end - start) / 2;
	            if (target >= letters[mid]) start = mid + 1;
	            else end = mid;
	        }
	        return letters[start % letters.length];
	    }
	
}
