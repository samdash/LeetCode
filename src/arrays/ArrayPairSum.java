package arrays;

import java.util.Arrays;
/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) 
which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:

Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:

n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
*/


/* 
 Solution: First sort the input array, then pair up elements next to each other that way we dont
        loose much to Math.min() between pair   
 */
public class ArrayPairSum {

	public static void main(String[] args) {
		 int[] arr = {1,4,2,3};
		 System.out.println(arrayPairSum(arr));
	}
	public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // 1,2,3,4
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
        	//  result = result+ Math.min(nums[i],nums[i+1]); // since arrays is sorted we don't need to do Math.min
            result += nums[i]; 
        }
        return result;
    }
	
}
