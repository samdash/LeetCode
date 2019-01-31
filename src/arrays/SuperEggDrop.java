package arrays;

/*
You are given K eggs, and you have access to a building with N floors from 1 to N. 
Each egg is identical in function, and if an egg breaks, you cannot drop it again.
You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N). 
Your goal is to know with certainty what the value of F is.
What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?

 

Example 1:

Input: K = 1, N = 2
Output: 2
Explanation: 
Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
If it didn't break, then we know with certainty F = 2.
Hence, we needed 2 moves in the worst case to know what F is with certainty.
Example 2:

Input: K = 2, N = 6
Output: 3
Example 3:

Input: K = 3, N = 14
Output: 4
 */

public class SuperEggDrop {

	public static void main(String[] args) {
		SuperEggDrop sed = new SuperEggDrop();
		int K = 2,N = 6; 
				
		int result = sed.superEggDrop(K, N);
		System.out.println(result);
		result = sed.superEggDrop2(K, N);
		System.out.println(result);

	}

	/*
	Drop eggs is a very classical problem.
	Some people may come up with idea O(KN^2)
	where dp[K][N] = 1 + max(dp[K - 1][i - 1],dp[K][N - i]) for i in 1...N.
	However this idea is very brute force, for the reason that you check all possiblity.
	
	So I consider this problem in a different way:
	dp[M][K]means that, given K eggs and M moves,
	what is the maximum number of floor that we can check.
	
	The dp equation is:
	dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
	which means we take 1 move to a floor,
	if egg breaks, then we can check dp[m - 1][k - 1] floors.
	if egg doesn't breaks, then we can check dp[m-1][k] , which means we still have k eggs but m-1 movement.
	
	dp[m][k] is similar to the number of combinations and it increase exponentially to N
	
	Time Complexity:
	O(KlogN) Time, O(NK) Space	 
	*/
	 public int superEggDrop(int K, int N) {
	        int[][] dp = new int[N + 1][K + 1];
	        int m = 0;
	        while (dp[m][K] < N) {
	            ++m;
	            for (int k = 1; k <= K; ++k)
	                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
	        }
	        return m;
	    }

		/*
		Optimized to 1D DP
		Time Complexity:
		C++/Java O(KlogN) Time, O(K) Space
		*/
	    public int superEggDrop2(int K, int N) {
	        int dp[] = new int[K + 1], m = 0;
	        for (m = 0; dp[K] < N; ++m)
	            for (int k = K; k > 0; --k)
	                dp[k] += dp[k - 1] + 1;
	        return m;
	    }
}
