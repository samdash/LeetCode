package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumII {

	public static void main(String[] args) {

		int[] nums = {-2,-1,0,0,1,2};
		List<List<Integer>> result = fourSum(nums,0);
		System.out.println(result);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target){
		
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length - 3 ; i++) {
			if(i != 0 && nums[i] == nums[i-1]) continue; // handle duplicates
			
			for(int j=i+1;j<nums.length -2; j++) {
				if(j!= i+1 && nums[j] == nums[j-1]) continue; // handle duplicates
				
				int left = j+1;
				int right = nums.length - 1 ;
				while(left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if( sum < target) {
						left ++;
					}else if( sum > target) {
						right --;
					}else {
						List<Integer> res = new ArrayList<>();
						res.add(nums[i]);
						res.add(nums[j]);
						res.add(nums[left]);
						res.add(nums[right]);
						result.add(res);
						
						left++;
						right--;
						
						while(left < right && nums[left] == nums[left -1]) left++;
						while(left < right && nums[right] == nums[right +1]) right--;
						
						
					}
				}
			}
		}
		
		return result;
	}
}
