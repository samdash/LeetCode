package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
public class CombinationSumII {

	public static void main(String[] args) {
		//int[] nums = {10,1,2,7,6,1,5};
		int[] nums = {2,3,4,7,6};

		CombinationSumII cs2 = new CombinationSumII();
		List<List<Integer>> list = cs2.combinationSum(nums, 7);
		System.out.println(list);
		cs2.combinationSumIterative(nums, 7);
		
		
	}

	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	    
	}

	private void backtrack(List<List<Integer>> list, List<Integer> chosen, int [] nums, int target, int start){
	    if(target < 0) return;
	    else if(target == 0) list.add(new ArrayList<>(chosen));
	    else{
	        for(int i = start; i < nums.length; i++){
	            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	            chosen.add(nums[i]); //choose 
	            backtrack(list, chosen, nums, target - nums[i], i + 1); // explore
	            chosen.remove(chosen.size() - 1);  // un-choose
	        }
	    }
	} 

	
	public void combinationSumIterative(int[] nums, int target) {
		int start = 0;
		int end = nums.length -1;
		//Arrays.sort(nums);
		while(start < end ) {
			if(nums[start] + nums[end] > target) {
				end --;
			}else if ( nums[start] + nums[end] < target) {
				start++;
			}else {
				// print pairs 
				System.out.println("["+nums[start]+","+nums[end]+"]");
				start++; // or end ++;
			}
		}
		
	}
	
}
