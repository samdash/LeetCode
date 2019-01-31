package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list = threeSum(arr);
		System.out.println(list);

	}

	 public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(nums);
	        System.out.println("Sorted : "+Arrays.toString(nums));
	        for (int i = 0; i < nums.length; i++) {
	        	/*
				nums[i] will become the smallest number among nums[i], nums[left] and nums[right].
				if (nums[i] > 0) break;
				is used to avoid unnecessary computation when the smallest element nums[i] is greater than 0, 
				the sum of nums[i], nums[left] and nums[right] will be definitely greater than 0 and there is no chance to make the sum to be 0 
				for the rest of nums[left] and nums[right]. Because we want to include the sum that is equal to 0, 
				we don't need to do anything for left and right.	  
				
				Since i is the most left of sorted array (smallest value) if it's a positive value then there doesn't exist 
				any negative value on the right of the i element to make it 0.
				
	        	 */
	            if (nums[i] > 0) break;
	            if (i > 0 && nums[i] == nums[i - 1]) continue;
	            int left = i + 1, right = nums.length - 1;
	            while (left < right) {
	            	int sum = nums[i] + nums[left] + nums[right];
	                if (sum > 0) right--;
	                else if (sum < 0) left++;
	                else {
	                	List<Integer> res = new ArrayList<>();
						res.add(nums[i]);
						res.add(nums[left]);
						res.add(nums[right]);
						result.add(res);
	                    //result.add(Arrays.asList(new Integer[]{nums[i],nums[l],nums[r]}));
						left++;
						right--;
	                    while(left < right && nums[left] == nums[left - 1]) left++;
	                    while(left < right && nums[right] == nums[right + 1]) right--;
	                }
	            }
	        }
	        return result;
	    }
}
