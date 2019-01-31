package stanford;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */
public class Permutations {

	public static void main(String[] args) {

		int[] nums = {1,2,3};
		Permutations p = new Permutations();
		List<List<Integer>> list = p.permute(nums);
		System.out.println(list);
	}
	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

	private void backtrack(List<List<Integer>> list, List<Integer> chosen, int [] nums){
	   if(chosen.size() == nums.length){
	      list.add(new ArrayList<>(chosen));
	   } else{
	      for(int i = 0; i < nums.length; i++){ 
	         if(chosen.contains(nums[i])) continue; // element already exists, skip
	         chosen.add(nums[i]); // choose 
	         backtrack(list, chosen, nums); // explore 
	         chosen.remove(chosen.size() - 1); // un-choose
	      }
	   }
	} 
}
