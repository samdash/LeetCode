package arrays;

/* a child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps
 * at a time. Implement a method to count how many possible ways the child can run up the stairs */
public class StairCase {

	public static void main(String[] args) {
		 
		System.out.println(climbStairs(3));
	}

	//O(2 power N)
	public static int climbStairs(int n) {
        return climb_Stairs(0, n);
    }
    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
    
	// O(N)
    public static int climbStairsMemo(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
    
/**
 Output Explanation :
1 -> 1 -> 1 -> 1
1 -> 1 -> 2
1 -> 2 -> 1
1 -> 3
2 -> 1 -> 1
2 -> 2
3 -> 1

So Total ways: 7
 */
}
