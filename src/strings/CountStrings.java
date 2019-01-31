package strings;

/*
 input s1 = "xyzabcxabyabctxabc"
 input s2 = "abc";
 
 count how many time s2 occurs in s1
 
 output = 3;
 */

public class CountStrings {

	public static void main(String[] args) {

		String s1 = "xyzabcxabyabctxabc";
		String s2 = "abc";
		int value = countString(s1,s2);
		System.out.println(value);
		
	}
	
	public static int countString(String s1, String s2) {
		int count = 0;
		int index = 0;
		for(int i=0;i<s1.length()-1;i++) {
			
			if(index <= (s1.length() - s2.length())) {
				String t = s1.substring(i, s2.length()+i);
				if(t.equals(s2)) count++;
				
				index ++;
			}
		}
		
		return count;
	}
}