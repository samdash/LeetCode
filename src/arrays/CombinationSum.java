package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class CombinationSum {

	public static void main(String[] args) {

		int[] nums = {2,3,4,7,6};
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> list = cs.combinationSum(nums, 7);
		System.out.println(list);
	}

	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    //Arrays.sort(nums);
	    System.out.println(Arrays.toString(nums));
	    backtrack(list, new ArrayList<>(), nums, target);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> chosen, int [] nums, int target){
		indent(chosen.size());
		String temp = "backtrack(\"chosen "+chosen+"\",\" target: "+target+"\")";
		System.out.println(temp);

	    if(target < 0) return;
	    else if(target == 0) list.add(new ArrayList<>(chosen));
	    else{ 
	        for(int i = 0; i < nums.length; i++){
	            chosen.add(nums[i]);
	            backtrack(list, chosen, nums, target - nums[i]); 
	            chosen.remove(chosen.size() - 1);
	        }
	    }
	}
	
	public static void indent(int n) {
		for(int i=0;i<n;i++)System.out.print("    ");
	}

}
