package strings;

public class sumOfString {

	public static void main(String[] s) {
		System.out.println(sumStrings("123","37"));
	}
	
	public static String sumStrings(String a, String b){
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();

        int i = num1.length - 1;
        int j = num2.length - 1;

        StringBuilder sumString = new StringBuilder();
        int carry = 0;

        while(i >= 0 || j>= 0){
            int d1 = 0;
            int d2 = 0;

            if (i >= 0) d1 = num1[i--] - '0';
            if (j >= 0) d2 = num2[j--] - '0';

            int sum = d1 + d2 + carry;
            if (sum >= 10){
                carry = sum / 10;
                sum = sum % 10;
            }else carry = 0;

            sumString.insert(0, sum);
        }

        return sumString.toString();
    }
}
