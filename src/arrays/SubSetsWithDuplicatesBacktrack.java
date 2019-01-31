package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class SubSetsWithDuplicatesBacktrack {

	public static void main(String[] args) {

		int[] nums = {1,2,2};
		SubSetsWithDuplicatesBacktrack swd = new SubSetsWithDuplicatesBacktrack();
		List<List<Integer>> list = swd.subsetsWithDup(nums);
		System.out.println(list);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> chosen, int [] nums, int start){
	    list.add(new ArrayList<>(chosen));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	        chosen.add(nums[i]);
	        backtrack(list, chosen, nums, i + 1);
	        chosen.remove(chosen.size() - 1);
	    }
	} 
}
