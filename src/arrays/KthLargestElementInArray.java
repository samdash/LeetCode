package arrays;

import java.util.Arrays;

/*
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
public class KthLargestElementInArray {

	public static void main(String[] args) {
		
	}

	/*
	 This problem is well known and quite often can be found in various text books.
	You can take a couple of approaches to actually solve it:

	O(N lg N) running time + O(1) memory
	The simplest approach is to sort the entire input array and then access the element by it's index (which is O(1)) operation:
	 */
	public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums) ;
        return nums[nums.length-k];
    } 
}
