package strings;

public class Palindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {

        String ss = getAlphanumeric(s); // remove "," and spaces and convert to lowercase
        int left =0, right= ss.length()-1;

        while(left < right){
            if( ss.charAt(left) == ss.charAt(right)){
                left ++ ;
                right --;
            }else return false;
        }
        return true;
    }

	private static String getAlphanumeric(String s) {
		
		char[] c = s.toCharArray();
		String ss = "";
		for(int i=0;i<c.length;i++) {
			if(Character.isLetterOrDigit(c[i])) {
				ss+=c[i];
			}
		}
		
		return ss.toLowerCase();
	}
}
