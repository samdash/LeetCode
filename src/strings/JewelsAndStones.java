package strings;

/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, 
so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */
public class JewelsAndStones {

	public static void main(String[] args) {

		String J = "aA";
		String S = "aAAbbbb";
		 
		
		int result = count(J,S);
		System.out.println(result);
	}
	
	
	public static int count(String j, String s) {
		
		int[] arr = new int[128];
		for(int i=0;i<j.length();i++) {
			arr[j.charAt(i)]++;
		}
		int count = 0;
		for(int k=0;k<s.length()-1;k++) {
			if(arr[s.charAt(k)]==1) {
				count++;
			}
		}
		
		return count;
	}

}
