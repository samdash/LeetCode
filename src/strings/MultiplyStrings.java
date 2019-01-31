package strings;

public class MultiplyStrings {
	
	/**
			index 1                   1 2 3  		index i
			index 0   					4 5			index j
			
									1  5
								 1	0
							  5	 0
							  
			-----------------------------------
			index[]1,2]			  1	 2
							  0	  8					indices [i+j,i+j+1]
						  0	  4	
						  
				   index[ 1,  2,  3,  4]
						  
	 */
	
	
	public static void main(String[] s) {
		System.out.println(multiply("123","45"));
	}
	public static String multiply(String num1, String num2) {
	    int m = num1.length(), n = num2.length();
	    int[] pos = new int[m + n];
	   
	    for(int i = m - 1; i >= 0; i--) {
	        for(int j = n - 1; j >= 0; j--) {
	            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
	            int p1 = i + j, p2 = i + j + 1;
	            int sum = mul + pos[p2];

	            pos[p1] += sum / 10;
	            pos[p2] = (sum) % 10;
	        }
	    }  
	    
	    StringBuilder sb = new StringBuilder();
	    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
	    return sb.length() == 0 ? "0" : sb.toString();
	}
}
