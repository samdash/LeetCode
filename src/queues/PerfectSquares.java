package queues;

import java.util.Arrays;

/*
 
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

	
	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		int value = ps.numSquares(12);
		System.out.println(value);
	}

	public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        int i = 0;
        while (++i * i <= n) {
            for (int j = i * i; j < memo.length; j++) {
                memo[j] = Math.min(memo[j], memo[j - (i * i)] + 1);
            }
        }
        return memo[n];
        
    }
	
	
}
