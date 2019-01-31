package arrays;

import java.util.Arrays;

/*
 Mary has three sticks and wants to determine whether she can use them to form a non-degenerate triangle.  
 That is, the three can be laid tip-to-tip to form a triangle with non-zero angles at each intersection. 
 For instance, sticks of lengths [3, 4, 5] will make a non-degenerate triangle while [1, 1, 5] will not.
Function Description
Complete the function triangleOrNot in the editor below. 
The function must return an array of n strings where the value at each index i is Yes if a[i], b[i], and c[i] can form a non-degenerate triangle; otherwise, it's No.
 
triangleOrNot has the following parameter(s):
    a[a[0],...a[n-1]]:  array of n integers where each index i describes the length of side a for triangle i
    b[b[0],...b[n-1]]:  array of n integers representing lengths of sides b[i]
    c[c[0],...c[n-1]]:  array of n integers representing lengths of sides c[i]
Constraints
1 ≤ n ≤ 105
1 ≤ a[i], b[i], c[i] ≤ 103 , where 0 ≤ i < n

We want to check the following n = 3 possible triangles using the values given by a = [7, 10, 7], b = [2, 3, 4], and c = [2, 7, 4]:
a[0] = 7, b[0] = 2, and c[0] = 2 don't form a valid, non-degenerate triangle, so we store No in index 0 of our return array.
a[1] = 10, b[1] = 3, and c[1] = 7 don't form a valid, non-degenerate triangle, so we store No in index 1 of our return array.
a[2]= 7, b[2]= 4, and c[2] = 4 do form a valid, non-degenerate triangle, so we store Yes in index 2 of our return array.

We then return the array ["No", "No", "Yes"] as our answer.

 */
public class TriangleOrNot {

	public static void main(String[] args) {
		
		int[] a = {7, 10, 7};
		int[] b = {2, 3, 4};
		int[] c = {2, 7, 4};
		
		System.out.println(Arrays.toString(triangleOrNot(a, b, c)));
		
	}

	
	public static String[] triangleOrNot(int[] a, int[] b, int[] c) {
        String[] str = new String[a.length];
        for(int i=0;i<= a.length -1;i++) {
        if(isValidTriangle(a[i], b[i], c[i])) 
            str[i] = "Yes";
        else str[i] = "No";
        }

        return str;
         
    }
    public static boolean isValidTriangle(int a, int b, int c){
        if((a+b)>c && (a+c)>b && (b+c)>a) {
            return true;
        }else {
            return false;
        }

    }
}
