package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class SubsetsDistinctBacktrack {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		SubsetsDistinctBacktrack sd = new SubsetsDistinctBacktrack();
		List<List<Integer>> list = sd.subsets(nums);
		//System.out.println(list);
	}

	// solving this using back tracking
	
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    System.out.println(Arrays.toString(nums));
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> chosen, int [] nums, int start){
		indent(chosen.size());
		String temp = "backtrack(\""+chosen+"\",\""+start+"\")";
		System.out.println(temp);
	    list.add(new ArrayList<>(chosen));
	    System.out.println(list);
	    for(int i = start; i < nums.length; i++){
	        chosen.add(nums[i]); // choose one
	        backtrack(list, chosen, nums, i + 1);// explore 
	        chosen.remove(chosen.size() - 1); // un-choose
	    }
	}
	
	public static void indent(int n) {
		for(int i=0;i<n;i++)System.out.print("    ");
	}
}
