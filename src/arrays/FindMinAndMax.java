package arrays;

import java.util.Arrays;

public class FindMinAndMax {

	public static void main(String[] args) {
		int[] nums = {20,34,21,-87,92};
		FindMinAndMax fmm = new FindMinAndMax();
		int[] ans = fmm.helper(nums);
		System.out.println(Arrays.toString(ans));
	}

	public int[] helper(int[] nums) {
		int[] answer= new int[2];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			if( nums[i] > max) max = nums[i];
			else if(nums[i]< min) min = nums[i];
		}
		
		answer[0] = max;
		answer[1] = min;
		
		return answer;
	}
}
