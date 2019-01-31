package stanford;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
THIS SHOULD WORK FOR ANY SUM , change anySum( ) method to have count 3 or 4 for 3Sum or 4Sum

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class AnySum {

	public static void main(String[] args) {

		int[] nums = {1,0,-1,0,-2,2};
		AnySum as = new AnySum();
		int target = 1;
		int whichSum = 4 ;// or 3Sum or 2Sum or 5Sum or 6Sum
		
		List<List<Integer>> list = as.anySum(nums,target,whichSum);
		System.out.println(list);
	}

	public List<List<Integer>> anySum(int[] nums, int target,int whichSum) {
    	Arrays.sort(nums);
    	return findSum(nums, target, whichSum, 0);
    }
    
    private List<List<Integer>> findSum(int[] nums, int target, int count, int start) {
    	List<List<Integer>> results = new LinkedList<>();
    	if(count == 1) {
    		for(int i = start; i < nums.length; i ++) {
    			if(nums[i] == target) {
    				List<Integer> list = new LinkedList<>();
    				list.add(nums[i]);
    				results.add(list);
    				break;
    			}
    		}
    		return results;
    	}
    	
    	for(int i = start; i <= nums.length - count; i ++) {
    		if(target > 0 && nums[i] > target || target < 0 && nums[i] >= 0) {
    			break;
    		}
    		if(i > start && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		List<List<Integer>> lists = findSum(nums, target - nums[i], count - 1, i + 1);
    		for(List<Integer> list: lists) {
    			list.add(0, nums[i]);
    			results.add(list);
    		}
    	}

		return results;
    }	
}
