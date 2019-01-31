package arrays;

/*
 Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the totalSum of the numbers to the left of the index is equal to the totalSum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The totalSum of the numbers to the left of index 3 (nums[3] = 6) is equal to the totalSum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
Example 2:

Input: 
nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class PivotIndex {

	public static void main(String[] args) {
		 int[] nums = {1, 7, 3, 6, 5, 6};
		 System.out.println(pivotIndex(nums));
		 System.out.println(Equilibrium(nums));
	}
	
	public static int pivotIndex(int[] nums) {
	       int totalSum = 0, leftsum = 0;
	        for (int x: nums) totalSum += x;
	        for (int i = 0; i < nums.length; ++i) {
	            if (leftsum == totalSum - leftsum - nums[i]) {
	            	return i; // totalSum(28) - leftsum(11) - nums[3] 6 = 11
	            }
	            leftsum += nums[i];
	        }
	        return -1;
	    }

	public static int Equilibrium(int[] A) {
	    long sum_right = 0, sum_left = 0;
	    int i = 0, length = A.length;
	    if(length == 0) {
	      return -1;
	    }
	    for(i = 1; i < length; i++) {
	      sum_right += A[i];
	    }
	    for(i = 0; i < length - 1; i++) {
	      if(sum_left == sum_right) {
	        return i;
	      }

	      sum_left += A[i];
	      sum_right -= A[i + 1];

	    }
	    if(sum_left == sum_right) {
	      return length-1;
	    }
	    return -1;
	  }
}
