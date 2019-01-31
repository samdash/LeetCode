package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class PermutationsWithDuplicates {

	public static void main(String[] args) {

		int[] nums = {1,1,2};
		PermutationsWithDuplicates pwd = new PermutationsWithDuplicates();
		List<List<Integer>>list = pwd.permuteUnique(nums);
		System.out.println(list);
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> chosen, int [] nums, boolean [] used){
	    if(chosen.size() == nums.length){
	        list.add(new ArrayList<>(chosen));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            chosen.add(nums[i]);
	            backtrack(list, chosen, nums, used);
	            used[i] = false; 
	            chosen.remove(chosen.size() - 1);
	        }
	    }
	}
}
