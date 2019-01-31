package arrays;

import java.util.Arrays;

/**

Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,6,5,4,3,2,1] -- > reverse entire array
rotate 2 steps to the right: [5,6,7,4,3,2,1] -- > reverse first part of array
rotate 3 steps to the right: [5,6,7,1,2,3,4] -- > reverse seconds part of array
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */

public class RotateArray {

	public static void main(String[] args) {
		 
		int[] arr = {1,2,3,4,5,6,7};
		rotate(arr,1);
		System.out.println(Arrays.toString(arr));
	}

    
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
