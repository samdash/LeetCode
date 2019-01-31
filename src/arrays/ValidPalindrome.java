package arrays;

public class ValidPalindrome {

	public static void main(String[] args) {
		 String s = "baab";
		 System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		
		int left = 0;
		int right = s.length() -1;
		
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
                return false;
            }else {
				left++;
				right--;
			}
		}
		
		return true;
	}

}
