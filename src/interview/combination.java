import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
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
public class CombinationSum {

	public static void main(String[] args) {
		int[] nums = {10,1,2,7,6,3};
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> list = cs.combinationSum2(nums, 8);
		System.out.println("output --> "+list);

	}

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    System.out.println(Arrays.toString(nums));
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	    
	}

	private void backtrack(List<List<Integer>> list, List<Integer> chosen, int [] nums, int target, int start){
		indent(chosen.size());
		String temp = "backtrack(\"chosen "+chosen+"\",\" target: "+target+"\")";
		System.out.println(temp);
	    if(target < 0) return;
	    else if(target == 0) {
	    	System.out.println(chosen);
	    	list.add(new ArrayList<>(chosen));
	    }
	    else{
	        for(int i = start; i < nums.length; i++){
	            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	            chosen.add(nums[i]);
	            backtrack(list, chosen, nums, target - nums[i], i + 1);
	            chosen.remove(chosen.size() - 1); 
	        }
	    }
	} 
	
	public static void indent(int n) {
		for(int i=0;i<n;i++)System.out.print("    ");
	}
}
