package interview;

/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character 
which is less than any other character https://en.wikipedia.org/wiki/Lexicographical_order.
 

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.

 */
public class AlienDictionary {

	public static void main(String[] args) {

//		String[] words = {"word","world","row"};
//		String order = "worldabcefghijkmnpqstuvxyz";
		// words = ['ac',aa'] return true
		// words - [ 'cc','ac','bc'] return false
		// words - ['ac','bc'] return false
		// words - {"cca","bcd","aca","aaa"}; return true
		String[] words = {"ac","aa"}; 
		String order = "cba";

		
		AlienDictionary ad = new AlienDictionary();
		boolean result = ad.isAlienSorted(words, order);
		System.out.println(result);

	}

	/*
Explanation
Build a transform mapping from order, Find all alien words with letters in normal order.
For example, if we have order = "xyz..."
We can map the word "xyz" to "abc" or "123"
Then we check if all words are in sorted order.

Time complexity
O(NS)

	 
	 */
	
	int[] mapping = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (compare(words[i - 1], words[i]) > 0)
                return false;
        return true;
    }

    int compare(String s1, String s2) {              // (-) if s1 < s2, 0 if equal, (+) if s1 > s2
        int n = s1.length(), m = s2.length();
        
        for(int i = 0, j = 0; i < n && j < m; i++, j++) {
            int pos1 = mapping[ s1.charAt(i) - 'a' ];
            int pos2 = mapping[ s2.charAt(j) - 'a' ];
            
            if (pos1 != pos2)         
                return pos1 - pos2;
        }
        
        return n - m;
    }
    
    //OR 
    
    int compareII(String s1, String s2) {
        int n = s1.length(), m = s2.length(), cmp = 0;
        for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
            cmp = mapping[s1.charAt(i) - 'a'] - mapping[s2.charAt(j) - 'a'];
        }
        return cmp == 0 ? n - m : cmp;
    }
    
    
	
}
