package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutations {
    private static Set < String > set = new HashSet < > ();


	public static void main(String[] args) {
		PalindromePermutations p = new PalindromePermutations();
		List<String> list = p.generatePalindromes("baab");
		System.out.println(list);
		
	}
	
	    public List < String > generatePalindromes(String s) {
	        permute(s.toCharArray(), 0);
	        return new ArrayList < String > (set);
	    }
	    
	    void permute(char[] s, int l) {
	        if (l == s.length) {
	            if (isPalindrome(s))
	                set.add(new String(s));
	        } else {
	            for (int i = l; i < s.length; i++) {
	                swap(s, l, i);
	                permute(s, l + 1);
	                swap(s, l, i);
	            }
	        }
	    }
	    
	    public boolean isPalindrome(char[] s) {
	    	String str = String.valueOf(s);
	        int low = 0; int high = str.length()-1;
	        while(low < high)
		 	      if(str.charAt(low++) != str.charAt(high--)) return false;
		 	   return true;
	    }	    
	    
	    public void swap(char[] s, int i, int j) {
	        char temp = s[i];
	        s[i] = s[j];
	        s[j] = temp;
	    }

}
