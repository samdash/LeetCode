package arrays;

/*
 Consecutive Sum
Given a long integer, find the number of ways to represent it as a sum of two or more consecutive positive integers.
 
For example, consider the number 21. It can be expressed as the sums of [1, 2, 3, 4, 5, 6], [6, 7, 8] and [10, 11]. 
There are 3 ways to sum to 21 using consecutive positive integers.
 
Function Description 
Complete the function consecutive in the editor below. 
The function must return an integer denoting the number of ways to represent num as a sum of two or more consecutive positive integers.
 
consecutive has the following parameter(s):
    num:  the integer to sum to
 
Constraints
1 ≤ num ≤ 1012

Explanation
There are three ways to calculate num = 15 as a sum of two or more consecutive integers:
 
1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 =15
 
Thus, the function returns 3.

 */
public class ConsecutiveSum {

	public static void main(String[] args) {

		System.out.println(consecutiveNumbersSum(21));
		System.out.println(consecutiveNumbersSumII(15));

	}

//	public static int consecutive(long nums) {
//	    // Write your code here
//	        int count = 0;
//	        for (int L = 1; L * (L + 1) < 2 * nums; L++) {
//	            float a = (float) ((1.0 * nums - (L * (L + 1)) / 2) / (L + 1));
//	            if (a - (int) a == 0.0)
//	                count++;
//	        }
//	        return count;
//	    }

	public static int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int start = 1; start <= N; ++start) {
            int target = N, x = start;
            while (target > 0) {
                target -= x++;
                //System.out.println(target);
            }
            if (target == 0) ans++;
        }
        return ans;
    }
	
	public static int consecutiveNumbersSumII(int N) {
	    int ans = 0;
	    for(int i = 1, n = N - 1; n >= 0; n -= ++i)
	        if ((n % i) == 0) ans++;
	    return ans;
	}
}
