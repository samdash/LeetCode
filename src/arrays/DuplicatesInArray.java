package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class DuplicatesInArray {

	public static void main(String[] args) {

		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(containsDuplicate(nums));
	}
	
	public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1]) // once you sort it, you can check elements sequentially 
                return true;
        }
        return false;
        
    }
	
	public static boolean containsDuplicateUsingMap(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], true);
        }
        return false;
    }

}
