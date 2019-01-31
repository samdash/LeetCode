package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSum {

	public static void main(String[] args) {
		 int[] arr = {2,7,11,15};
		 int target = 9;
		 System.out.println(Arrays.toString(twoSum(arr,target)));
		 List<List<Integer>> list = two(arr,target);
		 System.out.println(list);
	}

	private static int[] twoSum(int[] arr,int target) {
		 
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			int value = target - arr[i];
			if(map.containsKey(value)) {
				return new int[] {map.get(value),i+1};
			}else {
				map.put(arr[i], i+1);
			}
		}
		
		
		return new int[] {-1,-1};
	}
	
	public static List<List<Integer>> two ( int[] nums,int target){
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list,new ArrayList<>(),nums,target,0);
		return list;
	}
	
	public static void backtrack(List<List<Integer>> list, List<Integer> chosen, int[] nums,int target, int start) {
		
		if( target < 0) return;
		if(target == 0 ) {
			list.add(new ArrayList<>(chosen));
		}
		for(int i= start;i<nums.length;i++) {
			chosen.add(nums[i]);
			backtrack(list,chosen,nums,target - nums[i],i+1);
			chosen.remove(chosen.size() - 1);
		}
		
	}
	public int[] twoSumII(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] res = new int[2];
        while(l < r) {
            if(numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }
            else if(numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        
        return res;
    }
	

}
