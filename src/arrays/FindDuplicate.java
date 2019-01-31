package arrays;
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */

import java.util.HashSet;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] nums = {3,1,3,4,2};
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        
        int ptr1 = nums[0];
        while(ptr1 != fast) {
            ptr1 = nums[ptr1];
            fast = nums[fast];
        }
        return ptr1;
    }
	
	
	public int findDuplicateI(int[] nums) {
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i = 0; i<nums.length;i++){
            if(s.contains(nums[i]))
                return nums[i];
            else
                s.add(nums[i]);
        }
        return 0;
    }
}
