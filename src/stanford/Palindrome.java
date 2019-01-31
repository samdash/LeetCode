package stanford;

public class Palindrome {

	public static void main(String[] args) {

		String pal = "malayalam";
		Palindrome p = new Palindrome();
		boolean value = p.isPalindrome(pal);
		System.out.println(value);
	}

	public boolean isPalindrome(String s) {
		if(s.length() <=1) return true;
		else {
			char first = s.charAt(0);
			char last = s.charAt(s.length() -1);
			String middle = s.substring(1, s.length() - 1) ;
			return(first == last && isPalindrome(middle));
		}
	}
	
}
