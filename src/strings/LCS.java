package strings;

public class LCS {

	
	public static void main(String[] s) {
		
		String str1 = "abc";
		String str2 = "bc";

		LCS lc = new LCS();
		int value = lc.lcsRecursion(str1.toCharArray(), str2.toCharArray(), 0,0);
		System.out.println(value);
		int v = lc.lcsDP(str1, str2) ;
		System.out.println(v);
	}
	
	public  int lcsRecursion(char[]a, char[] b, int i, int j) {
		if(i == a.length || j == b.length) return 0;
		else if(a[i] == b[j]) {
			return 1+ lcsRecursion(a,b,i+1,j+1);
		}else {
			return Math.max(lcsRecursion(a,b,i+1,j), lcsRecursion(a,b,i,j+1));
		}		
	}
	
	
	
	public int lcsDP( String str1, String str2 ) 
	  { 
		int m=str1.length(), n = str2.length();
	    int matrix[][] = new int[m+1][n+1]; 
	  
	    /* Following steps build matrix[m+1][n+1] in bottom up fashion. Note 
	         that matrix[i][j] contains length of LCS of str1[0..i-1] and str2[0..j-1] */
	    for (int i=0; i<=m; i++) 
	    { 
	      for (int j=0; j<=n; j++) 
	      { 
	        if (i == 0 || j == 0) 
	            matrix[i][j] = 0;  // set all the first row and first column as zero's
	        else if (str1.charAt(i-1) == str2.charAt(j-1) )
	            matrix[i][j] = 1+  matrix[i-1][j-1]; // get above diagonal value and add one
	        else
	            matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]); // get the max of previous row and previous column.
	      } 
	    } 
	  return matrix[m][n];  // result will be in the last row and last column
	  } 
	
	
	
}
