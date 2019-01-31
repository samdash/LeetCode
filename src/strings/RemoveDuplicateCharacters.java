package strings;

import java.util.Arrays;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {

		String value = "samar";
		String result = removeDuplicateLetters(value);
		System.out.println(result);
		
		result = removeDuplicates(value.toCharArray());
		System.out.println(result);

	}

	public static String removeDuplicateLetters(String s) {
        if( s.length()<2 )
            return s;
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();
        
        while( s.length()>0 ){
            for( int i=0; i<s.length(); i++ )
                count[ s.charAt(i)-'a' ]++; 
            
            int pos=0; 
            for( int i=0; i<s.length(); i++ ){
                if( s.charAt(i) < s.charAt(pos) )  //always choose the left lexically smallest char 
                    pos = i;
                
                //if a char will not appear in the following sequence, stop here, otherwise the chars of the result may not be in correct order,
                //e.g. "eeffga", 'a' will be selected first;  we must maintain the relative order of chars in the result according to the input
                if( --count[s.charAt(i)-'a'] == 0 )
                    break;
            }
            
            result.append( s.charAt(pos) );
            s = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");
            // reset the count array
            Arrays.fill(count, 0);
        }
        
        return result.toString(); 
    }
	
	
	public String removeDuplicateLettersRecursive(String s) {
        if (s.isEmpty()) return s;
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        int pos = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--count[s.charAt(i) - 'a'] == 0) break;
        }
        return s.charAt(pos) + removeDuplicateLettersRecursive(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	/*
	Since one or two additional variables are fine but no buffer is allowed, 
	you can simulate the behaviour of a hashmap by using an integer to store bits instead. 
	This simple solution runs at O(n), which is faster than yours. Also, it isn't conceptually complicated and in-place	 
	
	The drawback is that the duplicates (which are replaced with 0's) will not be placed at the end of the str[] array. 
	However, this can easily be fixed by looping through the array one last time. 
	Also, an integer has the capacity for only regular letters.


	 */
	public static String removeDuplicates(char[] str) {
        int map = 0;
        for (int i = 0; i < str.length; i++) {
            if ((map & (1 << (str[i] - 'a'))) > 0) // duplicate detected
                str[i] = 0;
            else // add unique char as a bit '1' to the map
                map |= 1 << (str[i] - 'a');
        }
        
        return new String(str);
    }
	
}
