package strings;
/*
 Write a function that takes a string as input and returns the string reversed in Place.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(reverseString(s));

	}

	public static String reverseString(String s) {
        int left =0,right=s.length()-1;
        char[] c = s.toCharArray();
       
        while(left < right){
            
            swap(c,left,right);
            left++;
            right--;
            
        }
        return String.valueOf(c);
   }
   
   private static void swap(char[] c, int left, int right){
       char temp = c[left];
       c[left] = c[right];
       c[right] = temp;
   }
}
