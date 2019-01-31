package arrays;

import java.util.TreeSet;

/*
 Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int size = lis.lengthOfLIS_II(nums);
		System.out.println(size);

	}

	public int lengthOfLIS(int[] nums) {
	    int[] tails = new int[nums.length];
	    int size = 0;
	    for (int x : nums) {
	        int i = 0, j = size;
	        while (i != j) {
	            int m = (i + j) / 2;
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;
	        }
	        tails[i] = x;
	        if (i == size) ++size;
	    }
	    return size;
	}
	
	public int lengthOfLIS_II (int[] nums) {
	    TreeSet<Integer> set = new TreeSet<>();
	    for(int i : nums) {
	        Integer ceil = set.ceiling(i);
	        System.out.println("i-> "+i+"  ceil -->"+ceil);
	        if(null != ceil) {
	            set.remove(ceil);
	        }
	        set.add(i);
	    }
	    return set.size();
	}
}
