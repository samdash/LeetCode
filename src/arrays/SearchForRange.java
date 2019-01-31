package arrays;

import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 */
public class SearchForRange {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		SearchForRange sfr = new SearchForRange();
		int[] result = sfr.searchRange(nums, 8);
		System.out.println(Arrays.toString(result));
	}

	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

        private int findFirst(int[] nums, int target){
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(target == nums[mid] ) idx = mid;
                if(target <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            return idx;
        }

        private int findLast(int[] nums, int target){
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(target == nums[mid] ) idx = mid;
                if(target >= nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            return idx;
        }
    
}
